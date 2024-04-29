package com.amaap.scrabblegame;

import com.amaap.scrabblegame.domain.sevice.GameInitializerService;
import com.amaap.scrabblegame.domain.sevice.ScrabbleCalculator;
import com.amaap.scrabblegame.domain.sevice.impl.ScrabbleScoreCalculator;
import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.repository.impl.InMemoryGameScoreRepository;
import com.amaap.scrabblegame.repository.impl.InMemoryPlayerRepository;
import com.amaap.scrabblegame.repository.PlayerRepository;
import com.amaap.scrabblegame.service.GameService;
import com.google.inject.AbstractModule;

public class ScrabbleGameModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PlayerRepository.class).to(InMemoryPlayerRepository.class);
        bind(ScrabbleCalculator.class).to(ScrabbleScoreCalculator.class);
        bind(GameScoreRepository.class).to(InMemoryGameScoreRepository.class);
        bind(GameInitializerService.class).toInstance(new GameInitializerService(new InMemoryGameScoreRepository()));
        bind(GameService.class);
    }
}
