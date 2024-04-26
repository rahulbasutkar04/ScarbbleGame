package com.amaap.scrabblegame.repository;

import java.util.List;

public interface PlayerRepository {

      void insertPlayer(int id);

      List<Integer> getPlayerId();
}
