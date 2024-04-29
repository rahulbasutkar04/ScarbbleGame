package com.amaap.scrabblegame.domain.sevice;

import com.amaap.scrabblegame.domain.sevice.impl.ScrabbleScoreCalculator;
import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayGame {

    private final GameScoreRepository gameScoreRepository;
    ScoringService scoringService = new ScoringService(new ScrabbleScoreCalculator());
    PlayerInteractionService playerInteractionService = new PlayerInteractionService(new Scanner(System.in));

    @Inject
    public PlayGame(GameScoreRepository gameScoreRepository) {
        this.gameScoreRepository = gameScoreRepository;
    }

    public void play(Map<Integer, String> letterOfTilesOfEachPlayer) throws InvalidInputException {
        boolean continuePlaying = true;

        Map<Integer, Integer> playerScores = new HashMap<>();
        for (int playerId : letterOfTilesOfEachPlayer.keySet()) {
            playerScores.put(playerId, 0);
        }

        while (continuePlaying) {
            for (Map.Entry<Integer, String> entry : letterOfTilesOfEachPlayer.entrySet()) {
                int playerId = entry.getKey();
                String tiles = entry.getValue();
                System.out.println("Player ID: " + playerId + ", Tiles: " + tiles);

                String userInput="";
                boolean validInput = false;
                while (!validInput) {
                    System.out.println("Enter a word using the letters in the rack: ");

                    userInput = playerInteractionService.takeUserInputAsString();
                   // userInput="RAB";
                    if (isValidInput(userInput, tiles)) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid input. The word contains letters not in the rack.");
                    }
                }

                int totalSum = scoringService.calculateScrabble(userInput);

                int oldScore = playerScores.get(playerId);

                int newScore = oldScore + totalSum;

                playerScores.put(playerId, newScore);

                String remainingTiles = updateRack(tiles, userInput);

                letterOfTilesOfEachPlayer.put(playerId, remainingTiles);

                System.out.println("Remaining letters in the rack: " + remainingTiles);
            }

            printPlayerScores(playerScores);

            System.out.println("Do you want to continue playing? (yes/no): ");
            String decision = playerInteractionService.takeUserInputAsString();
           // String decision="no";
            if (!decision.equalsIgnoreCase("yes")) {
                continuePlaying = false;
                if (playerScores.size() > 1) {
                    int maxScore = Integer.MIN_VALUE;
                    int maxScorePlayer = -1;
                    for (Map.Entry<Integer, Integer> entry : playerScores.entrySet()) {
                        if (entry.getValue() > maxScore) {
                            maxScore = entry.getValue();
                            maxScorePlayer = entry.getKey();
                        }
                    }
                    System.out.println("Player " + maxScorePlayer + " is the winner with the highest score: " + maxScore);
                }
            }
        }

        storeScores(playerScores);
    }

    public boolean isValidInput(String input, String rack) throws InvalidInputException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException("Input is null or empty.");
        }

        Map<Character, Integer> rackLettersCount = new HashMap<>();

        for (char c : rack.toCharArray()) {
            rackLettersCount.put(c, rackLettersCount.getOrDefault(c, 0) + 1);
        }

        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new InvalidInputException("Input contains non-alphabetic characters: " + c);
            }

            if (!rackLettersCount.containsKey(c) || rackLettersCount.get(c) <= 0) {
                throw new InvalidInputException("Input contains invalid character: " + c);
            }
            rackLettersCount.put(c, rackLettersCount.get(c) - 1);
        }

        return true;
    }



    public String updateRack(String rack, String usedLetters) {
        StringBuilder updatedRack = new StringBuilder(rack);
        for (char c : usedLetters.toCharArray()) {
            int index = updatedRack.indexOf(String.valueOf(c));
            if (index != -1) {
                updatedRack.deleteCharAt(index);
            }
        }
        return updatedRack.toString();
    }

    void printPlayerScores(Map<Integer, Integer> playerScores) {
        for (Map.Entry<Integer, Integer> entry : playerScores.entrySet()) {
            System.out.println("Player " + entry.getKey() + " Score: " + entry.getValue());
        }
    }

    void storeScores(Map<Integer, Integer> playerScores) {
        for (Map.Entry<Integer, Integer> entry : playerScores.entrySet()) {
            gameScoreRepository.insertToScoreTable(entry.getKey(), entry.getValue());
        }
    }
}


