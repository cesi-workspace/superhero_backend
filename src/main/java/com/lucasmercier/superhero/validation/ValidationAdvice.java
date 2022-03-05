package com.lucasmercier.superhero.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ValidationAdvice {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ValidationResponse handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        ValidationResponse validationResponse = new ValidationResponse();
        exception.getFieldErrors().forEach(validationResponse::addFieldError);
        return validationResponse;
    }

}
