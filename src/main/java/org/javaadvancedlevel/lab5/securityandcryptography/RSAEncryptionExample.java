package org.javaadvancedlevel.lab5.securityandcryptography;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAEncryptionExample {
    public static void main(String[] args) throws Exception {
        /*
        Generates an RSA key pair.
        Encrypts a message using the RSA public key.
        Encodes the encrypted message in Base64.
        Decrypts the Base64 encoded message back to the original message using the RSA private key.
         */

        // Generate RSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("Public Key: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("Private Key: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // Original message
        String message = "Hello, World!";

        // Encrypt the message
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        String decryptedMessage = new String(decryptedBytes);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
