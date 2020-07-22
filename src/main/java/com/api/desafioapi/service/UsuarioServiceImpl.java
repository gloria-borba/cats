package com.api.desafioapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.desafioapi.document.Usuario;
import com.api.desafioapi.repository.UsuarioRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository repository;

	@Override
	public Flux<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Usuario> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<Usuario> save(Usuario playlist) {
		return repository.save(playlist);
	}

	@Override
	public void deletedById(String id) {
		repository.deleteById(id);

	}
	
	

}
