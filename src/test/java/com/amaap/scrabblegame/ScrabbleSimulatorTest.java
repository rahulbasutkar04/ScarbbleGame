package com.amaap.scrabblegame;


import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScrabbleSimulatorTest {
    ScrabbleSimulator scrabble = ScrabbleSimulator.getInstance();

    @Test
    void shouldAbleTOCreateInstanceOfScrabbleClass() {
        assertTrue(scrabble instanceof ScrabbleSimulator);
    }


    @Test
    void shouldBeAbleToGetSingleInstance() {

        //arrange
        ScrabbleSimulator scrabbleSimulator1 = ScrabbleSimulator.getInstance();
        ScrabbleSimulator scrabbleSimulator2 = ScrabbleSimulator.getInstance();

        //act & assert
        assertEquals(scrabbleSimulator1, scrabbleSimulator2);

    }

    @Test
    void shouldAbleToGetScoreOfGivenOneString() throws EmptyStringException, InValidStringException {

        // arrange & act
        int actual = scrabble.perform("Rahul Basutkar");

        // assert
        assertEquals(22, actual);
    }

    @Test
    void shouldBeAbleToGetDoubleOfLetterWithTheStringSum() throws InValidStringException, EmptyStringException {

        // arrange & act
        int actual = scrabble.getDoubleScoreForLetter("Rahul", 'h');

        // assert
        assertEquals(16, actual);

    }

    @Test
    void shouldBeAbleToGetDoubleOfWordWithGivenSubStringSum() throws InValidStringException, EmptyStringException {

        // arrange & act
        int actual = scrabble.getDoubleScoreForWord("Rahul", "hul");

        // assert
        assertEquals(14, actual);

    }


    @Test
    void shouldBeAbleToGetTripleOfLetterWithTheStringSum() throws InValidStringException, EmptyStringException {

        // arrange & act
        int actual = scrabble.getTripleScoreForLetter("Rahul", 'h');

        // assert
        assertEquals(20, actual);
    }

    @Test
    void shouldBeAbleToGetTripleOfWordWithGivenSubStringSum() throws InValidStringException, EmptyStringException {

        // arrange & act
        int actual = scrabble.getTripleScoreForWord("Rahul", "hul");

        // assert
        assertEquals(26, actual);

    }


}
