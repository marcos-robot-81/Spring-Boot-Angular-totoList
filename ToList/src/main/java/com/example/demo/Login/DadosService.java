package com.example.demo.Login;

import com.example.demo.Login.TrafereciaDeDados.DadosT;
import com.example.demo.card.Bloco;
import com.example.demo.card.Dados;
import com.example.demo.dbAll.OperadoCrudDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DadosService {
    //--
    private final MongoTemplate mongoTemplate;
    public DadosService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Autowired
    private OperadoCrudDados repository;
    //--
    public boolean CriaDadosUse(String iduse){
        Dados dados = new Dados(iduse);
        dados.primeroDado();
        repository.save(dados);
        return true;
    }
    public Dados getDados(String id){
        Dados dados = mongoTemplate.findById(id, Dados.class);
        return dados;
    }
    public void AtualiaDados(Dados dados){
        Query query = new Query(Criteria.where("id").is(dados.getId()));
        Update update = new Update().set("dados", dados);
        mongoTemplate.updateFirst(query, update, Dados.class);
    }

}
