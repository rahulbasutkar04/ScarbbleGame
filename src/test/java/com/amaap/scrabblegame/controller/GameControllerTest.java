package com.amaap.scrabblegame.controller;

import com.amaap.scrabblegame.ScrabbleGameModule;
import com.amaap.scrabblegame.controller.dto.Http;
import com.amaap.scrabblegame.controller.dto.Response;
import com.amaap.scrabblegame.domain.service.GameInitializerService;
import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.repository.PlayerRepository;
import com.amaap.scrabblegame.service.GameService;
import com.amaap.scrabblegame.service.PlayerService;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameControllerTest {

    PlayerRepository playerRepository;
    PlayerService playerService;
    PlayerController playerController;
    GameScoreRepository gameScoreRepository;
    GameInitializerService gameInitializerService;
    GameService gameService;
    GameController gameController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ScrabbleGameModule());
        playerController = injector.getInstance(PlayerController.class);
        gameController = injector.getInstance(GameController.class);

    }

    @Test
    void ShouldBeAbleToStartTheGameForThePlayerAndRespondWithOkIFGameStarts() throws InvalidInputException {
        // arrange
        playerController.createPlayer(1);

        // act
        Response response = gameController.startGame();

        // assert
        assertEquals(Http.OK, response.getStatus());
    }


    @Test
    void ShouldBeAbleToRespondWithBadRequestIfItFailsToStartTheGame() throws InvalidInputException {

        // arrange
        playerController.createPlayer(0);

        // act
        Response response = gameController.startGame();

        // assert
        assertEquals(Http.BAD_REQUEST, response.getStatus());
    }


}




