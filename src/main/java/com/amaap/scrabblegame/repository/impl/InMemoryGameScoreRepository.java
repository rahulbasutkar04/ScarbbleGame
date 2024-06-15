package com.amaap.scrabblegame.repository.impl;

import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.repository.impl.db.Database;

import java.util.Map;

public class InMemoryGameScoreRepository implements GameScoreRepository {
    public InMemoryGameScoreRepository(Database database) {
        this.database = database;
    }

    private Database database;

    @Override
    public void insertToScoreTable(int playerId, int score) {
        database.inertIntoScoreTable(playerId, score);
    }

    @Override
    public Map<Integer, Integer> getPlayerData() {
        return database.getPlayersData();
    }

}
