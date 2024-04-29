package com.amaap.scrabblegame.service;

import com.amaap.scrabblegame.domain.sevice.GameInitializer;
import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import com.google.inject.Inject;

import java.util.List;

public class GameService {
    private final GameInitializer gameInitializer;
    private final GameScoreRepository gameScoreRepository;

    @Inject
    public GameService(GameScoreRepository gameScoreRepository, GameInitializer gameInitializer) {
        this.gameScoreRepository = gameScoreRepository;
        this.gameInitializer = gameInitializer;
    }

    public boolean startGame(List<Integer> playerIds) throws InvalidInputException {
        return gameInitializer.startGameService(playerIds);
    }
}
