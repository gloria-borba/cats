package com.api.desafioapi;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.desafioapi.document.Usuario;
import com.api.desafioapi.repository.UsuarioRepository;

import reactor.core.publisher.Flux;

@Component
//Classe que salva os dados no banco ao iniciar
//Comenta a classe pra usar depois
public class DummyData implements CommandLineRunner{
	
	private final UsuarioRepository repository;
	
    DummyData(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

    	repository.deleteAll()
                .thenMany(
                        Flux.just("Glória Borba", "Chris Evans", "Kiernan shipka",
                                "Pipico", "Marília Mendonça", "Henry Cavill", "Rick Sanchez")
                                .map(nome -> new Usuario(UUID.randomUUID().toString(), nome))
                                .flatMap(repository::save))
                .subscribe(System.out::println);
    }

}
