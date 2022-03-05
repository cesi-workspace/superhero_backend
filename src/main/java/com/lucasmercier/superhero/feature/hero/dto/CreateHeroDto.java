package com.lucasmercier.superhero.feature.hero.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
public class CreateHeroDto {

    @NotBlank
    private String name;

    @Pattern(
            regexp = "^(?:(?:\\+|00)33[\\s.-]{0,3}(?:\\(0\\)[\\s.-]{0,3})?|0)[1-9](?:(?:[\\s.-]?\\d{2}){4}|\\d{2}(?:[\\s.-]?\\d{3}){2})$",
            message = "n'est pas un numéro de téléphone"
    )
    private String phone;

    @Pattern(
            regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$",
            message = "ne correspond pas au nom d'une ville"
    )
    private String city;

    @NotNull
    @Size(min = 1, max = 3)
    private int[] incidents;

}
