package com.example.demo.Login;

import com.example.demo.dbAll.Usuario;
import com.example.demo.dbAll.OperadoCrudUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Service
public class UsuarioService {
    //--
    private final MongoTemplate mongoTemplate;
    public UsuarioService(MongoTemplate mongoTemplate) {this.mongoTemplate = mongoTemplate;}

    @Autowired
    private OperadoCrudUsuario repository;
    //--
    private boolean verificaConequição(){
        try{
            repository.count();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Usuario criaUsuario(Usuario Usuario){
        return repository.save(Usuario);
    }

    public List<Usuario> buscarPorNome(String nome) {
        Query query = new Query(Criteria.where("nome").is(nome));
        return mongoTemplate.find(query, Usuario.class);
    }

    public void deletarUsuario(String id) {
        repository.deleteById(id);
    }

}
