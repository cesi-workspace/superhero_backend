package com.lucasmercier.superhero.feature.hero.contract;

import com.lucasmercier.superhero.entity.Hero;
import com.lucasmercier.superhero.feature.hero.dto.CreateHeroDto;
import com.lucasmercier.superhero.feature.hero.dto.FindHeroDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HeroServiceContract {

    ResponseEntity<Hero> createHero(CreateHeroDto createHeroDto);
    ResponseEntity<Hero> getHero(int id);
    ResponseEntity<List<Hero>> getHeroes();
    ResponseEntity<List<Hero>> findHeroesByQuery(FindHeroDto findHeroDto);

}
