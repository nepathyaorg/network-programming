import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class DataConversion {
    public static void main(String[] args) {
        String input = "Hello, buffer world!";
        System.out.println("Original String: " + input);

        // Encode string into ByteBuffer
        Charset charset = StandardCharsets.UTF_8;
        ByteBuffer byteBuffer = charset.encode(input);

        System.out.print("Encoded Bytes: ");
        while (byteBuffer.hasRemaining()) {
            System.out.print(byteBuffer.get() + " ");
        }

        // Rewind and decode
        byteBuffer.rewind();
        CharBuffer decoded = charset.decode(byteBuffer);
        System.out.println("\nDecoded String: " + decoded.toString());
    }
}
