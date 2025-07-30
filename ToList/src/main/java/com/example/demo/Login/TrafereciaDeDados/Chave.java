package com.example.demo.Login.TrafereciaDeDados;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "chave")
public class Chave {
    @Id
    private String credeciais; /** Identificado di  **/
    private LocalDate diaDaCriação;

    public Chave(String id) {
        LocalDate a = LocalDate.now();
        this.diaDaCriação = a;
        this.credeciais = id+a.toString().replace("-","");;

    }

    public String getCredeciais() {
        return credeciais;
    }

    public LocalDate getDiaDaCriação() {
        return diaDaCriação;
    }
}


