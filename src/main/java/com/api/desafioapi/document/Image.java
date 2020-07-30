package com.api.desafioapi.document;

/**
 * Classe que representa uma imagem de gato da api.thecatapi.com
 * @author Stefanny
 *
 */
public class Image {

	private String id;
	private String url;
	private Breed[] breeds;
	
	public Image() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Breed[] getBreeds() {
		return breeds;
	}
	public void setBreeds(Breed[] breeds) {
		this.breeds = breeds;
	}
	
}
