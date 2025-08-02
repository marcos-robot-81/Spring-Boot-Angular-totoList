package com.example.demo.card;

public class Folha {
    private String id;
    private int tipo = 0;
    private String titulo;
    private String texto;



    // Comtruto
    public Folha(int tipo, String id){
        this.tipo = tipo;
        this.id = id;
        this.titulo = "New";
    }
    public Folha(byte tipo , String titulo, String text){
        this.tipo = tipo;
        this.texto = text;
        this.titulo = titulo;
    }
    public Folha(){}


    // Get e set
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setTipo(int valor){
        this.tipo = valor;
    }

    public String getTexto() {
        return texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTipo() {
        return tipo;
    }

    public void primeiraFolha(){
        this.id = "0";
        this.titulo = "Primeira folha";
        this.texto = "Bem Vindo :)";

    }
    // --
}
