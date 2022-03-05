package com.lucasmercier.superhero.feature.hero.contract;

import com.lucasmercier.superhero.entity.Hero;

import java.util.List;

public interface HeroRepositoryContract {

    Hero save(Hero entity);
    List<Hero> findAll();

}
