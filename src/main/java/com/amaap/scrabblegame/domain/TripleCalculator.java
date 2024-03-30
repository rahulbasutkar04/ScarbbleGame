package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;

public class TripleCalculator extends ScoreCalculator {
    public int calculateForLetter(String originalWord, char letterToTriple) throws EmptyStringException, InValidStringException {

        int normalSum = getScore(originalWord);
        int doubledSum = normalSum;

        if (originalWord.indexOf(letterToTriple) != -1) {
            doubledSum = getScore("" + letterToTriple);
        }

        return (doubledSum * 3) + normalSum;
    }

    public int calculateForWord(String word1, String word2) throws EmptyStringException, InValidStringException {
        if (word1.equals(word2)) {
            int normalSum = getScore(word1);

            return (normalSum + normalSum * 3);
        }

        int normalSum1 = getScore(word1);
        int normalSum2 = getScore(word2);

        return normalSum1 + (normalSum2 * 3);

    }
}
