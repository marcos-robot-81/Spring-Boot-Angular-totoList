package com.example.demo.dbAll;

import com.example.demo.card.Dados;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OperadoCrudDados extends MongoRepository<Dados, String> {}
