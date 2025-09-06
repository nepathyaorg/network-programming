import java.nio.ByteBuffer;

public class BufferOperations {
    public static void main(String[] args) {
        // Fill buffer
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (byte i = 0; i < 10; i++) {
            buffer.put(i);
        }

        // Flip (prepare for reading)
        buffer.flip();

        // Drain buffer
        System.out.print("Draining buffer: ");
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }

        // Refill
        buffer.clear();
        for (byte i = 10; i < 20; i++) {
            buffer.put(i);
        }

        // Duplicate
        ByteBuffer duplicate = buffer.duplicate();
        duplicate.flip();
        System.out.print("\nDuplicate buffer: ");
        while (duplicate.hasRemaining()) {
            System.out.print(duplicate.get() + " ");
        }

        // Slice buffer
        buffer.position(2);
        buffer.limit(6);
        ByteBuffer slice = buffer.slice();
        System.out.print("\nSliced buffer: ");
        for (int i = 0; i < slice.capacity(); i++) {
            System.out.print(slice.get(i) + " ");
        }

        // Compact
        buffer.clear();
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        buffer.flip();
        buffer.get(); // read one byte
        buffer.compact(); // move remaining bytes to beginning
        buffer.put((byte) 4); // add more
        buffer.flip();
        System.out.print("\nCompact buffer: ");
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
    }
}
