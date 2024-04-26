package com.amaap.scrabblegame.repository.impl;

import com.amaap.scrabblegame.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPlayerRepository implements PlayerRepository {
    List<Integer> playerId=new ArrayList<>();
    @Override
    public void insertPlayer(int id) {
        playerId.add(id);
    }

    @Override
    public List<Integer> getPlayerId() {
        return playerId;
    }
}
