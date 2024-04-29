package com.amaap.scrabblegame.domain.sevice;


import com.amaap.scrabblegame.repository.impl.InMemoryGameScoreRepository;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GameInitializerTest {

    private GameInitializer gameInitializer;

    @BeforeEach
    void setUp() {
        InMemoryGameScoreRepository gameScoreRepository = new InMemoryGameScoreRepository();
        gameInitializer = new GameInitializer(gameScoreRepository);
    }

    @Test
    void shouldBeAbleToAssignAnRackOfLetterAndStartTheGame() throws InvalidInputException {
        // arrange
        List<Integer> playerIds = new ArrayList<>();
        playerIds.add(1);
        playerIds.add(2);

        // act
        gameInitializer.startGameService(playerIds);
        Map<Integer, String> actual = gameInitializer.letterOfTilesOfEachPlayer;

        // assert
        assertEquals(2, actual.size());

    }

    @Test
    void shouldNotBeAbleToAssignRackAndStartTheGame() throws InvalidInputException {
        // arrange
        List<Integer> playerIds = new ArrayList<>();

        // act
        boolean result = gameInitializer.startGameService(playerIds);

        // assert
        assertFalse(result);
    }
}
