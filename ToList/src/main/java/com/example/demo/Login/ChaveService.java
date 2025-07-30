package com.example.demo.Login;

import com.example.demo.dbAll.OperadoCrudUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.example.demo.Login.TrafereciaDeDados.Chave;

public class ChaveService {
    private final MongoTemplate mongoTemplate;
    public ChaveService(MongoTemplate mongoTemplate) {this.mongoTemplate = mongoTemplate;}
    @Autowired
    private OperadoCrudUsuario repository;

    public boolean newChave(Chave c){
        mongoTemplate.save(c);
        return true;
    }
    public void DeleteTodasChave(){
        repository.deleteAll();
    }
    public boolean verificaChavaAtiva(String id){
        Chave chava = mongoTemplate.findById(id, Chave.class);
        if(chava.getCredeciais() == id ){
            return true;
        }else{
            return false;
        }
    }
}
