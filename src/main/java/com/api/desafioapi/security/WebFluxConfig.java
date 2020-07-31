package com.api.desafioapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebFluxConfig {

//	@Autowired
//	  private UsuarioRepository repository;

//	@Autowired(required = false)
//	private PasswordEncoder passwordEncoder;

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange().anyExchange().authenticated().and().httpBasic().and().formLogin();
		return http.build();
	}

//	@Bean
	// public MapReactiveUserDetailsService userDetailsService() {
//		UserDetails user = User.withUsername("gloria").password(passwordEncoder.encode("123")).roles("USER").build();
//		return new MapReactiveUserDetailsService(user);
//	}

	@Bean
	@SuppressWarnings("deprecation")
	public MapReactiveUserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();
		return new MapReactiveUserDetailsService(user);
	}

// @Bean
//  public ReactiveUserDetailsService  userDetailsService() {
//    return (username) -> userRepository.findByUsername(username);
//  }
}
