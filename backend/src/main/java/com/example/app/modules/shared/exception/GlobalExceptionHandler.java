package com.example.app.modules.shared.exception;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ApiError> notFound(NotFoundException ex) { return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(ex.getMessage())); }
    @ExceptionHandler({UnauthorizedException.class, JwtException.class})
    ResponseEntity<ApiError> unauthorized(RuntimeException ex) { return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiError(ex.getMessage())); }
}
