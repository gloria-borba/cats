package com.api.desafioapi.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.api.desafioapi.document.Usuario;

public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String>{

}
