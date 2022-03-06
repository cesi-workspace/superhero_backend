package com.lucasmercier.superhero.feature.incident.controller;

import com.lucasmercier.superhero.entity.IncidentType;
import com.lucasmercier.superhero.feature.incident.contract.IncidentTypeServiceContract;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/incident-types")
@RequiredArgsConstructor
public class IncidentTypesController {

    private final IncidentTypeServiceContract incidentTypeService;
    
    @GetMapping
    public ResponseEntity<List<IncidentType>> getIncidentTypes() {
        return incidentTypeService.getIncidentTypes();
    }

}
