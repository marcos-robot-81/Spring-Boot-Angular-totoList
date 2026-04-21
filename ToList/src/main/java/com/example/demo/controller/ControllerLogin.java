package com.example.demo.controller;

import com.example.demo.Login.GService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ControllerLogin {

    private final GService gService;

    @Autowired
    public ControllerLogin(GService gService) {
        this.gService = gService;
    }

    @PostMapping("/login")
    public String login(@RequestBody String use) {
        String v = gService.validado(use);
        if (v.length() > 4) {
            return v;
        } else {
            return "Nome ou senha estão errados ou não existem";
        }
    }
}
