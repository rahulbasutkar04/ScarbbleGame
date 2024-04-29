package com.amaap.scrabblegame.service;

import com.amaap.scrabblegame.domain.sevice.GameInitializerService;
import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import com.google.inject.Inject;

import java.util.List;

public class GameService {
    private final GameInitializerService gameInitializerService;
    private final GameScoreRepository gameScoreRepository;

    @Inject
    public GameService(GameScoreRepository gameScoreRepository, GameInitializerService gameInitializerService) {
        this.gameScoreRepository = gameScoreRepository;
        this.gameInitializerService = gameInitializerService;
    }

    public boolean startGame(List<Integer> playerIds) throws InvalidInputException {
        return gameInitializerService.startGameService(playerIds);
    }
}
