package com.amaap.scrabblegame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublesTest {


    Doubles doubles=new Doubles();

    @Test
    void shouldAbleToPerformForDoubleTheLetterAfterTheNormalScrabbleSum() {


        // Arrange and Act
        int doubledScore = doubles.calculateForLetter("RAHUL", 'A');

        // Assert
        assertEquals(10, doubledScore);

    }

    @Test
    void shouldAbleToPerformForDoubleTheWordAfterTheNormalScrabbleSum() {

        // Arrange and Act
        int doubledScore = doubles.calculateForWord("RAHUL", "HUL");

        // Assert
        assertEquals(20, doubledScore);
    }
}