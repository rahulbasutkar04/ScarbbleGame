package com.amaap.scrabblegame.domain.sevice;

import com.amaap.scrabblegame.domain.sevice.impl.DoubleCalculator;
import com.amaap.scrabblegame.domain.sevice.impl.TripleCalculator;
import com.google.inject.Inject;

import java.util.Scanner;

public class ScoringService {

    PlayerInteractionService playerInteractionService = new PlayerInteractionService(new Scanner(System.in));
    private final ScrabbleCalculator scrabbleCalculator;


    @Inject
    public ScoringService(ScrabbleCalculator scrabbleCalculator) {
        this.scrabbleCalculator = scrabbleCalculator;
    }

    public int calculateScrabble(String word) {
        int sum = 0;

        sum = scrabbleCalculator.calculateScore(word);
        System.out.println("Current Score:" + sum);

        System.out.println("Do you want to Double an letter?(yes/no)");
        String choice = playerInteractionService.takeUserInputAsString();
       // String choice="yes";
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the letter to double..");
            char c = playerInteractionService.takeUserInputAsChar();
           // char c='R';
            sum += new DoubleCalculator().doubleALetter(c,word);
        }

        System.out.println("Current Score:" + sum);
        System.out.println("Do you want to Double an word?(yes/no)");
       String choice1 = playerInteractionService.takeUserInputAsString();
       // String choice1="yes";
        if (choice1.equalsIgnoreCase("yes")) {

            sum += new DoubleCalculator().calculateScore(word);
        }

        System.out.println("Current Score:" + sum);
        System.out.println("Do you want to Triple an letter?(yes/no)");

        String choice3 = playerInteractionService.takeUserInputAsString();
        //String choice3="yes";

        if (choice3.equalsIgnoreCase("yes")) {
            System.out.println("Enter the letter to triple..");
            char c = playerInteractionService.takeUserInputAsChar();
           // char c ='R';
            sum += new TripleCalculator().TripleALetter(c,word);
        }

        System.out.println("Current Score:" + sum);
        System.out.println("Do you want to Triple an word?(yes/no)");


        String choice4 = playerInteractionService.takeUserInputAsString();
       // String choice4="yes";
        if (choice4.equalsIgnoreCase("yes")) {

            sum += new TripleCalculator().calculateScore(word);
        }


        return sum;
    }

}








