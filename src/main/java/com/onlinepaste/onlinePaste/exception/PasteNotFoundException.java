package com.onlinepaste.onlinePaste.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PasteNotFoundException extends RuntimeException {

    public PasteNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
