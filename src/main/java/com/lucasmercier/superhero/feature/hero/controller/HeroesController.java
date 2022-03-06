package com.lucasmercier.superhero.feature.hero.controller;

import com.lucasmercier.superhero.entity.Hero;
import com.lucasmercier.superhero.feature.hero.contract.HeroServiceContract;
import com.lucasmercier.superhero.feature.hero.dto.CreateHeroDto;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/heroes")
@RequiredArgsConstructor
public class HeroesController {

    private final HeroServiceContract heroService;

    @PostMapping
    public EntityModel<Hero> create(@RequestBody @Valid CreateHeroDto hero) {
        return heroService.createHero(hero);
    }

    @GetMapping
    public CollectionModel<EntityModel<Hero>> getList() {
        return heroService.getHeroes();
    }

    @GetMapping("/{id}")
    public EntityModel<Hero> get(@PathVariable int id) {
        return heroService.getHero(id);
    }
}
