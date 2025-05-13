package com.exemplu.entity;
import jakarta.persistence.Entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptare {
    public static String encryptPassword(String password) {
        try {
            // Creează un obiect MessageDigest pentru SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Obține bytes pentru parola
            byte[] encodedHash = digest.digest(password.getBytes());

            // Convertește bytes într-un string hexazecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                hexString.append(String.format("%02x", b));
            }

            // Returnează parola criptată
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // În caz de eroare (ar trebui să fie rar)
            e.printStackTrace();
            return null;
        }
    }
}
