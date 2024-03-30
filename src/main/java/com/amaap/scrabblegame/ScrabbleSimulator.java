package com.amaap.scrabblegame;

import com.amaap.scrabblegame.domain.DoubleCalculator;
import com.amaap.scrabblegame.domain.ScoreCalculator;
import com.amaap.scrabblegame.domain.TripleCalculator;
import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;

public class ScrabbleSimulator {
    ScoreCalculator operations = new ScoreCalculator();

    private static ScrabbleSimulator scrabbleSimulator;

    public static synchronized ScrabbleSimulator getInstance() {
        if (scrabbleSimulator == null)
            scrabbleSimulator = new ScrabbleSimulator();
        return scrabbleSimulator;
    }


    public int perform(String input) throws EmptyStringException, InValidStringException {

        return operations.getScore(input.toUpperCase());


    }


    public int getDoubleScoreForLetter(String word, char letter) throws InValidStringException, EmptyStringException {

        return new DoubleCalculator().calculateForLetter(word, letter);
    }

    public int getDoubleScoreForWord(String word, String substring) throws InValidStringException, EmptyStringException {
        return new DoubleCalculator().calculateForWord(word, substring);
    }

    public int getTripleScoreForLetter(String word, char letter) throws InValidStringException, EmptyStringException {
        return new TripleCalculator().calculateForLetter(word, letter);
    }


    public int getTripleScoreForWord(String word, String substring) throws InValidStringException, EmptyStringException {
        return new TripleCalculator().calculateForWord(word, substring);
    }
}
