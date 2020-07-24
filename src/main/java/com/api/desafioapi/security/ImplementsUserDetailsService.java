package com.api.desafioapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.api.desafioapi.document.Usuario;
import com.api.desafioapi.repository.UsuarioRepository;

import reactor.core.publisher.Mono;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Mono<Usuario> usuario = repository.findById(login);
		
		if(usuario == null){
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return new User(((UserDetails) usuario).getUsername(), ((UserDetails) usuario).getPassword(), true, true, true, true, ((UserDetails) usuario).getAuthorities());
	}

}
