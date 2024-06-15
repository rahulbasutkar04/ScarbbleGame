package com.amaap.scrabblegame.domain.sevice;


import com.amaap.scrabblegame.ScrabbleGameModule;
import com.amaap.scrabblegame.repository.impl.InMemoryGameScoreRepository;
import com.amaap.scrabblegame.repository.impl.db.Database;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GameInitializerServiceTest {

    private GameInitializerService gameInitializerService;

    @BeforeEach
    void setUp() {
        Injector injector= Guice.createInjector(new ScrabbleGameModule());
        gameInitializerService =injector.getInstance(GameInitializerService.class);
    }

    @Test
    void shouldBeAbleToAssignAnRackOfLetterAndStartTheGame() throws InvalidInputException {
        // arrange
        List<Integer> playerIds = new ArrayList<>();
        playerIds.add(1);
        playerIds.add(2);

        // act
        gameInitializerService.startGameService(playerIds);
        Map<Integer, String> actual = gameInitializerService.letterOfTilesOfEachPlayer;

        // assert
        assertEquals(2, actual.size());

    }

    @Test
    void shouldBeAbleToReturnFalseIfRackNotAssigned() throws InvalidInputException {
        // arrange
        List<Integer> playerIds = new ArrayList<>();

        // act
        boolean result = gameInitializerService.startGameService(playerIds);

        // assert
        assertFalse(result);
    }
}
