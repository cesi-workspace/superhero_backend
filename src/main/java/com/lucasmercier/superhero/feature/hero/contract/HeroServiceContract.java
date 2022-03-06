package com.lucasmercier.superhero.feature.hero.contract;

import com.lucasmercier.superhero.entity.Hero;
import com.lucasmercier.superhero.feature.hero.dto.CreateHeroDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface HeroServiceContract {

    EntityModel<Hero> createHero(CreateHeroDto createHeroDto);
    EntityModel<Hero> getHero(int id);
    CollectionModel<EntityModel<Hero>> getHeroes();

}
