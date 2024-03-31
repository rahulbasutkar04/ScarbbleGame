package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();

    @Test
    void shouldBeAbleToStartTheGame() throws EmptyStringException, InValidStringException {
        int actual = scoreCalculator.getScore("RAHUL");
        assertEquals(8, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionIfNullIsPassed() {
        assertThrows(NullPointerException.class, () -> {
            scoreCalculator.getScore(null);
        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfInputIsEmpty() {
        assertThrows(EmptyStringException.class, () -> {
            scoreCalculator.getScore("");
        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfOtherThanStringFound() {
        assertThrows(InValidStringException.class, () -> {
            scoreCalculator.getScore("123raj");
        });
    }

    @Test
    void shouldBeAbleToPerformForMoreThanOneString() throws EmptyStringException, InValidStringException {
        int actual = scoreCalculator.getScore("Rahul Basutkar");
        assertEquals(22, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionIfMoreThanOneSpacesFoundInTheString() {
        assertThrows(InValidStringException.class, () -> {
            scoreCalculator.getScore("rahul   basutkar");
        });
    }

    @Test
    void shouldBeAbleToThrowExceptionIfMoreThanOneSpacesFoundInEndTheString() {
        assertThrows(InValidStringException.class, () -> {
            scoreCalculator.getScore("rahul  basutkar    ");
        });
    }


}