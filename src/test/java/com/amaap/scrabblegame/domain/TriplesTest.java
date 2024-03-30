package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriplesTest {

    TripleCalculator triples = new TripleCalculator();

    @Test
    void shouldAbleToPerformForTripleTheLetterAfterTheNormalScrabbleSum() throws EmptyStringException, InValidStringException {

        // arrange and act
        int tripledScore = triples.calculateForLetter("RAHUL", 'A');

        // assert
        assertEquals(11, tripledScore);
    }

    @Test
    void shouldAbleToPerformForTripleTheWordAfterTheNormalScrabbleSum() throws EmptyStringException, InValidStringException {

        // arrange & act
        int tripledScore = triples.calculateForWord("RAHUL", "HUL");
        // assert
        assertEquals(26, tripledScore);
    }

    @Test
    void shouldBeAbleToThrowExceptionIfOtherThanStringIsGiven() {

        assertThrows(InValidStringException.class, () -> {
            triples.calculateForWord("123", "rahul");
        });

        assertThrows(InValidStringException.class, () -> {
            triples.calculateForWord("rahul", "@");
        });


        assertThrows(InValidStringException.class, () -> {
            triples.calculateForWord("rahul   ", "rahul");
        });

        assertThrows(InValidStringException.class, () -> {
            triples.calculateForWord("rahu", "        rahul");
        });

    }

    @Test
    void shouldBeAbleToThrowEmptyStringException() {

        assertThrows(EmptyStringException.class, () -> {
            triples.calculateForWord("", "rahul");
        });
    }

}