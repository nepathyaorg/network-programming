import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.io.IOException;

public class EchoServer {
    public static int DEFAULT_PORT = 7;

    public static void main(String[] args) {
        int port;
        ServerSocket ss=null;
        // Parse port from command-line arguments, or use the default
        try {
            port = Integer.parseInt(args[0]);
        } catch (RuntimeException ex) {
            port = DEFAULT_PORT;
        }
        
        System.out.println("Listening for connections on port " + port);

        try {
            // Create a non-blocking server socket channel
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            ss=serverChannel.socket();
            ss.bind(new InetSocketAddress(port));
            serverChannel.configureBlocking(false);
            
            // Create a selector to handle multiple connections
            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select(); // Wait for an event
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();

                    try {
                        if (key.isAcceptable()) {
                            // Accept new client connection
                            ServerSocketChannel server = (ServerSocketChannel) key.channel();
                            SocketChannel client = server.accept();
                            System.out.println("Accepted connection from " + client);
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(100));
                        } else if (key.isReadable()) {
                            // Read data from client
                            SocketChannel client = (SocketChannel) key.channel();
                            ByteBuffer buffer = (ByteBuffer) key.attachment();
                            int bytesRead = client.read(buffer);
                            if (bytesRead == -1) {
                                key.cancel();
                                client.close();
                                continue;
                            }
                            buffer.flip(); // Prepare buffer for writing
                            key.interestOps(SelectionKey.OP_WRITE);
                        } else if (key.isWritable()) {
                            // Write data back to client (Echo)
                            SocketChannel client = (SocketChannel) key.channel();
                            ByteBuffer buffer = (ByteBuffer) key.attachment();
                            client.write(buffer);
                            buffer.compact(); // Prepare buffer for more data
                            key.interestOps(SelectionKey.OP_READ);
                        }
                    } catch (IOException ex) {
                        key.cancel();//it is used for to cancel key
                        try {
                            key.channel().close();//it is used to close the connection
                        } catch (IOException ignore) {}
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Server error: " + ex.getMessage());
        }finally{
            if(ss!=null){
       try{
       
        ss.close();
       }catch(IOException ex){
        //
       }
        }}
    }
}
