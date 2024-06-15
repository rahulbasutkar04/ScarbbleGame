package com.amaap.scrabblegame.repository.impl;

import com.amaap.scrabblegame.repository.PlayerRepository;
import com.amaap.scrabblegame.repository.impl.db.Database;

import java.util.List;

public class InMemoryPlayerRepository implements PlayerRepository {

    public InMemoryPlayerRepository(Database database) {
        this.database = database;
    }

    private Database database;

    @Override
    public void insertPlayer(int id) {
        database.inertIntoPlayerTable(id);
    }

    @Override
    public List<Integer> getPlayerId() {
        return database.getPlayers();
    }
}
