package com.example.demo.controller;

import com.example.demo.Login.GService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/dados")
public class ControllerDados {

    private final GService gService;

    private ControllerDados(GService gService) {
        this.gService = gService;
    }

    @PostMapping("/getDados")
    public String getDados(@RequestBody String chave) {
        String n = "";
        return n;
    }

    @PostMapping("/setDados")
    public String setDados(@RequestBody String dados) {
        gService.seve(dados);
        return "ok";
    }
}
