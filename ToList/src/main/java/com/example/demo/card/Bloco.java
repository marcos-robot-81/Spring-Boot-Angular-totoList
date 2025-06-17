package com.example.demo.card;

public class Bloco {
    private String titulo;
    private String text;



    // Comtruto
    public Bloco(){
        this.titulo = "New";
    }
    public Bloco(String titulo,String text){
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

    public String getText() {
        return text;
    }

    public String getTitulo() {
        return titulo;
    }
    // --
}
