package com.amaap.scrabblegame;


import com.amaap.scrabblegame.controller.GameController;
import com.amaap.scrabblegame.controller.PlayerController;
import com.amaap.scrabblegame.repository.PlayerRepository;
import com.amaap.scrabblegame.service.GameService;
import com.amaap.scrabblegame.service.PlayerService;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScrabbleGameMain {

    public static void main(String[] args) throws InvalidInputException {

        Scanner sc = new Scanner(System.in);
        Injector injector = Guice.createInjector(new ScrabbleGameModule());
        PlayerController playerController =injector.getInstance(PlayerController.class);
        GameController gameController =injector.getInstance(GameController.class);

        int playerCount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter Number of players for Scrabble Game (max 4 min 1):");
                playerCount = sc.nextInt();
                if (playerCount <= 0 || playerCount > 4) {
                    System.out.println("Invalid Player Count. Please enter a number between 1 and 4.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }

        for (int i = 1; i <= playerCount; i++) {
            playerController.createPlayer(i);
        }
        gameController.startGame();
    }
}
