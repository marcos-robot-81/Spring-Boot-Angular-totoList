package com.example.demo;


import com.example.demo.card.Bloco;
import com.example.demo.card.Card;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testCard {
    private Card c1 = new Card();

    @Test
    public void tCard(){

        CriaçãoDeTresBlocos();
        c1.getBloco(1).setText("Ola mundo");
        System.out.println(c1.getBloco(1).getText());

    }

    private void CriaçãoDeTresBlocos(){
        Bloco a1 = new Bloco(0);
        Bloco a2 = new Bloco(0);
        Bloco a3 = new Bloco(0);

        c1.addBloco(a1);
        c1.addBloco(a2);
        c1.addBloco(a3);
    }


}
