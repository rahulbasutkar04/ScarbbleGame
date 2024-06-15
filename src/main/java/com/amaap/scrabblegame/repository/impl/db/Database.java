package com.amaap.scrabblegame.repository.impl.db;

import java.util.List;
import java.util.Map;

public interface Database {

    void inertIntoPlayerTable(int playerId);
    List<Integer> getPlayers();

    void inertIntoScoreTable(int playerId, int score);

    Map<Integer, Integer> getPlayersData();
}
