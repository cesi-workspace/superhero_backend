package com.lucasmercier.superhero.feature.common.contract;

import com.lucasmercier.superhero.entity.Location;

public interface OpenStreetMapServiceContract {

    Location fetchLongitudeLatitudeOfCity(String cityName);

}
