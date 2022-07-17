package com.java.diseaseservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/diseases")
    public String diseses(){
        return "List of diseases";
    }
}