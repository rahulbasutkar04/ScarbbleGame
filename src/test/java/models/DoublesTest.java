package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublesTest {


    @Test
    void shouldAbleToPerformForDoubleTheLetterAfterTheNormalScrabbleSum() {

        // Arrange and Act
        int doubledScore = Doubles.calculateForLetter("RAHUL", 'A');

        // Assert
        assertEquals(10, doubledScore);

    }

    @Test
    void shouldAbleToPerformForDoubleTheWordAfterTheNormalScrabbleSum() {

        // Arrange and Act
        int doubledScore = Doubles.calculateForWord("RAHUL", "HUL");

        // Assert
        assertEquals(20, doubledScore);
    }
}