package com.example.demo.Login.TrafereciaDeDados;

import com.example.demo.card.Dados;

public class Cabesario {
    private String credenciais;
    private Dados conteudo;
    private String estatos;

    public Cabesario(String id){
        this.credenciais = id;
    }

    public String getCredenciais() {
        return credenciais;
    }
    public String getIdUse() {

        return credenciais.substring(0,credenciais.length()-8);
    }

    public void setCredenciais(String id) {
        this.credenciais = id;
    }

    public Dados getConteudo() {
        return conteudo;
    }

    public void setConteudo(Dados conteudo) {
        this.conteudo = conteudo;
    }

    public void setEstatus(String i){
        this.estatos = i;
    }
    public String getEstatos(){
        return this.estatos;
    }
}
