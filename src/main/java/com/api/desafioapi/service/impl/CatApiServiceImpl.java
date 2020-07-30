package com.api.desafioapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.desafioapi.document.Breed;
import com.api.desafioapi.document.Image;
import com.api.desafioapi.repository.CatApiRepository;
import com.api.desafioapi.service.CatApiService;

@Service
public class CatApiServiceImpl implements CatApiService {

	@Autowired
	CatApiRepository repository;

	@Override
	public Optional<Breed[]> listBreedCat(String apiKey, String attachBreed, String limit) {
		return repository.listBreedCat(apiKey, attachBreed, limit);
	}

	@Override
	public Optional<Breed[]> getBreedCat(String apiKey, String name) {
		return repository.getBreedCat(apiKey, name);
	}

	@Override
	public Optional<Image[]> getImage(String apiKey, String breed) {
		return repository.getImage(apiKey, breed);
	}

}
