import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class EchoClient1 {
    public static void main(String[] args) {
         try (SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 7));
             Scanner scanner = new Scanner(System.in)) {
            
            ByteBuffer buffer = ByteBuffer.allocate(256);
            System.out.println("Connected to Echo Server. Type a message (or 'exit' to quit):");

            while (true) {
                System.out.print("> ");
                String message = scanner.nextLine();
                if ("exit".equalsIgnoreCase(message)) break;

                buffer.clear();
                buffer.put(message.getBytes());//writing mode
                buffer.flip();//reading mode
                client.write(buffer);

                buffer.clear();//clear clears and it goes to writing mode
                client.read(buffer);
                buffer.flip();//reading mode
                System.out.println("Server: " + new String(buffer.array(), 0, buffer.limit()));
            }
        }catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
