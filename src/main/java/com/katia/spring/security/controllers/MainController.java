package com.katia.spring.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }
    @GetMapping("/admin")
    public String pageForAdmins(Principal principal) {
        return "secured part of web service: " + principal.getName();
    }
}
