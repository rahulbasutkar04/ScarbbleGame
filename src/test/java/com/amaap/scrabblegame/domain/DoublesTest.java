package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoublesTest {

    DoubleCalculator doubles = new DoubleCalculator();

    @Test
    void shouldAbleToPerformForDoubleTheLetterAfterTheNormalScrabbleSum() throws EmptyStringException, InValidStringException {

        // arrange & act
        int doubledScore = doubles.calculateForLetter("RAHUL", 'A');

        // assert
        assertEquals(10, doubledScore);

    }

    @Test
    void shouldAbleToPerformForDoubleTheWordAfterTheNormalScrabbleSum() throws EmptyStringException, InValidStringException {

        // arrange & act
        int doubledScore = doubles.calculateForWord("RAHUL", "HUL");

        // assert
        assertEquals(14, doubledScore);
    }

    @Test
    void shouldAbleToPerformForCompleteDoubleTheWordAfterTheNormalScrabbleSum() throws EmptyStringException, InValidStringException {

        // arrange & act
        int doubledScore = doubles.calculateForWord("RAHUL", "RAHUL");

        // assert
        assertEquals(16, doubledScore);
    }

    @Test
    void shouldBeAbleToThrowExceptionIfOtherThanStringIsGiven() {
        assertThrows(InValidStringException.class, () -> {
            doubles.calculateForWord("123", "rahul");
        });

        assertThrows(InValidStringException.class, () -> {
            doubles.calculateForWord("rahul", "@");
        });

        assertThrows(InValidStringException.class, () -> {
            doubles.calculateForWord("rahul   ", "rahul");
        });

        assertThrows(InValidStringException.class, () -> {
            doubles.calculateForWord("rahu", "        rahul");
        });
    }

    @Test
    void shouldBeAbleToThrowEmptyStringException() {
        assertThrows(EmptyStringException.class, () -> {
            doubles.calculateForWord("", "rahul");
        });
    }


}