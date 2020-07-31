package com.api.desafioapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.api.desafioapi.document.Usuario;
import com.api.desafioapi.repository.UsuarioRepository;
import com.api.desafioapi.service.UsuarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository repository;

	@Override
	public Flux<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Usuario> findByLogin(String login) {
		return repository.findById(login);
	}

	@Override
	public Mono<Usuario> save(Usuario usuario) {

		String encodedPassword = DigestUtils.md5DigestAsHex(usuario.getSenha().getBytes());
		usuario.setSenha(encodedPassword);

		return this.findByLogin(usuario.getLogin()).switchIfEmpty(repository.save(usuario)).
		// lançar exceção
				then(null);

	}

	@Override
	public Mono<Void> deletedByLogin(String login) {
		return repository.deleteById(login);
	}

	@Override
	public Mono<Usuario> update(String login, Usuario usuario) {
		return this.findByLogin(login).flatMap(existingUser -> {
			existingUser.setSenha(usuario.getSenha() != null ? DigestUtils.md5DigestAsHex(usuario.getSenha().getBytes())
					: DigestUtils.md5DigestAsHex(existingUser.getSenha().getBytes()));
			existingUser.setNome(usuario.getNome() != null ? usuario.getNome() : existingUser.getNome());
			return repository.save(existingUser);
		});
	}

}
