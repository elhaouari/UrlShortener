package com.elhaouari.urlshortener;

import java.util.Random;

public class StringGenerator {

    public static String generateRandomString(String from, int bound) {
        Random random = new Random();
        StringBuilder suffix = new StringBuilder();
        for (int i = 0; i < bound; i++) {
            int index = random.nextInt(from.length());
            suffix.append(from.charAt(index));
        }
        return suffix.toString();
    }
}
