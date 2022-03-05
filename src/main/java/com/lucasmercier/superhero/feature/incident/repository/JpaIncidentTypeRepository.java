package com.lucasmercier.superhero.feature.incident.repository;

import com.lucasmercier.superhero.entity.IncidentType;
import com.lucasmercier.superhero.feature.incident.contract.IncidentTypeRepositoryContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaIncidentTypeRepository extends IncidentTypeRepositoryContract, JpaRepository<IncidentType, Integer> {
}
