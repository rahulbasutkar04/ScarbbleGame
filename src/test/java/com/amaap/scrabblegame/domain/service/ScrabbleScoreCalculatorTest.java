package com.amaap.scrabblegame.domain.sevice;

import com.amaap.scrabblegame.domain.sevice.impl.ScrabbleScoreCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

