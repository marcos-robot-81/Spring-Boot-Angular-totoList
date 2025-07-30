package com.example.demo.card;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Dados")
public class Dados {
    @Id
    private String id;
    private List<Bloco> dados = new ArrayList<>();
    // comtruto

    public Dados(){}
    public Dados(String id){this.id = id;}
    public Dados(String id, List<Bloco> dados){this.id = id; this.dados = dados;}
    
    public List<Bloco> getDados() {
        return dados;
    }
    public void setDados(List<Bloco> dados) {
        this.dados = dados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addbloco(Bloco b){
        this.dados.add(b);
    }
    public void primeroDado(){
        Bloco b = new Bloco();
        b.primerabloco();
        this.dados.add(b);
    }
}
