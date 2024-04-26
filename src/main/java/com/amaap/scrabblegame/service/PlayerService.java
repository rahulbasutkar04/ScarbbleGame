package com.amaap.scrabblegame.service;


import com.amaap.scrabblegame.repository.PlayerRepository;
import com.amaap.scrabblegame.service.exception.DuplicateIdException;
import com.amaap.scrabblegame.service.exception.InvalidIdException;
import com.google.inject.Inject;

import java.util.List;

public class PlayerService {
    private final PlayerRepository playerRepository;

    @Inject
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public boolean createPlayer(int id) throws InvalidIdException, DuplicateIdException {
        if (validateId(id)) {
            playerRepository.insertPlayer(id);
            return true;
        }
        return false;
    }


    private boolean validateId(int id) throws InvalidIdException, DuplicateIdException {
        if (id <= 0) {
            throw new InvalidIdException("ID must be a positive..");
        }

        List<Integer> existingIds = playerRepository.getPlayerId();
        if (existingIds.contains(id)) {
            throw new DuplicateIdException("ID is already present");
        }

        return true;
    }

}
