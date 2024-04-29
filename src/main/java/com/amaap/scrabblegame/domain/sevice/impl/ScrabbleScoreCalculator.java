package com.amaap.scrabblegame.domain.sevice.impl;

import com.amaap.scrabblegame.domain.model.LetterPointAllocator;
import com.amaap.scrabblegame.domain.sevice.ScrabbleCalculator;

public class ScrabbleScoreCalculator implements ScrabbleCalculator {
    LetterPointAllocator letterPointAllocator=new LetterPointAllocator();
    @Override
    public int calculateScore(String word) {
        int sum=0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sum += letterPointAllocator.getPoint(c);
        }
        return sum;
    }
}
