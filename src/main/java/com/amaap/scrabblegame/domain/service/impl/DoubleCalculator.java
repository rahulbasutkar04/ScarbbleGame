package com.amaap.scrabblegame.domain.service.impl;

import com.amaap.scrabblegame.domain.model.LetterPointAllocator;
import com.amaap.scrabblegame.domain.service.PlayerInteractionService;
import com.amaap.scrabblegame.domain.service.ScrabbleCalculator;

import java.util.Scanner;

public class DoubleCalculator implements ScrabbleCalculator {
    LetterPointAllocator letterPointAllocator=new LetterPointAllocator();
    PlayerInteractionService playerInteractionService=new PlayerInteractionService(new Scanner(System.in));
    ScrabbleScoreCalculator scrabbleScoreCalculator=new ScrabbleScoreCalculator();


    @Override
    public int calculateScore(String word) {
        return scrabbleScoreCalculator.calculateScore(word);
    }

    public int doubleALetter(char c, String word) {
        if (word.indexOf(c) != -1) {
            return letterPointAllocator.getPoint(c) * 2;
        } else {
            System.out.println("The letter you entered is not in the word. Please enter a letter from the word.");
            char validChar = playerInteractionService.takeUserInputAsChar();
            return doubleALetter(validChar, word);
        }
    }
}
