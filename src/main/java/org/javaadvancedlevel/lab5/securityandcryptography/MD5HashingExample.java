package org.javaadvancedlevel.lab5.securityandcryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /*
        Generates an MD5 hash of a message.

         */
        String message = "Hello, World!";
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(message.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        System.out.println("MD5 Hash: " + hexString.toString());
    }
}
