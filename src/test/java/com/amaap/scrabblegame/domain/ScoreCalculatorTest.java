package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();

    @Test
    void shouldAbleToStartTeGame() throws EmptyStringException, InValidStringException {

        int actual = scoreCalculator.getScore("RAHUL");
        assertEquals(8, actual);
    }

    @Test
    void shouldAbleToThrowExceptionIfInputISEmpty() {
        assertThrows(EmptyStringException.class, () -> {
            scoreCalculator.getScore("");
        });
    }

    @Test
    void shouldAbleToThrowExceptionIfOtherThanStringFound() {

        assertThrows(InValidStringException.class, () -> {
            scoreCalculator.getScore("123raj");
        });
    }

    @Test
    void shouldAbleToPerformForTheMoreString() throws EmptyStringException, InValidStringException {

        int actual = scoreCalculator.getScore("Rahul Basutkar");
        assertEquals(22, actual);

    }

    @Test
    void shouldAbleToThrowExceptionIfMoreThanOneSpacesFoundInTheString() {

        assertThrows(InValidStringException.class, () -> {
            scoreCalculator.getScore("rahul   basutkar");
        });

    }

    @Test
    void shouldAbleToThrowExceptionIfMoreThanOneSpacesFoundInEndTheString() {

        assertThrows(InValidStringException.class, () -> {
            scoreCalculator.getScore("rahul  basutkar    ");
        });

    }

    @Test
    void shouldBeAbleToThrowExceptionIfNullIsPassed() {

        assertThrows(NullPointerException.class, () -> {
            scoreCalculator.getScore(null);
        });
    }

}