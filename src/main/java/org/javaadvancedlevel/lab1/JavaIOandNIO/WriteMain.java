package org.javaadvancedlevel.lab1.JavaIOandNIO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;


public class WriteMain {
    private static final Logger LOGGER = Logger.getLogger(WriteMain.class.getName());

    public static void main(String[] args) {
        try {
            // Create a RandomAccessFile instance that allows reading and writing to the file at a specific location
            // Path: src/JavaIOandNIO/write.txt
            RandomAccessFile file = new RandomAccessFile("src/JavaIOandNIO/write.txt", "rw");

            // Get a FileChannel from the RandomAccessFile instance
            FileChannel channel = file.getChannel();

            // Create a ByteBuffer with a capacity of 4096 bytes
            ByteBuffer buffer = ByteBuffer.allocate(4096);

            // Write data to the buffer
            buffer.put("Hello, World!".getBytes());

            // Flip the buffer to prepare it for writing
            buffer.flip();

            // Write data from the buffer to the FileChannel
            channel.write(buffer);

            // Clear the buffer to prepare it for reading
            buffer.clear();
            // Close the channel
            // Close the file
            file.close();
            System.out.println("File written successfully");
        } catch (Exception e) {
            // Log the exception with a severe level
            LOGGER.severe("An exception occurred");
        }
    }


}
