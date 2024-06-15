package com.amaap.scrabblegame.repository.impl.db.impl;

import com.amaap.scrabblegame.repository.impl.db.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDatabase implements Database {

    private  List<Integer> playerIds=new ArrayList<>();
    private Map<Integer, Integer> playerGameData = new HashMap<>();
    @Override
    public void inertIntoPlayerTable(int playerId) {
        playerIds.add(playerId);

    }

    @Override
    public List<Integer> getPlayers() {
        return playerIds;
    }

    @Override
    public void inertIntoScoreTable(int playerId, int score) {
        playerGameData.put(playerId,score);

    }

    @Override
    public Map<Integer, Integer> getPlayersData() {
        return playerGameData;
    }
}
