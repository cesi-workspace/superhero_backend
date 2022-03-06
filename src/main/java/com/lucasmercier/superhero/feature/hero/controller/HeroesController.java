package com.lucasmercier.superhero.feature.hero.controller;

import com.lucasmercier.superhero.entity.Hero;
import com.lucasmercier.superhero.feature.hero.contract.HeroServiceContract;
import com.lucasmercier.superhero.feature.hero.dto.CreateHeroDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/heroes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class HeroesController {

    private final HeroServiceContract heroService;

    @PostMapping
    public ResponseEntity<Hero> create(@RequestBody @Valid CreateHeroDto hero) {
        return heroService.createHero(hero);
    }

    @GetMapping
    public ResponseEntity<List<Hero>> getList() {
        return heroService.getHeroes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> get(@PathVariable int id) {
        return heroService.getHero(id);
    }
}
