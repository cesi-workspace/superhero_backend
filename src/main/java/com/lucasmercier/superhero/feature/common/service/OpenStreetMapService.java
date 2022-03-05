package com.lucasmercier.superhero.feature.common.service;

import com.lucasmercier.superhero.entity.Location;
import com.lucasmercier.superhero.feature.common.contract.HttpClientServiceContract;
import com.lucasmercier.superhero.feature.common.contract.OpenStreetMapServiceContract;
import com.lucasmercier.superhero.feature.common.exception.CityNotFoundException;
import com.lucasmercier.superhero.feature.common.response.NominatimResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OpenStreetMapService implements OpenStreetMapServiceContract {

    private final HttpClientServiceContract httpClientService;

    @Override
    public Location fetchLongitudeLatitudeOfCity(String cityName) {
        NominatimResponse[] nominatimResponses = httpClientService.get(
                "https://nominatim.openstreetmap.org/search?format=json&countrycodes=fr&limit=1&q=" + cityName,
                NominatimResponse[].class
        );

        if (nominatimResponses.length == 0) {
            throw new CityNotFoundException(cityName);
        }

        Location location = new Location();
        location.setLongitude(nominatimResponses[0].getLon());
        location.setLatitude(nominatimResponses[0].getLat());

        return location;
    }
}
