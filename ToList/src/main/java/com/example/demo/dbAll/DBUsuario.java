package com.example.demo.dbAll;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuarios")
public class DBUsuario {
    @Id
    private String id;
    private String nome;
    private String password;

    public DBUsuario(){}
    public DBUsuario(String name, String password){
        this.nome = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setAll(String nome, String password){
        this.nome=nome; this.password = password;
    }
}
