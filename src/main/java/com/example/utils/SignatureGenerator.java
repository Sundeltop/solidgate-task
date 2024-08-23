package com.example.utils;

import lombok.NoArgsConstructor;

import java.util.Base64;

import static com.google.common.hash.Hashing.hmacSha512;
import static java.nio.charset.StandardCharsets.UTF_8;
import static lombok.AccessLevel.PRIVATE;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@NoArgsConstructor(access = PRIVATE)
public class SignatureGenerator {

    public static String generateSignature(String publicKey, String jsonString, String secretKey) {
        final String text = publicKey + jsonString + publicKey;

        byte[] hashedBytes = hmacSha512(secretKey.getBytes())
                .hashString(text, UTF_8).toString().getBytes();

        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    public static String generateSignature(String publicKey, String secretKey) {
        return generateSignature(publicKey, EMPTY, secretKey);
    }
}
