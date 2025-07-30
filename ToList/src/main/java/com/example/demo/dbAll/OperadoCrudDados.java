package com.example.demo.dbAll;

import com.example.demo.card.Dados;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OperadoCrudDados extends MongoRepository<Dados, String> {
}
