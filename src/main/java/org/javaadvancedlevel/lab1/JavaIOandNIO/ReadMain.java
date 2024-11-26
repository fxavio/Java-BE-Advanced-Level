package org.javaadvancedlevel.lab1.JavaIOandNIO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadMain {
    private static final Logger LOGGER = Logger.getLogger(ReadMain.class.getName()); // Create a Logger instance

    public static void main(String[] args) {
        try {
            // Create a RandomAccessFile instance that allows reading and writing to the file at a specific location
            RandomAccessFile file = new RandomAccessFile("src/JavaIOandNIO/test.txt", "rw");

            // Get a FileChannel from the RandomAccessFile instance
            FileChannel channel = file.getChannel();

            // Create a ByteBuffer with a capacity of 4096 bytes
            ByteBuffer buffer = ByteBuffer.allocate(4096);

            // Read data from the FileChannel into the ByteBuffer and store the number of bytes read
            int bytesRead = channel.read(buffer);

            // Continue reading until there is no more data (-1 is returned)
            while (bytesRead != -1) {
                // Print the number of bytes read
                System.out.println("Read " + bytesRead);

                // Flip the buffer to prepare it for reading
                buffer.flip();

                // Continue reading from the buffer until there is no more data
                while (buffer.hasRemaining()) {
                    // Print the data read from the buffer as a char
                    System.out.print((char) buffer.get());
                }

                // Clear the buffer to prepare it for writing
                buffer.clear();

                // Read more data from the FileChannel into the ByteBuffer
                bytesRead = channel.read(buffer);
            }

            // Close the file
            file.close();
        } catch (Exception e) {
            // Log the exception with a severe level
            LOGGER.log(Level.SEVERE, "An exception occurred", e);
        }
    }
}