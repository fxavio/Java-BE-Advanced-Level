package org.javaadvancedlevel.lab5.securityandcryptography;

import java.security.*;
import java.util.Base64;

public class DigitalSignatureExample {
    public static void main(String[] args) throws Exception {
        // Generate RSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Sign the message
        String message = "Hello, World!";
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] digitalSignature = signature.sign();
        String encodedSignature = Base64.getEncoder().encodeToString(digitalSignature);
        System.out.println("Digital Signature: " + encodedSignature);

        // Verify the signature
        signature.initVerify(publicKey);
        signature.update(message.getBytes());
        boolean isVerified = signature.verify(Base64.getDecoder().decode(encodedSignature));
        System.out.println("Signature Verified: " + isVerified);
    }
}
