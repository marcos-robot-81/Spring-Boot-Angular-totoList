package com.example.demo.card;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Dados")
public class Dados {
    @Id
    private String id;
    private List<Bloco> blocos = new ArrayList<>();
    // comtruto

    public Dados(){}
    public Dados(String id){this.id = id;}
    public Dados(String id, List<Bloco> dados){this.id = id; this.blocos = dados;}
    
    public List<Bloco> getBlocos() {
        return blocos;
    }
    public void setBlocos(List<Bloco> blocos) {
        this.blocos = blocos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addbloco(Bloco b){
        this.blocos.add(b);
    }
    public void primeroDado(){
        Bloco b = new Bloco();
        b.primerabloco();
        this.blocos.add(b);
    }
}
