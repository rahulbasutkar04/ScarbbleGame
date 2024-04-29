package com.amaap.scrabblegame.controller;

import com.amaap.scrabblegame.controller.dto.Http;
import com.amaap.scrabblegame.controller.dto.Response;
import com.amaap.scrabblegame.domain.sevice.GameInitializerService;
import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.repository.PlayerRepository;
import com.amaap.scrabblegame.repository.impl.InMemoryGameScoreRepository;
import com.amaap.scrabblegame.repository.impl.InMemoryPlayerRepository;
import com.amaap.scrabblegame.service.GameService;
import com.amaap.scrabblegame.service.PlayerService;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class GameControllerTest {

    @Test
    void ShouldBeAbleToStartTheGameForThePlayerAndRespondWithOkIFGameStarts() throws InvalidInputException {
            // arrange
            PlayerRepository playerRepository = new InMemoryPlayerRepository();
            PlayerService playerService=new PlayerService(playerRepository);
            PlayerController playerController=new PlayerController(playerService);
            playerController.createPlayer(1);
            GameScoreRepository gameScoreRepository = new InMemoryGameScoreRepository();
            GameInitializerService gameInitializerService = new GameInitializerService((InMemoryGameScoreRepository) gameScoreRepository);
            GameService gameService = new GameService(gameScoreRepository, gameInitializerService);
            GameController gameController = new GameController(playerRepository, gameService);

           // act
            Response response = gameController.startGame();

            // assert
            assertEquals(Http.OK, response.getStatus());
        }


    @Test
    void ShouldBeAbleToNotStartTheGameForThePlayerAndRespondWithBADREQUEST() throws InvalidInputException {

        // arrange
        PlayerRepository playerRepository = new InMemoryPlayerRepository();
        PlayerService playerService=new PlayerService(playerRepository);
        PlayerController playerController=new PlayerController(playerService);
        playerController.createPlayer(0);
        GameScoreRepository gameScoreRepository = new InMemoryGameScoreRepository();
        GameInitializerService gameInitializerService = new GameInitializerService((InMemoryGameScoreRepository) gameScoreRepository);
        GameService gameService = new GameService(gameScoreRepository, gameInitializerService);
        GameController gameController = new GameController(playerRepository, gameService);

        // act
        Response response = gameController.startGame();

        // assert
        assertEquals(Http.BAD_REQUEST, response.getStatus());
    }



}




