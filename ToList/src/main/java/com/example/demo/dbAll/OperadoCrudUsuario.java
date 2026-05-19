package com.example.demo.dbAll;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OperadoCrudUsuario extends MongoRepository<Usuario, String> {
    Usuario findByName(String name);
}
