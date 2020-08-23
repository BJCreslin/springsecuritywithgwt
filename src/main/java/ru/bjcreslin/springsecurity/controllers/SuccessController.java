package ru.bjcreslin.springsecurity.controllers;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class SuccessController {
    @GetMapping("/success")
    public String getSuccessPage() {
    log.fine("success");
        return "success";
    }
}
