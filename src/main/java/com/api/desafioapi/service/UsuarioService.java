package com.api.desafioapi.service;

import com.api.desafioapi.document.Usuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {

	//Flux vários objetos
	Flux<Usuario> findAll();
	//Mono apenas um obj
	Mono<Usuario> findById(String id);
	Mono<Usuario> save(Usuario playlist);
}
