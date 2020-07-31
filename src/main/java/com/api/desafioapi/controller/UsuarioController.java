package com.api.desafioapi.controller;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	@ApiOperation(tags = { "User" }, value = "Retorna todos os usuários")
	public ResponseEntity<Flux<Usuario>> getUsuario() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{login}")
	@ApiOperation(tags = { "User" }, value = "Retorna um usuário pelo login")
	public ResponseEntity<Mono<Usuario>> getUsuarioLogin(@PathVariable String login) {
		return new ResponseEntity<>(service.findByLogin(login), HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(tags = { "User" }, value = "Salva um usuário")
	public ResponseEntity<Mono<Usuario>> save(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(service.save(usuario), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{login}")
	@ApiOperation(tags = { "User" }, value = "Deleta um usuário pelo login")
	public ResponseEntity<Mono<Void>> delete(@PathVariable String login) {
		return new ResponseEntity<>(service.deletedByLogin(login), HttpStatus.NO_CONTENT);
	}

	@PatchMapping(value = "/{login}")
	@ApiOperation(tags = { "User" }, value = "Atualiza um usuário pelo login")
	public ResponseEntity<Mono<Usuario>> update(@PathVariable String login, @RequestBody Usuario usuario) {
		return new ResponseEntity<>(service.update(login, usuario), HttpStatus.OK);
	}

	@GetMapping(value = "/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ApiOperation(tags = { "User" }, value = "Busca os usuários com intervalo de tempo 10 segundos")
	public Flux<Tuple2<Long, Usuario>> getUsuarioByWebflux() {

		System.out.println("---Start get Users by WEBFLUX--- " + LocalDateTime.now());
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
		Flux<Usuario> usuarioFlux = service.findAll();

		return Flux.zip(interval, usuarioFlux);

	}

}
