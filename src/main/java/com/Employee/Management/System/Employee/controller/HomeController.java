package com.Employee.Management.System.Employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "✅ Employee Management API is live. Visit /api/employees or /swagger-ui.html";
    }
}
