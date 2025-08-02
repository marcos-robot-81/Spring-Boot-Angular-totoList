package com.example.demo.card;

import java.util.LinkedList;

public class Bloco {
    private int id;
    private String titulo;
    private LinkedList<Folha> folhas = new LinkedList<>();

    // -- Folhas
    public LinkedList<Folha> getFolhas() {
        return folhas;
    }
    public void setFolhas(LinkedList<Folha> folhas) {
        this.folhas = folhas;
    }

    // --  Metados

    // Adciona um novo Folha
    public void addBloco(Folha b){
        getFolhas().add(b);
    }
    // Retona um Folha
    public Folha getBloco(int a){
        return this.folhas.get(a);
    }
    public int getTotalDeBlocos(){
        return folhas.size();
    }

    public void primerabloco(){
        this.titulo = "bem vindo";
        Folha f = new Folha(0,"0");
        this.id = 1 ;
        f.primeiraFolha();
        folhas.add(f);
    }


}
