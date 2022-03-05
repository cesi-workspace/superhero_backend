package com.lucasmercier.superhero.feature.common.contract;

import com.lucasmercier.superhero.entity.Location;

public interface LocationRepositoryContract {

    <S extends Location> S save(S entity);

}
