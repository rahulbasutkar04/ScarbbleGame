package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.configuration.PointAllocator;
import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;

public class ScoreCalculator {
    PointAllocator pointAllocator = new PointAllocator();
    Validator validator = new Validator();

    String[] letters = pointAllocator.getLetters();
    int[] points = pointAllocator.getPoints();

    public int getScore(String input) throws EmptyStringException, InValidStringException {

        if (validator.isStringNull(input)) {
            throw new NullPointerException("Input can not be null");
        }
        if (validator.isStringEmpty(input)) {
            throw new EmptyStringException("Input can not be empty");
        }

        if (validator.isStringValid(input)) {
            throw new InValidStringException("Other than String found");
        }

        input = input.toUpperCase();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = 0; j < letters.length; j++) {
                if (letters[j].contains(String.valueOf(c))) {
                    sum += points[j];
                    break;
                }
            }
        }
        return sum;
    }
}

