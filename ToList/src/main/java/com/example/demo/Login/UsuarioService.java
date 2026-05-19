package com.example.demo.Login;

import com.example.demo.dbAll.Usuario;
import com.example.demo.dbAll.OperadoCrudUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private OperadoCrudUsuario repository;

    public Usuario criaUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario buscarPorNome(String nome) {
        return repository.findByName(nome);
    }

    public void deletarUsuario(String id) {
        repository.deleteById(id);
    }

}
