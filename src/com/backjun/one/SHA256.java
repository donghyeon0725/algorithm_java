package com.backjun.one;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        SHA256 sha256 = new SHA256();
        System.out.println(sha256.sha256(text));
    }


    public byte[] sha256 (String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());

        return md.digest();
    }

    public String getString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        // 10진수의 수를 두자리 수 16진수 포멧으로 맞춤
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }

        return builder.toString();
    }
}
