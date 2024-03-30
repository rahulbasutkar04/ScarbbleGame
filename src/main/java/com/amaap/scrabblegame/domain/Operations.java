package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.configuration.PointAllocator;

public class Operations {
    PointAllocator pointAllocator=new PointAllocator();

    String [] letters=pointAllocator.getLetters();
    int [] points =pointAllocator.getPoints();
    public  int help(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = 0; j <letters.length; j++) {
                if (letters[j].contains(String.valueOf(c))) {
                    sum += points[j];
                    break;
                }
            }
        }
        return sum;
    }
}

