package com.example.demo.dbAll;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.google.gson.annotations.SerializedName;

@Document(collection = "Usuarios")
public class Usuario {
    @Id
    private String id;

    @Field("nome")
    @SerializedName("name")
    private String name;

    @Field("password")
    private String password;

    public Usuario(){};

    public Usuario(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setAll(String name, String password){
        this.name = name; this.password = password;
    }
}
