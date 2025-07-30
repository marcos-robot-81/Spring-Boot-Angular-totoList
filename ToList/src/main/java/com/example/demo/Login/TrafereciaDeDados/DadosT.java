package com.example.demo.Login.TrafereciaDeDados;

import com.example.demo.card.Dados;

public class DadosT {
    private String id;
    private Dados dados;
    private String estatos;

    public DadosT(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public String getIdUse() {
        return id.substring(0,id.length()-8);
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

    public void setEstatus(String i){
        this.estatos = i;
    }
    public String getEstatos(){
        return this.estatos;
    }
}
