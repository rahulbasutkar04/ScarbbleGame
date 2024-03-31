package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;
import com.amaap.scrabblegame.domain.exception.LetterNotPresentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriplesTest {

    TripleCalculator triples = new TripleCalculator();
    @Test
    void shouldAbleToPerformForTripleTheLetterAfterTheNormalScrabbleSum() throws EmptyStringException, InValidStringException, LetterNotPresentException {

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
    void shouldAbleToPerformForTripleTheCompleteWordAfterTheNormalScrabbleSum() throws EmptyStringException, InValidStringException {

        // arrange & act
        int tripledScore = triples.calculateForWord("RAHUL", "RAHUL");

        // assert
        assertEquals(32, tripledScore);
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

    @Test
    void shouldBeAbleThrowLetterNotPresentExceptionWhenLetterToTripleIsNotPresent(){
        assertThrows(LetterNotPresentException.class, () -> {
            triples.calculateForLetter("RAHUL", 'Z');
        });
    }

}