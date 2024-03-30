package com.amaap.scrabblegame.configuration;

public class PointAllocator {

    private String[] letters = {"EAIONRTLSU", "DG", "BCMP", "FHVWY", "K", "JX", "QZ"};
    private int[] points = {1, 2, 3, 4, 5, 8, 10};

    public String[] getLetters() {
        return letters;
    }

    public int[] getPoints() {
        return points;
    }
}
