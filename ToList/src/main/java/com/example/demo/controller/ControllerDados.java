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

    @PostMapping("/get")
    public String getDados(@RequestBody String json) {
        // O front envia algo como [{"chave":"token"}]
        // Vamos extrair o token de forma simples para manter compatibilidade
        String token = "";
        if (json.contains("\"chave\":\"")) {
            int start = json.indexOf("\"chave\":\"") + 9;
            int end = json.indexOf("\"", start);
            token = json.substring(start, end);
        }

        return gService.getDadosPorToken(token);
    }

    @PostMapping("/salva")
    public String setDados(@RequestBody String dados) {
        return gService.salva(dados);
    }
}
