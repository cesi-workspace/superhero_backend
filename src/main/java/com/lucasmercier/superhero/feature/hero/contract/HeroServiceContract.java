package com.lucasmercier.superhero.feature.hero.contract;

import com.lucasmercier.superhero.entity.Hero;
import com.lucasmercier.superhero.feature.hero.dto.CreateHeroDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface HeroServiceContract {

    Hero createHero(CreateHeroDto createHeroDto);
    CollectionModel<EntityModel<Hero>> getHeroes();

}
