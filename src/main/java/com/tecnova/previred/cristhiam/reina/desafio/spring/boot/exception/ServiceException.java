package com.tecnova.previred.cristhiam.reina.desafio.spring.boot.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;

    public ServiceException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.httpStatus = httpStatus;
    }
}
