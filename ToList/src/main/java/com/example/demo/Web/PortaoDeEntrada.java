package com.example.demo.Web;

import com.example.demo.Login.Usuario;
import com.example.demo.Login.GService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200/")
public class PortaoDeEntrada {
    private final GService GService;

    @Autowired
    public PortaoDeEntrada(GService GService) {
        this.GService = GService;
    }


    @GetMapping("/{carakt}")
    public String test1(@PathVariable String carakt){
        return carakt+" Todo certo";

    }

    @PostMapping("/login")
    public String login(@RequestBody String use){

        boolean v = GService.validado(use);

        if(v == true){
            return "Altorizado";
        }
        return "Nome ou senha estão errados ou não Ezistem";
    }

    @PostMapping("/cadastro")
    public String cadastro(@RequestBody String dados){

        Usuario usu = new Usuario();
        {
            int t1,t2,t3;
            t1 = dados.indexOf("name");
            t2 = dados.indexOf("password");
            t3 = dados.length();
            usu.setAll((dados.substring(t1+7,t2-3)),dados.substring(t2+11,t3-3));
        }
        String v = GService.cadastraUsuario(usu);
        return v;
    }

}
