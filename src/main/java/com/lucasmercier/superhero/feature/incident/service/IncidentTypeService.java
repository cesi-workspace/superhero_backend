package com.lucasmercier.superhero.feature.incident.service;

import com.lucasmercier.superhero.entity.IncidentType;
import com.lucasmercier.superhero.feature.incident.contract.IncidentTypeRepositoryContract;
import com.lucasmercier.superhero.feature.incident.contract.IncidentTypeServiceContract;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IncidentTypeService implements IncidentTypeServiceContract {

    private final IncidentTypeRepositoryContract incidentTypeRepository;

    @Override
    public ResponseEntity<List<IncidentType>> getIncidentTypes() {
        return ResponseEntity.ok(incidentTypeRepository.findAll());
    }
}
