package com.openclassroom.devops.orion.microcrm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.http.HttpMethod;

import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        when(request.getMethod()).thenReturn("GET");
        when(request.getRequestURI()).thenReturn("/unknown");
    }

    @Test
    void handleNotFound_returns404() throws Exception {
        NoResourceFoundException ex = new NoResourceFoundException(HttpMethod.GET, "/unknown");

        handler.handleNotFound(ex, request, response);

        verify(response).sendError(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void handleException_returns500() throws Exception {
        Exception ex = new RuntimeException("test error");

        handler.handleException(ex, request, response);

        verify(response).sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
