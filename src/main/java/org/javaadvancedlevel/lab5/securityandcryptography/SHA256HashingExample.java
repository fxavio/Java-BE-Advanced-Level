package org.javaadvancedlevel.lab5.securityandcryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256HashingExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String message = "Hello, World!";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(message.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        System.out.println("SHA-256 Hash: " + hexString.toString());
    }
}
