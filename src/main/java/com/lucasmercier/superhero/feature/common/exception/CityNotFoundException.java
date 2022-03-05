package com.lucasmercier.superhero.feature.common.exception;

import lombok.Getter;

@Getter
public class CityNotFoundException extends RuntimeException {

    private final String city;

    public CityNotFoundException(String city) {
        super(String.format("City %s not found.", city));

        this.city = city;
    }

}
