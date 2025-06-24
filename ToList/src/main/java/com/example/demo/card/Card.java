package com.example.demo.card;

import java.util.LinkedList;

public class Card {
    private LinkedList<Bloco> Blocos = new LinkedList<>();

    // -- blocos
    public LinkedList<Bloco> getBlocos() {
        return Blocos;
    }
    public void setBlocos(LinkedList<Bloco> blocos) {
        Blocos = blocos;
    }

    // --  Metados
    // Adciona um novo Bloco
    public void addBloco(Bloco b){
        getBlocos().add(b);
    }
    // Retona um Bloco
    public Bloco getBloco(int a){
        return this.Blocos.get(a);
    }
    public int getTotalDeBlocos(){
        return Blocos.size();
    }

}
