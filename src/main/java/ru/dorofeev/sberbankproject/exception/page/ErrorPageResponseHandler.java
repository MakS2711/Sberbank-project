package ru.dorofeev.sberbankproject.exception.page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorPageResponseHandler {

    @ExceptionHandler(NoSuchPageException.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(new ErrorPageResponse(status.value(), ex.getMessage()), status);
    }
}
