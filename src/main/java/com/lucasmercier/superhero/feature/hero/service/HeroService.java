package com.lucasmercier.superhero.feature.hero.service;

import com.google.common.primitives.Ints;
import com.lucasmercier.superhero.entity.Hero;
import com.lucasmercier.superhero.entity.IncidentType;
import com.lucasmercier.superhero.entity.Location;
import com.lucasmercier.superhero.entity.assembler.EntityModelAssembler;
import com.lucasmercier.superhero.feature.common.contract.LocationRepositoryContract;
import com.lucasmercier.superhero.feature.common.contract.OpenStreetMapServiceContract;
import com.lucasmercier.superhero.feature.hero.contract.HeroRepositoryContract;
import com.lucasmercier.superhero.feature.hero.contract.HeroServiceContract;
import com.lucasmercier.superhero.feature.hero.dto.CreateHeroDto;
import com.lucasmercier.superhero.feature.incident.contract.IncidentTypeRepositoryContract;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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
    private final EntityModelAssembler<Hero> heroEntityModelAssembler;

    @Override
    public Hero createHero(CreateHeroDto createHeroDto) {
        Hero hero = new Hero();
        hero.setName(createHeroDto.getName());
        hero.setPhone(createHeroDto.getPhone());

        Location location = locationRepository.save(openStreetMapService.fetchLongitudeLatitudeOfCity(
                createHeroDto.getCity()
        ));
        hero.setLocation(location);

        List<IncidentType> incidentTypes = incidentTypeRepository.findAllById(Ints.asList(createHeroDto.getIncidents()));
        hero.setIncidentTypes(Set.copyOf(incidentTypes));

        return heroRepository.save(hero);
    }

    @Override
    public CollectionModel<EntityModel<Hero>> getHeroes() {
        return heroEntityModelAssembler.toCollectionModel(heroRepository.findAll());
    }
}
