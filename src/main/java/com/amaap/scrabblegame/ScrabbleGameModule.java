package com.amaap.scrabblegame;

import com.amaap.scrabblegame.domain.service.GameInitializerService;
import com.amaap.scrabblegame.domain.service.ScrabbleCalculator;
import com.amaap.scrabblegame.domain.service.impl.ScrabbleScoreCalculator;
import com.amaap.scrabblegame.repository.GameScoreRepository;
import com.amaap.scrabblegame.repository.impl.InMemoryGameScoreRepository;
import com.amaap.scrabblegame.repository.impl.InMemoryPlayerRepository;
import com.amaap.scrabblegame.repository.PlayerRepository;
import com.amaap.scrabblegame.repository.impl.db.Database;
import com.amaap.scrabblegame.repository.impl.db.impl.FakeDatabase;
import com.amaap.scrabblegame.service.GameService;
import com.google.inject.AbstractModule;

public class ScrabbleGameModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PlayerRepository.class).to(InMemoryPlayerRepository.class);
        bind(ScrabbleCalculator.class).to(ScrabbleScoreCalculator.class);
        bind(GameScoreRepository.class).to(InMemoryGameScoreRepository.class);
        bind(Database.class).to(FakeDatabase.class);
        bind(GameInitializerService.class).toInstance(new GameInitializerService(new InMemoryGameScoreRepository(new FakeDatabase())));
        bind(GameService.class);
    }
}
