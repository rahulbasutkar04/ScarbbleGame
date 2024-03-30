package com.amaap.scrabblegame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriplesTest {

    Triples triples=new Triples();
    @Test
    void shouldAbleToPerformForTripleTheLetterAfterTheNormalScrabbleSum() {

        // Arrange and Act
        int tripledScore = triples.calculateForLetter("RAHUL", 'A');

        // Assert
        assertEquals(11, tripledScore);
    }

    @Test
    void shouldAbleToPerformForTripleTheWordAfterTheNormalScrabbleSum() {
        // Arrange and Act
        int tripledScore = triples.calculateForWord("RAHUL", "HUL");

        // Assert
        assertEquals(26, tripledScore);
    }
}