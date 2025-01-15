package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Logika {
    /**
     * Method to generate the SHA-256 hash
     * @param input String we want to hash
     * @return String representation of a hash
     */
    public static String computeSHA256Hash(String input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());
            return byteArrayToHexString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to generate the MD5 hash
     * @param input String we want to hash
     * @return String representation of a hash
     */
    public static String computeMD5Hash(String input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());
            return byteArrayToHexString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Helper method to convert a byte array to a hex String
     * @param bytes Array of bytes we want to convert
     * @return Hex String representation of the array
     */
    private static String byteArrayToHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        String hexString = formatter.toString();
        formatter.close();
        return hexString;
    }

}
