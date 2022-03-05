package com.lucasmercier.superhero.validation;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ValidationResponse {

    private final Map<String, String> errors = new HashMap<>();

    public void addFieldError(FieldError fieldError) {
        errors.put(fieldError.getField(), fieldError.getDefaultMessage());
    }

}
