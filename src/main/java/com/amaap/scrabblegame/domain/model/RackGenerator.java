package com.amaap.scrabblegame.domain.model;

import java.util.Random;

public class RackGenerator {
    private static final String VOWELS = "AEIOU";
    private static final String CONSONANTS = "BCDFGHJKLMNPQRSTVWXYZ";

    public String generateRack() {
        Random random = new Random();
        StringBuilder rackBuilder = new StringBuilder();

        int vowelCount = random.nextInt(3) + 2;
        for (int i = 0; i < vowelCount; i++) {
            int index = random.nextInt(VOWELS.length());
            rackBuilder.append(VOWELS.charAt(index));
        }
        int consonantCount = Math.max(7 - vowelCount, 4);
        consonantCount = Math.min(consonantCount, 15 - vowelCount);
        for (int i = 0; i < consonantCount; i++) {
            int index = random.nextInt(CONSONANTS.length());
            rackBuilder.append(CONSONANTS.charAt(index));
        }

        String rack = rackBuilder.toString();
        char[] rackArray = rack.toCharArray();
        for (int i = rackArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = rackArray[index];
            rackArray[index] = rackArray[i];
            rackArray[i] = temp;
        }

        return new String(rackArray);
    }
}
