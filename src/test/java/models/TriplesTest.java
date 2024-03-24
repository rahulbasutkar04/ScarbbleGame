package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriplesTest {
    @Test
    void shouldAbleToPerformForTripleTheLetterAfterTheNormalScrabbleSum() {

        // Arrange and Act
        int tripledScore = Triples.calculateForLetter("RAHUL", 'A');

        // Assert
        assertEquals(11, tripledScore);
    }

    @Test
    void shouldAbleToPerformForTripleTheWordAfterTheNormalScrabbleSum() {
        // Arrange and Act
        int tripledScore = Triples.calculateForWord("RAHUL", "HUL");

        // Assert
        assertEquals(26, tripledScore);
    }
}