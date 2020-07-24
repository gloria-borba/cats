//package com.api.desafioapi;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.api.desafioapi.document.Usuario;
//import com.api.desafioapi.repository.UsuarioRepository;
//
//import reactor.core.publisher.Flux;
//
//@Component
////Classe que salva os dados no banco ao iniciar
////Comenta a classe pra usar depois
//public class DummyData implements CommandLineRunner{
//	
//	private final UsuarioRepository repository;
//	
//    DummyData(UsuarioRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//    	repository.deleteAll()
//                .thenMany(
//                        Flux.just("gloria.borba", "chris.evans", 
//                                "pipico", "marilia.mendonca", "henry.cavill")
//                                .map(login -> new Usuario(login, new BCryptPasswordEncoder().encode("123")))
//                                .flatMap(repository::save))
//                .subscribe(System.out::println);
//    }
//
//}
