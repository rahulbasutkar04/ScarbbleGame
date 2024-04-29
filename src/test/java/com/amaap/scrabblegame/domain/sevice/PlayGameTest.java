package com.amaap.scrabblegame.domain.sevice;

import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.repository.impl.InMemoryGameScoreRepository;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayGameTest {

    private PlayGame playGame;
    private GameScoreRepository gameScoreRepository;

    @BeforeEach
    void setUp() {
        gameScoreRepository = new InMemoryGameScoreRepository();
        playGame = new PlayGame(gameScoreRepository);
    }

    @Test
    void shouldBeAbleToPlayTheGameAfterAssigningRack() {
        // arrange
        Map<Integer, String> letterOfTilesOfEachPlayer = new HashMap<>();
        letterOfTilesOfEachPlayer.put(1, "RABHUTE");

        // act
        assertDoesNotThrow(() -> playGame.play(letterOfTilesOfEachPlayer));

        // Assert
        assertEquals(1, gameScoreRepository.getPlayerData().size());
    }

    @Test
    void shouldBeAbleToValidateInputFromTheRack() throws InvalidInputException {
        // arrange
        String input = "RAB";
        String rack = "RABHUTE";

        // act
        boolean isValid = playGame.isValidInput(input, rack);

        // assert
        assertEquals(true, isValid);
    }

    @Test
    void ShouldThrowExceptionIfInvalidInputISGiven() {
        // arrange
        String input = "XYZ";
        String rack = "RABHUTE";

        // act & assert
        assertThrows(InvalidInputException.class, () -> playGame.isValidInput(input, rack));
    }

    @Test
    void shouldBeAbleToUpdateTeRackContents() {
        // arrange
        String rack = "RABHUTE";
        String usedLetters = "RAB";

        // act
        String updatedRack = playGame.updateRack(rack, usedLetters);

        // assert
        assertEquals("HUTE", updatedRack);
    }

}
