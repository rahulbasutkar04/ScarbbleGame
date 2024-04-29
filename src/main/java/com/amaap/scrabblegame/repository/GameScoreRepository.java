package com.amaap.scrabblegame.repository;

import java.util.Map;

public interface GameScoreRepository {
    void insertToScoreTable(int playerId, int score);

    Map<Integer, Integer> getPlayerData();
}
