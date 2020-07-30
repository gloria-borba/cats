package com.api.desafioapi.repository;

import java.util.Optional;

import com.api.desafioapi.document.Breed;
import com.api.desafioapi.document.Image;

public interface CatApiRepository {

	/**
	 * lista as raças de gatos
	 * 
	 * @param apiKey
	 * @param attachBreed
	 * @param limit
	 * @return Optional<Breed[]>
	 */
	public Optional<Breed[]> listBreedCat(String apiKey, String attachBreed, String limit);

	/**
	 * Trás uma raça de gato
	 * 
	 * @param apiKey
	 * @param name
	 * @return Optional<Breed[]>
	 */
	public Optional<Breed[]> getBreedCat(String apiKey, String name);

	/**
	 * Trás uma imagem aleatória ou por raça de gato
	 * 
	 * @param apiKey
	 * @param breed
	 * @return Optional<Image[]>
	 */
	public Optional<Image[]> getImage(String apiKey, String breed);

}
