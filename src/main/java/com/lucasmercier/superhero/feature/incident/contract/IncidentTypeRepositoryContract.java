package com.lucasmercier.superhero.feature.incident.contract;

import com.lucasmercier.superhero.entity.IncidentType;

import java.util.List;

public interface IncidentTypeRepositoryContract {

    List<IncidentType> findAllById(Iterable<Integer> ids);

}
