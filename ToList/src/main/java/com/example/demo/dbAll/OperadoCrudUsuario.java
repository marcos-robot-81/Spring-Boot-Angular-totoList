package com.example.demo.dbAll;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OperadoCrudUsuario extends MongoRepository<Usuario, String> {
    List<Usuario> findByNome(String nome);
}
