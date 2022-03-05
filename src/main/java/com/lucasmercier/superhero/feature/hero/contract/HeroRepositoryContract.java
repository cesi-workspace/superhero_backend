package com.lucasmercier.superhero.feature.hero.contract;

import com.lucasmercier.superhero.entity.Hero;

public interface HeroRepositoryContract {

    <S extends Hero> S save(S entity);

}
