package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;
import com.amaap.scrabblegame.domain.exception.LetterNotPresentException;

public class DoubleCalculator extends ScoreCalculator {
    public int calculateForLetter(String originalWord, char letterToDouble) throws EmptyStringException, InValidStringException, LetterNotPresentException {
        int normalSum = getScore(originalWord);
        int doubledSum;

        if (originalWord.indexOf(letterToDouble) != -1) {
            doubledSum = getScore("" + letterToDouble);
        } else {
            throw new LetterNotPresentException("The letter '" + letterToDouble + "' is not present in the original word.");
        }

        return (doubledSum * 2) + normalSum;
    }

    public int calculateForWord(String word1, String word2) throws EmptyStringException, InValidStringException {

        if (word1.equals(word2)) {
            int normalSum = getScore(word1);

            return normalSum * 2;
        }

        int normalSum1 = getScore(word1);
        int normalSum2 = getScore(word2);

        return normalSum1 + normalSum2;


    }
}
