package com.example.demo.TrefereciaDeDados;
import com.example.demo.TrafereciaDeDados.Chave;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestChave {

    @Test
    public void tchave(){
        Chave c = new Chave("2");
        System.out.println(c.getId());
        System.out.println(c.getDiaDaCriação());
    }

}
