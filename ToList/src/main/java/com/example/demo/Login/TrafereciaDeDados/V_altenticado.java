package com.example.demo.Login.TrafereciaDeDados;
import com.example.demo.dbAll.Usuario;

import java.time.LocalDate;

public class V_altenticado {
private Chave chave;
public String criaChavi(Usuario usu){
    this.chave = new Chave(usu.getId());
    return chave.getCredeciais();
}
    public Chave getChave() {
        return chave;
    }
}
