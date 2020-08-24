package ru.bjcreslin.springsecurity.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {
    private final HttpStatus httpStatus;

    public JwtAuthenticationException(String msg, Throwable t,HttpStatus httpStatus) {
        super(msg, t);
        this.httpStatus = httpStatus;
    }

    public JwtAuthenticationException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}
