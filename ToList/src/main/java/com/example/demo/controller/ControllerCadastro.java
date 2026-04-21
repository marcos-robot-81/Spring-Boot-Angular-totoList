package com.example.demo.controller;

import com.example.demo.Login.GService;
import com.example.demo.Otilitarios.JsonCString;
import com.example.demo.dbAll.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ControllerCadastro {

    public final GService gService;

    @Autowired
    public ControllerCadastro(GService gService) {
        this.gService = gService;
    }

    @PostMapping("/cadastro")
    public String cadastro(@RequestBody String dados) {
        JsonCString js = new JsonCString();
        Usuario usu = js.CriatDBUsuario(dados);
        String v = gService.cadastraUsuario(usu);
        return v;
    }
}
