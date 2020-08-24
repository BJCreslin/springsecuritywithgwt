package ru.bjcreslin.springsecurity.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthRestController {

    ResponseEntity<?> authentication() {
        return null;
    }
}
