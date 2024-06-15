package com.amaap.scrabblegame.domain.service;

import com.amaap.scrabblegame.ScrabbleGameModule;
import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayGameServiceTest {

    private PlayGameService playGameService;
    private GameScoreRepository gameScoreRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ScrabbleGameModule());
        gameScoreRepository = injector.getInstance(GameScoreRepository.class);
        playGameService = injector.getInstance(PlayGameService.class);
    }

    @Test
    void shouldBeAbleToPlayTheGameAfterAssigningRack() {
        // arrange
        Map<Integer, String> letterOfTilesOfEachPlayer = new HashMap<>();
        letterOfTilesOfEachPlayer.put(1, "RABHUTE");

        // act
        assertDoesNotThrow(() -> playGameService.play(letterOfTilesOfEachPlayer));

        // Assert
        assertEquals(1, gameScoreRepository.getPlayerData().size());
    }

    @Test
    void shouldBeAbleToValidateInputFromTheRack() throws InvalidInputException {
        // arrange
        String input = "RAB";
        String rack = "RABHUTE";

        // act
        boolean isValid = playGameService.isValidInput(input, rack);

        // assert
        assertEquals(true, isValid);
    }

    @Test
    void ShouldThrowExceptionIfInvalidInputISGiven() {
        // arrange
        String input = "XYZ";
        String rack = "RABHUTE";

        // act & assert
        assertThrows(InvalidInputException.class, () -> playGameService.isValidInput(input, rack));
    }

    @Test
    void shouldBeAbleToUpdateTeRackContents() {
        // arrange
        String rack = "RABHUTE";
        String usedLetters = "RAB";

        // act
        String updatedRack = playGameService.updateRack(rack, usedLetters);

        // assert
        assertEquals("HUTE", updatedRack);
    }

}
