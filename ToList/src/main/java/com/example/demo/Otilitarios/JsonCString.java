package com.example.demo.Otilitarios;

import com.example.demo.dbAll.Usuario;

// Comverte json para fomato desejado
public class JsonCString {

    public Usuario CriatDBUsuario(String dados){
        Usuario usu = new Usuario();
        {
            int t1,t2,t3;
            t1 = dados.indexOf("name");
            t2 = dados.indexOf("password");
            t3 = dados.length();
            usu.setAll((dados.substring(t1+7,t2-3)),dados.substring(t2+11,t3-3));
        }
        return usu;
    }

}
