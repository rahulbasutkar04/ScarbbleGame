package com.amaap.scrabblegame.controller;

import com.amaap.scrabblegame.controller.dto.Http;
import com.amaap.scrabblegame.controller.dto.Response;
import com.amaap.scrabblegame.repository.PlayerRepository;
import com.amaap.scrabblegame.service.GameService;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import com.google.inject.Inject;

import java.util.List;

public class GameController {

    private final List<Integer> playerIds;
    private final GameService gameService;

    @Inject
    public GameController(PlayerRepository playerRepository, GameService gameService) {
        this.playerIds = playerRepository.getPlayerId();
        this.gameService = gameService;
    }

    public Response startGame() throws InvalidInputException {
        if (gameService.startGame(playerIds)) {
            return new Response(Http.OK);
        } else {
            return new Response(Http.BAD_REQUEST);
        }
    }
}
