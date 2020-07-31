package com.api.desafioapi.document;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Classe que representa um usuário 
 * @author Stefanny
 *
 */
@Document
public class Usuario {

	@Id
	private String login;
	private String nome;
	private String senha;

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
