package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class WebClient {

    public static void main(String[] args) {

        try (SocketChannel socketChannel = SocketChannel.open()){
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            socketChannel.configureBlocking(false);

            ByteBuffer writeByteBuffer =  ByteBuffer.allocate(128);
            ByteBuffer buffer2 = ByteBuffer.allocate(16);
            writeByteBuffer.put("hello".getBytes());
            buffer2.put("world".getBytes());

            writeByteBuffer.flip();
            buffer2.flip();
            ByteBuffer[] bufferArray = {writeByteBuffer, buffer2};
            socketChannel.write(bufferArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
