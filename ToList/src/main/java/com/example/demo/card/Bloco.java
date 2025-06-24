package com.example.demo.card;

public class Bloco {
    private int tipo = 0;
    private String titulo;
    private String text;
    private int valor = 0;



    // Comtruto
    public Bloco(int tipo){
        this.tipo = tipo;
        this.titulo = "New";
    }
    public Bloco(byte tipo ,String titulo,String text){
        this.tipo = tipo;
        this.text = text;
        this.titulo = titulo;
    }

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
    // --
}
