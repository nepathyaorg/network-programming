import java.net.*;
import java.nio.channels.*;
import java.util.Set;

public class ListSocketOptions {
    public static void main(String[] args) throws Exception {
        System.out.println("SocketChannel options:");
        SocketChannel socketChannel = SocketChannel.open();
        Set<SocketOption<?>> socketOptions = socketChannel.supportedOptions();
        for (SocketOption<?> option : socketOptions) {
            System.out.println(" - " + option.name());
        }

        System.out.println("\nServerSocketChannel options:");
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Set<SocketOption<?>> serverSocketOptions = serverSocketChannel.supportedOptions();
        for (SocketOption<?> option : serverSocketOptions) {
            System.out.println(" - " + option.name());
        }

        System.out.println("\nDatagramChannel options:");
        DatagramChannel datagramChannel = DatagramChannel.open();
        Set<SocketOption<?>> datagramOptions = datagramChannel.supportedOptions();
        for (SocketOption<?> option : datagramOptions) {
            System.out.println(" - " + option.name());
        }
    }
}
