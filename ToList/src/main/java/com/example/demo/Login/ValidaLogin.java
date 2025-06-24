package com.example.demo.Login;

import java.util.ArrayList;

public class ValidaLogin {

    public boolean validado(String usuariox){
        // pegado banco de dados.
        Tbanco t = new Tbanco();
        ArrayList<Usuario> usos = new ArrayList<>();
        usos = t.getUsu();
        //Criado ussuario para a comparação
        Usuario uso = new Usuario();
        //set valores do ussario
        {
            int t1,t2,t3;
            t1 = usuariox.indexOf("name");
            t2 = usuariox.indexOf("password");
            t3 = usuariox.length();
            uso.setAll((usuariox.substring(t1+7,t2-3)),usuariox.substring(t2+11,t3-3));
        }

        //verificado se o usuario ezsite.

        for(int i = 0;i < usos.size();i++){
            if(  (  (uso.getNome()).equals(usos.get(i).getNome()) ) && ((uso.getPassword()).equals(usos.get(i).getPassword()) ) ){
                return true;
            }
        }
        return false;
    }
}
