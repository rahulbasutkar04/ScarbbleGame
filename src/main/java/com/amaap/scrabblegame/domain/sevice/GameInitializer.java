package com.amaap.scrabblegame.domain.sevice;

import com.amaap.scrabblegame.domain.model.RackGenerator;
import com.amaap.scrabblegame.repository.impl.InMemoryGameScoreRepository;
import com.amaap.scrabblegame.service.exception.InvalidInputException;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameInitializer {
    public Map<Integer, String> letterOfTilesOfEachPlayer = new HashMap<>();
    private final InMemoryGameScoreRepository inMemoryGameScoreRepository;
     RackGenerator rackGenerator = new RackGenerator();


    @Inject
    public GameInitializer(InMemoryGameScoreRepository inMemoryGameScoreRepository) {
        this.inMemoryGameScoreRepository = inMemoryGameScoreRepository;
    }

    public boolean startGameService(List<Integer> playerIds) throws InvalidInputException {
        PlayGame playGame = new PlayGame(inMemoryGameScoreRepository);

        for (int i = 0; i < playerIds.size(); i++) {
             String rackOfTile = rackGenerator.generateRack();
           // String rackOfTile = "RABHUTE";
            letterOfTilesOfEachPlayer.put(playerIds.get(i), rackOfTile);
        }


        playGame.play(letterOfTilesOfEachPlayer);

        if (inMemoryGameScoreRepository.getPlayerData().isEmpty()) {
            return false;
        }

        return true;
    }


}
