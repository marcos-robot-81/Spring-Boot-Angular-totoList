package com.example.demo.Login;

public class Usuario {
    private String nome;
    private String password;

    public Usuario(){}
    public Usuario(String nome, String password){
        this.nome=nome; this.password = password;
    }

    //get
    public String getNome() {
        return nome;
    }
    public String getPassword() {
        return password;
    }
    //set all
    public void setAll(String nome, String password){
        this.nome=nome; this.password = password;
    }

}

