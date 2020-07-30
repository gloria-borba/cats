package com.api.desafioapi.service;

import java.util.Optional;

import com.api.desafioapi.document.Breed;
import com.api.desafioapi.document.Image;

public interface CatApiService {

	public Optional<Breed[]> listBreedCat( String apiKey, String attachBreed, String limit);

	public Optional<Breed[]> getBreedCat(String apiKey, String name);
	
	public Optional<Image[]> getImage(String apiKey, String breed);

}
