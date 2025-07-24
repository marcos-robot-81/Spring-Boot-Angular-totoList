package com.example.demo.TrafereciaDeDados;
import java.time.LocalDate;


public class Chave {
    private String id;
    private LocalDate diaDaCriação;

    public Chave(String id) {
        this.id = id;
        this.diaDaCriação = LocalDate.now();
    }
    public Chave(String id,LocalDate data) {
        this.id = id;
        this.diaDaCriação = data;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDiaDaCriação() {
        return diaDaCriação;
    }
}


