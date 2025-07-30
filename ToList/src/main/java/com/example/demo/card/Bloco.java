package com.example.demo.card;

import java.util.LinkedList;

public class Bloco {
    private int id;
    private String Titulo;
    private LinkedList<Folha> bloco = new LinkedList<>();

    // -- Folhas
    public LinkedList<Folha> getBloco() {
        return bloco;
    }
    public void setBloco(LinkedList<Folha> bloco) {
        this.bloco = bloco;
    }

    // --  Metados
    // Adciona um novo Folha
    public void addBloco(Folha b){
        getBloco().add(b);
    }
    // Retona um Folha
    public Folha getBloco(int a){
        return this.bloco.get(a);
    }
    public int getTotalDeBlocos(){
        return bloco.size();
    }

    public void primerabloco(){
        this.Titulo = "bem vindo";
        Folha f = new Folha(0,"0");
        f.primeiraFolha();
        bloco.add(f);
    }


}
