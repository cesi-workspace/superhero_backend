package com.lucasmercier.superhero.feature.hero.service;

import com.google.common.primitives.Ints;
import com.lucasmercier.superhero.entity.Hero;
import com.lucasmercier.superhero.entity.IncidentType;
import com.lucasmercier.superhero.entity.Location;
import com.lucasmercier.superhero.feature.common.contract.LocationRepositoryContract;
import com.lucasmercier.superhero.feature.common.contract.OpenStreetMapServiceContract;
import com.lucasmercier.superhero.feature.hero.contract.HeroRepositoryContract;
import com.lucasmercier.superhero.feature.hero.contract.HeroServiceContract;
import com.lucasmercier.superhero.feature.hero.dto.CreateHeroDto;
import com.lucasmercier.superhero.feature.incident.contract.IncidentTypeRepositoryContract;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class HeroService implements HeroServiceContract {

    private final HeroRepositoryContract heroRepository;
    private final OpenStreetMapServiceContract openStreetMapService;
    private final LocationRepositoryContract locationRepository;
    private final IncidentTypeRepositoryContract incidentTypeRepository;

    @Override
    public ResponseEntity<Hero> createHero(CreateHeroDto createHeroDto) {
        Hero hero = new Hero();
        hero.setName(createHeroDto.getName());
        hero.setPhone(createHeroDto.getPhone());

        Location location = locationRepository.save(openStreetMapService.fetchLongitudeLatitudeOfCity(
                createHeroDto.getCity()
        ));
        hero.setLocation(location);

        List<IncidentType> incidentTypes = incidentTypeRepository.findAllById(Ints.asList(createHeroDto.getIncidents()));
        hero.setIncidentTypes(Set.copyOf(incidentTypes));

        return ResponseEntity.created(null).body(heroRepository.save(hero));
    }

    @Override
    public ResponseEntity<Hero> getHero(int id) {
        return ResponseEntity.ok(heroRepository.findById(id).orElseThrow());
    }

    @Override
    public ResponseEntity<List<Hero>> getHeroes() {
        return ResponseEntity.ok(heroRepository.findAll());
    }
}
