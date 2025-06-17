package com.example.demo.card;

import java.util.LinkedList;

public class Card {
    private LinkedList<Bloco> Blocos = new LinkedList<>();

    // blocos
    public LinkedList<Bloco> getBlocos() {
        return Blocos;
    }
    public void setBlocos(LinkedList<Bloco> blocos) {
        Blocos = blocos;
    }
    public void addBloco(Bloco b){
        getBlocos().add(b);
    }
}
