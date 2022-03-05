package com.lucasmercier.superhero.feature.common.repository;

import com.lucasmercier.superhero.entity.Location;
import com.lucasmercier.superhero.feature.common.contract.LocationRepositoryContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLocationRepository extends LocationRepositoryContract, JpaRepository<Location, Integer> {
}
