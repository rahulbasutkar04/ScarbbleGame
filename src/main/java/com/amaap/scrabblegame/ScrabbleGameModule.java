package com.amaap.scrabblegame;

import com.amaap.scrabblegame.repository.impl.InMemoryPlayerRepository;
import com.amaap.scrabblegame.repository.PlayerRepository;
import com.google.inject.AbstractModule;

public class ScrabbleGameModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PlayerRepository.class).to(InMemoryPlayerRepository.class);
    }
}
