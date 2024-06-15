package com.amaap.scrabblegame.domain.service;

import com.amaap.scrabblegame.domain.service.impl.ScrabbleScoreCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScrabbleScoreCalculatorTest {
    @Test
    void shouldBeAbleToCalculateTheNormalScrabbleScore() {
        // arrange
        String word = "SCRABBLE";

        ScrabbleScoreCalculator calculator = new ScrabbleScoreCalculator();

        // act
        int score = calculator.calculateScore(word);

        // assert
        assertEquals(14, score);
    }
}

