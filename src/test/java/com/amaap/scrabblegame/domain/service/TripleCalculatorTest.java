package com.amaap.scrabblegame.domain.sevice;

import com.amaap.scrabblegame.domain.sevice.impl.TripleCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripleCalculatorTest {
    @Test
    void shouldBeAbleToTripleTheLetter() {
        // arrange
        TripleCalculator tripleCalculator = new TripleCalculator();
        String word = "SCRABBLE";
        char letterToTriple = 'S';

        // act
        int score = tripleCalculator.TripleALetter(letterToTriple, word);

        // assert
        assertEquals(3, score);
    }

}