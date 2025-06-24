package com.example.demo.Login;

import java.util.ArrayList;

public class Tbanco {

    ArrayList<Usuario> Usu = new ArrayList<>();
    Usuario u1 = new Usuario("marcos","12345678");
    Usuario u2 = new Usuario("a","01");
    Usuario u3 = new Usuario("zero","00");
    Usuario u4 = new Usuario("z","99");
    Usuario u5 = new Usuario("b","87654321");

    public ArrayList<Usuario> getUsu(){

        Usu.add(u1);
        Usu.add(u2);
        Usu.add(u3);
        Usu.add(u4);
        Usu.add(u5);

        return Usu;
    }

}
