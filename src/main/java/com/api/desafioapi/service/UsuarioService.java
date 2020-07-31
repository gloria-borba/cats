package com.api.desafioapi.service;

import com.api.desafioapi.document.Usuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {

	/**
	 * Consulta todos os usuários
	 * 
	 * @return Flux<Usuario>
	 */
	Flux<Usuario> findAll();

	/**
	 * Consulta um usuário pelo login
	 * 
	 * @param login
	 * @return Mono<Usuario>
	 */
	Mono<Usuario> findByLogin(String login);

	/**
	 * Salva um usuário
	 * @param usuario
	 * @return Mono<Usuario>
	 */
	Mono<Usuario> save(Usuario usuario);

	/**
	 * Deleta um usuário pelo login
	 * 
	 * @param login
	 */
	Mono<Void> deletedByLogin(String login);

	/**
	 * Atualização da senha/nome do usuário
	 * 
	 * @param login
	 * @param usuario
	 * @return Mono<Usuario>
	 */
	Mono<Usuario> update(String login, Usuario usuario);

}
