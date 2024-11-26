package org.javaadvancedlevel.lab1.JavaIOandNIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;

public class CopyMain {
    private static final Logger LOGGER = Logger.getLogger(ReadMain.class.getName()); // Create a Logger instance
    public static void main(String[] args) {
        String sourceFile = "src/JavaIOandNIO/source.txt";
        String destinationFile = "src/JavaIOandNIO/destination.txt";

        try {
            FileInputStream inputStream = new FileInputStream(sourceFile);
            FileOutputStream outputStream = new FileOutputStream(destinationFile);

            FileChannel sourceChannel = inputStream.getChannel();
            FileChannel destinationChannel = outputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (sourceChannel.read(buffer) != -1) {
                buffer.flip(); // Flip the buffer to prepare for writing
                destinationChannel.write(buffer); // Write data from buffer to destination channel
                buffer.clear(); // Clear the buffer for next read
            }

            sourceChannel.close();
            destinationChannel.close();
            inputStream.close();
            outputStream.close();

            System.out.println("File copied successfully.");
        } catch (Exception e) {
           // Log the exception with a severe level
            LOGGER.severe("An exception occurred");
        }
    }
}