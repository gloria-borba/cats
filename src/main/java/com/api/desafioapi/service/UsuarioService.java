package com.api.desafioapi.service;

import com.api.desafioapi.document.Usuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {

	//Flux vários objetos
	Flux<Usuario> findAll();
	
	//Mono apenas um obj
	Mono<Usuario> findByLogin(String id);
	
	Mono<Usuario> save(Usuario playlist) throws Exception;
	
	void deletedById(String id); 
	
}
