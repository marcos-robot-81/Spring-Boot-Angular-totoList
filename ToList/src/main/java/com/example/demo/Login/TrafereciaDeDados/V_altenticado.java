package com.example.demo.Login.TrafereciaDeDados;
import com.example.demo.dbAll.Usuario;

import java.time.LocalDate;

public class V_altenticado {

public String criaChavi(Usuario usu){

    Chave chave = new Chave(usu.getId());
    return chave.getCredeciais();
}


}
