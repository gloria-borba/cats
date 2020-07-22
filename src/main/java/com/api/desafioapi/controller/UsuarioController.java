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
import org.springframework.web.bind.annotation.RestController;

import com.api.desafioapi.document.Usuario;
import com.api.desafioapi.service.UsuarioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@GetMapping(value="/usuarios")
	public Flux<Usuario> getPlaylist(){
		return service.findAll();
	}
	
	@GetMapping(value="/usuario/{id}")
	public Mono<Usuario> getPlaylistId(@PathVariable String id){
		return service.findById(id);
	}
	
	@PostMapping(value="/usuario")
	public Mono<Usuario> save(@RequestBody Usuario playlist){
		return service.save(playlist);
	}
	
	@DeleteMapping(value="/usuario/{id}")
	public void delete(@PathVariable String id){
		 service.deletedById(id);
	}
	
	@GetMapping(value="/usuario/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Usuario>> getPlaylistByWebflux(){

		System.out.println("---Start get Users by WEBFLUX--- " + LocalDateTime.now());
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Usuario> playlistFlux = service.findAll();

        return Flux.zip(interval, playlistFlux);
        
	}

}
