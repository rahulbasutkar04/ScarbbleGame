package com.amaap.scrabblegame.domain.sevice.impl;

import com.amaap.scrabblegame.domain.model.LetterPointAllocator;
import com.amaap.scrabblegame.domain.sevice.PlayerInteractionService;
import com.amaap.scrabblegame.domain.sevice.ScrabbleCalculator;

import java.util.Scanner;

public class TripleCalculator implements ScrabbleCalculator {
    ScrabbleScoreCalculator scrabbleScoreCalculator=new ScrabbleScoreCalculator();
    LetterPointAllocator letterPointAllocator=new LetterPointAllocator();
    PlayerInteractionService playerInteractionService=new PlayerInteractionService(new Scanner(System.in));


    @Override
    public int calculateScore(String word) {
        return scrabbleScoreCalculator.calculateScore(word)*2;
    }

    public int TripleALetter(char c, String word) {
        if (word.indexOf(c) != -1) {
            return letterPointAllocator.getPoint(c) *3;
        } else {
            System.out.println("The letter you entered is not in the word. Please enter a letter from the word.");
            char validChar = playerInteractionService.takeUserInputAsChar();
            return TripleALetter(validChar, word);
        }
    }
}
