package com.amaap.scrabblegame.repository.impl;

import com.amaap.scrabblegame.repository.GameScoreRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryGameScoreRepository implements GameScoreRepository {
    Map<Integer, Integer> playerGameData = new HashMap<>();

    @Override
    public void insertToScoreTable(int playerId, int score) {
        playerGameData.put(playerId, score);
    }

    @Override
    public Map<Integer, Integer> getPlayerData() {
        return playerGameData;
    }

}
