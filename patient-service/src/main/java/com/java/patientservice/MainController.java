package com.java.patientservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/patients")
    public String patients(){
        return "List of patients";
    }
}