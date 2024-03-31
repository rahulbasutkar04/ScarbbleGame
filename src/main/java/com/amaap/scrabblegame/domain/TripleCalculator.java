package com.amaap.scrabblegame.domain;

import com.amaap.scrabblegame.domain.exception.EmptyStringException;
import com.amaap.scrabblegame.domain.exception.InValidStringException;
import com.amaap.scrabblegame.domain.exception.LetterNotPresentException;

public class TripleCalculator extends ScoreCalculator {
    public int calculateForLetter(String originalWord, char letterToTriple) throws EmptyStringException, InValidStringException, LetterNotPresentException {

        int normalSum = getScore(originalWord);
        int tripledSum;

        if (originalWord.indexOf(letterToTriple) != -1) {
            tripledSum = getScore("" + letterToTriple);
        }
        else {
            throw new LetterNotPresentException("The letter '" + letterToTriple + "' is not present in the original word.");
        }


        return (tripledSum * 3) + normalSum;
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
