package com.lucasmercier.superhero.feature.hero.repository;

import com.lucasmercier.superhero.entity.Hero;
import com.lucasmercier.superhero.feature.hero.contract.HeroRepositoryContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaHeroRepository extends HeroRepositoryContract, JpaRepository<Hero, Integer> {

}
