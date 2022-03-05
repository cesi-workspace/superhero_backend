package com.lucasmercier.superhero.feature.hero.contract;

import com.lucasmercier.superhero.entity.Hero;
import com.lucasmercier.superhero.feature.hero.dto.CreateHeroDto;

public interface HeroServiceContract {

    Hero createHero(CreateHeroDto createHeroDto);

}
