package com.lucasmercier.superhero.feature.hero.contract;

import com.lucasmercier.superhero.entity.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroRepositoryContract {

    Hero save(Hero entity);
    Optional<Hero> findById(int id);
    List<Hero> findAll();

}
