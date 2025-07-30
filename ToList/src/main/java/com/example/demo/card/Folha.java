package com.example.demo.card;

public class Folha {
    private String id;
    private int tipo = 0;
    private String titulo;
    private String text;
    private int valor = 0;


    // Comtruto
    public Folha(int tipo, String id){
        this.tipo = tipo;
        this.id = id;
        this.titulo = "New";
    }
    public Folha(byte tipo , String titulo, String text){
        this.tipo = tipo;
        this.text = text;
        this.titulo = titulo;
    }
    public Folha(){}


    // Get e set
    public void setText(String text) {
        this.text = text;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setTipo(int valor){
        this.valor = valor;
    }

    public String getText() {
        return text;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    public void primeiraFolha(){
        this.id = "0";
        this.titulo = "Primeira folha";
        this.text = "Bem Vindo :)";

    }
    // --
}
