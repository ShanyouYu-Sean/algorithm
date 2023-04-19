package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class WebServer {

    public static void main(String[] args) {

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()){
            serverSocketChannel
                    .socket()
                    .bind(new InetSocketAddress("127.0.0.1", 8000));
            SocketChannel socketChannel = serverSocketChannel.accept();

            ByteBuffer readByteBuffer = ByteBuffer.allocate(128);
            socketChannel.read(readByteBuffer);

            readByteBuffer.flip();
            while (readByteBuffer.hasRemaining()){
                System.out.println((char) readByteBuffer.get());
            }

            socketChannel.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
