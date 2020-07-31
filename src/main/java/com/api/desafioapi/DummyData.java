//package com.api.desafioapi;
//
//import org.springframework.util.DigestUtils;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.api.desafioapi.document.Usuario;
//import com.api.desafioapi.repository.UsuarioRepository;
//
//import reactor.core.publisher.Flux;
//
///**
// * Classe utilizada para adicionar usuários no banco pela primeira vez
// * Após utilizar comentar
// * @author Stefanny
// *
// */
//@Component
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
//                                .map(login -> new Usuario(login, DigestUtils.md5DigestAsHex("123".getBytes())))
//                                .flatMap(repository::save))
//                .subscribe(System.out::println);
//    }
//
//}
