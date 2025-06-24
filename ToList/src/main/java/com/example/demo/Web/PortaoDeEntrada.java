package com.example.demo.Web;

import com.example.demo.Login.Usuario;
import com.example.demo.Login.ValidaLogin;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200/")
public class PortaoDeEntrada {


    @GetMapping("/{carakt}")
    public String test1(@PathVariable String carakt){
        return carakt+" Todo certo";

    }

    @PostMapping("/login")
    public String login(@RequestBody String use){

        ValidaLogin vl = new ValidaLogin();

        boolean v = vl.validado(use);

        if(v == true){
            return "Altorizado";
        }
        return "Nome ou senha estão errados ou não Ezistem";
    }

}
