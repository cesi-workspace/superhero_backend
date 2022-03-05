package com.lucasmercier.superhero.feature.hero.controller;

import com.lucasmercier.superhero.feature.hero.contract.HeroServiceContract;
import com.lucasmercier.superhero.feature.hero.dto.CreateHeroDto;
import com.lucasmercier.superhero.entity.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/heroes")
@RequiredArgsConstructor
public class HeroesController {

    private final HeroServiceContract heroService;

    @PostMapping
    public Hero createHero(@RequestBody @Valid CreateHeroDto hero) {
        return heroService.createHero(hero);
    }

}
