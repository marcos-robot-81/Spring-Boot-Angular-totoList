package com.example.demo.Web;

import com.example.demo.Login.GService;
import com.example.demo.Otilitarios.JsonCString;
import com.example.demo.dbAll.Usuario;
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

    @PostMapping("/login")
    public String login(@RequestBody String use){
        String v = GService.validado(use);
        if(v.length() > 4){
            return v;

        }
        return "Nome ou senha estão errados ou não Ezistem";
    }

    @PostMapping("/cadastro")
    public String cadastro(@RequestBody String dados){

        JsonCString js = new JsonCString();
        Usuario usu = js.CriatDBUsuario(dados);
        String v = GService.cadastraUsuario(usu);
        return v;
    }
    @PostMapping("/dados/get")
    public String dados(@RequestBody String chave){
        String n = "j";
        return n;
    }

    @PostMapping("/dados/salva")
    public String salva(@RequestBody String dados){
        GService.seve(dados);
        return "ok";
    }

}
