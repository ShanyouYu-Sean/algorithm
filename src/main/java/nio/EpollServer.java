package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class EpollServer {

    public static void main(String[] args) {
        try (ServerSocketChannel ssc = ServerSocketChannel.open()){
            ssc
                    .socket()
                    .bind(new InetSocketAddress("127.0.0.1", 8000));

            // 设置为非阻塞
            ssc.configureBlocking(false);

            try (Selector selector =  Selector.open()){
                // 将selector和channel绑定，并为channel注册SelectionKey.OP_ACCEPT事件
                // 注册该事件后，当事件到达时，selector.select()会返回，如果该事件没有到达selector.select()会一直阻塞。
                ssc.register(selector, SelectionKey.OP_ACCEPT);

                // 设置读写buffer
                ByteBuffer readBuff = ByteBuffer.allocate(1024);
                ByteBuffer writeBuff = ByteBuffer.allocate(128);
                writeBuff.put("received".getBytes());
                writeBuff.flip();

                // 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
                while (true) {
                    // 当注册事件到达时，方法返回；否则，该方法会一直阻塞
                    selector.select();
                    // 获得selector中选中的项的迭代器，选中的项为注册的事件
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> it = keys.iterator();

                    while (it.hasNext()){
                        SelectionKey key = it.next();
                        // 删除已选的key，以防重复处理
                        it.remove();

                        // 获得了客户端请求链接事件
                        if (key.isAcceptable()) {
                            // 获得和客户端连接的通道
                            SocketChannel socketChannel = ssc.accept();
                            // 设置为非阻塞
                            socketChannel.configureBlocking(false);
                            // 把连接注册到selector上，并声明这个channel只对读感兴趣
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }
                        // 获得了可读的事件
                        else if (key.isReadable()) {
                            // 得到事件发生的socket channel
                            SocketChannel socketChannel = (SocketChannel) key.channel();

                            readBuff.clear();
                            socketChannel.read(readBuff);

                            readBuff.flip();
                            System.out.println("received : " + StandardCharsets.UTF_8.decode(readBuff));

                            key.interestOps(SelectionKey.OP_WRITE);
                        }
                        // 获得了写的事件
                        else if (key.isWritable()) {
                            writeBuff.rewind();
                            //  得到事件发生的Socket channel
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            // 向channel写入buffer
                            socketChannel.write(writeBuff);
                            // 告诉selector我们只对读感兴趣
                            key.interestOps(SelectionKey.OP_READ);
                        }
                    }
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
