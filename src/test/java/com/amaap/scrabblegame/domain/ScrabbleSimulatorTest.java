package com.amaap.scrabblegame.domain;

import Exception.EmptyStringException;
import Exception.OtherThanStringException;
import com.amaap.scrabblegame.domain.ScrabbleSimulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScrabbleSimulatorTest {
    @Test
    void shouldAbleTOCreateInstanceOfScrabbleClass() {
        ScrabbleSimulator scrabble = new ScrabbleSimulator();

        assertTrue(scrabble instanceof ScrabbleSimulator);
    }

    @Test
    void shouldAbleTOStartTeGame() throws EmptyStringException, OtherThanStringException {
        ScrabbleSimulator scrabble = new ScrabbleSimulator();
        int actual = scrabble.perform("RAHUL");
        assertEquals(8, actual);
    }

    @Test
    void shouldAbleToThrowExceptionIfInputISEmpty()
    {

        ScrabbleSimulator scrabble = new ScrabbleSimulator();
        assertThrows(EmptyStringException.class,()->{
           scrabble.perform("");
        });
    }

    @Test
    void shouldAbleToThrowExceptionIfOtherThanStringFound(){
        ScrabbleSimulator scrabble = new ScrabbleSimulator();
        assertThrows(OtherThanStringException.class,()->{
            scrabble.perform("123raj");
        });
    }

    @Test
    void shouldAbleToPerformForTheMoreString() throws EmptyStringException, OtherThanStringException {
        ScrabbleSimulator scrabble=new ScrabbleSimulator();

        int actaul=scrabble.perform("Rahul Basutkar");
        assertEquals(22,actaul);

    }

    @Test
    void  shouldAbleToThrowExceptionIfMoreThanOneSpacesFoundInTheString(){

        ScrabbleSimulator scrabble = new ScrabbleSimulator();
        assertThrows(OtherThanStringException.class,()->{
            scrabble.perform("rahul   basutkar");
        });

    }

    @Test
    void  shouldAbleToThrowExceptionIfMoreThanOneSpacesFoundInEndTheString(){

        ScrabbleSimulator scrabble = new ScrabbleSimulator();
        assertThrows(OtherThanStringException.class,()->{
            scrabble.perform("rahul  basutkar    ");
        });

    }



}
