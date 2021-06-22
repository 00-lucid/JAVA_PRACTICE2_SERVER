package com.javastates.MiniServer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ExceptionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 400
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> BadRequestException(final RuntimeException ex) {
        logger.warn("error");
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // 401
    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity handleAccessDeniedException(final AccessDeniedException ex) {
        logger.warn("error");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    // 500
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(final Exception ex) {
        logger.info(ex.getClass().getName());
        logger.warn("error");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
