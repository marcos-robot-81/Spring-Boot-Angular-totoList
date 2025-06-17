package com.example.demo;


import com.example.demo.card.Bloco;
import com.example.demo.card.Card;

public class testCard {

    public void tCard(){
        Bloco a1 = new Bloco();
        Bloco a2 = new Bloco();
        Bloco a3 = new Bloco();

        Card c1 = new Card();
        c1.addBloco(a1);
        c1.addBloco(a2);
        c1.addBloco(a3);
    }


}
