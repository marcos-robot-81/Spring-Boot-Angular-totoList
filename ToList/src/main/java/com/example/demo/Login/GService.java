package com.example.demo.Login;

import com.example.demo.dbAll.DBUsuario;
import com.example.demo.dbAll.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dbAll.DBUsuario;

import java.util.ArrayList;
import java.util.List;

@Service
public class GService {

    private final UsuarioService usuarioService;

    @Autowired
    public GService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Valida usuario
    public boolean validado(String usuariox){
        //Criado ussuario para a comparação
        DBUsuario uso = new DBUsuario();
        //set valores do ussario
        {
            int t1,t2,t3;
            t1 = usuariox.indexOf("name");
            t2 = usuariox.indexOf("password");
            t3 = usuariox.length();
            uso.setAll((usuariox.substring(t1+7,t2-3)),usuariox.substring(t2+11,t3-3));
        }
        List<DBUsuario> ListUsuarios = (usuarioService.buscarPorNome(uso.getNome()));
        for(int i = 0;i < ListUsuarios.size();i++){
            if(  (  (uso.getNome()).equals(ListUsuarios.get(i).getNome()) ) && ((uso.getPassword()).equals(ListUsuarios.get(i).getPassword()) ) ){
                return true;
            }
        }
        return false;
    }
    public String cadastraUsuario(Usuario usu){
        DBUsuario usux = new DBUsuario(usu.getNome(),usu.getPassword());
        usuarioService.criaUsuario(usux);
        return "ok";
    }

}
