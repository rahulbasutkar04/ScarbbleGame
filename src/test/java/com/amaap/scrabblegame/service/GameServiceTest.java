package com.amaap.scrabblegame.service;

import com.amaap.scrabblegame.domain.sevice.GameInitializerService;
import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.repository.impl.InMemoryGameScoreRepository;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void setUp() {
        InMemoryGameScoreRepository inMemoryGameScoreRepository = new InMemoryGameScoreRepository();
        GameInitializerService gameInitializerService = new GameInitializerService(inMemoryGameScoreRepository);
        GameScoreRepository gameScoreRepository = new InMemoryGameScoreRepository();
        gameService = new GameService(gameScoreRepository, gameInitializerService);
    }

    @Test
    void shouldBeAbleToStartTheGame() throws InvalidInputException {
        // arrange
        List<Integer> playerIds = new ArrayList<>();
        playerIds.add(1);

        // act
        boolean result = gameService.startGame(playerIds);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldNotBeAbleToStartTheGameIfNoPlayersFound() throws InvalidInputException {
        // arrange
        List<Integer> playerIds = new ArrayList<>();

        // act
        boolean result = gameService.startGame(playerIds);

        // assert
        assertFalse(result);
    }
}
