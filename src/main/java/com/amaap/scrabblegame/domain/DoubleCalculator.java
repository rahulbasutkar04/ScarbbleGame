package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;

public class DoubleCalculator extends ScoreCalculator {
    public int calculateForLetter(String originalWord, char letterToDouble) throws EmptyStringException, InValidStringException {
        int normalSum = getScore(originalWord);
        int doubledSum = normalSum;

        if (originalWord.indexOf(letterToDouble) != -1) {
            doubledSum = getScore("" + letterToDouble);
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
