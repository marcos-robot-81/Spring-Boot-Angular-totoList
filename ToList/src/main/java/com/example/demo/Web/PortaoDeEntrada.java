package com.example.demo.Web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PortaoDeEntrada {


    @GetMapping("/{nome}")
    public String test1(@PathVariable String nome){
        return nome;
    }


}
