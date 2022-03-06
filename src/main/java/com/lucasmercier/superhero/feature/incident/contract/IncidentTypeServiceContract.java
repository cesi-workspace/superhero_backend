package com.lucasmercier.superhero.feature.incident.contract;

import com.lucasmercier.superhero.entity.IncidentType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IncidentTypeServiceContract {

    ResponseEntity<List<IncidentType>> getIncidentTypes();

}
