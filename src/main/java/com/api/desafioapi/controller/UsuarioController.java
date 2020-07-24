package com.api.desafioapi.controller;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafioapi.document.Usuario;
import com.api.desafioapi.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Api("API REST Usuarios")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@GetMapping
	@ApiOperation(tags = { "Usuário" }, value = "Retorna todos os usuários")
	public Flux<Usuario> getUsuario(){
		return service.findAll();
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(tags = { "Usuário" }, value = "Retorna um usuário pelo login")
	public Mono<Usuario> getUsuarioLogin(@PathVariable String id){
		return service.findByLogin(id);
	}
	
	@PostMapping
	@ApiOperation(tags = { "Usuário" }, value = "Salva um usuário")
	public Mono<Usuario> save(@RequestBody Usuario usuario) throws Exception{
		return service.save(usuario);
	}
	
	@DeleteMapping(value="/{id}")
	@ApiOperation(tags = { "Usuário" }, value = "Deleta um usuário pelo login")
	public void delete(@PathVariable String id){
		 service.deletedById(id);
	}
	
	@GetMapping(value="/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ApiOperation(tags = { "Usuário" }, value = "Busca os usuários com intervalo de tempo 10 segundos")
	public Flux<Tuple2<Long, Usuario>> getUsuarioByWebflux(){

		System.out.println("---Start get Users by WEBFLUX--- " + LocalDateTime.now());
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Usuario> usuarioFlux = service.findAll();

        return Flux.zip(interval, usuarioFlux);
        
	}

}
