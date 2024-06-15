package com.amaap.scrabblegame.domain.service;

import com.amaap.scrabblegame.domain.service.impl.DoubleCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleCalculatorTest {

    @Test
    void ShouldBeAbleToDoubleTheLetterAndGiveScore() {
        // arrange
        DoubleCalculator doubleCalculator = new DoubleCalculator();
        String word = "SCRABBLE";
        char letterToDouble = 'S';

        // act
        int score = doubleCalculator.doubleALetter(letterToDouble, word);

        // assert
        assertEquals(2, score);
    }

}