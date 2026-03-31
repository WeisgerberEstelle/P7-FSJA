package com.openclassroom.devops.orion.microcrm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoResourceFoundException.class)
    public void handleNotFound(NoResourceFoundException ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.error("404 Not Found: {} {}", request.getMethod(), request.getRequestURI());
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.error("500 Internal Error: {} {} - {}", request.getMethod(), request.getRequestURI(), ex.getMessage());
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
