package com.amaap.scrabblegame.controller;

import com.amaap.scrabblegame.controller.dto.Http;
import com.amaap.scrabblegame.controller.dto.Response;
import com.amaap.scrabblegame.service.PlayerService;
import com.amaap.scrabblegame.service.exception.InvalidIdException;
import com.google.inject.Inject;

public class PlayerController {
    private final PlayerService playerService;

    @Inject
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Response createPlayer(int id) {
        try {
            if (playerService.createPlayer(id)) {
                return new Response(Http.OK);
            }
        } catch (InvalidIdException e) {
            return new Response(Http.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response(Http.BAD_REQUEST);
    }
}

