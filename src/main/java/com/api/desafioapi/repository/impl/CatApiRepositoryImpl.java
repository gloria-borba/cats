package com.api.desafioapi.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.desafioapi.document.Breed;
import com.api.desafioapi.document.Image;
import com.api.desafioapi.repository.CatApiRepository;

@Repository
public class CatApiRepositoryImpl implements CatApiRepository {

	@Autowired
	RestTemplate restTemplate;

	private UriComponentsBuilder uriCat() {
		return UriComponentsBuilder.newInstance().scheme("https").host("api.thecatapi.com").path("v1/");
	}

	@Override
	public Optional<Breed[]> listBreedCat(String apiKey, String attachBreed, String limit) {
		UriComponentsBuilder uri = this.uriCat().path("breeds/");

		if (attachBreed != null) {
			uri.queryParam("attach_breed", attachBreed);
		}

		if (limit != null) {
			uri.queryParam("limit", limit);
		}

		return getResponseBreed(apiKey, uri);
	}

	@Override
	public Optional<Breed[]> getBreedCat(String apiKey, String name) {
		UriComponentsBuilder uri = this.uriCat().path("breeds/").path("search/").queryParam("q", name);

		return getResponseBreed(apiKey, uri);
	}

	private Optional<Breed[]> getResponseBreed(String apiKey, UriComponentsBuilder uri) {
		HttpHeaders header = new HttpHeaders();
		header.set("x-api-key", apiKey);

		Breed breed = new Breed();
		HttpEntity<Breed> entityReq = new HttpEntity<Breed>(breed, header);

		ResponseEntity<Breed[]> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entityReq,
				new ParameterizedTypeReference<Breed[]>() {
				});

		if (response.getStatusCode() == HttpStatus.OK) {
			return Optional.ofNullable(response.getBody());
		}

		return Optional.empty();
	}

	@Override
	public Optional<Image[]> getImage(String apiKey, String breed) {
		UriComponentsBuilder uri = this.uriCat().path("images/").path("search/");

		if (breed != null) {
			uri.queryParam("breed_id", breed);
		}

		HttpHeaders header = new HttpHeaders();
		header.set("x-api-key", apiKey);

		Image image = new Image();
		HttpEntity<Image> entityReq = new HttpEntity<Image>(image, header);

		ResponseEntity<Image[]> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, entityReq,
				new ParameterizedTypeReference<Image[]>() {
				});

		if (response.getStatusCode() == HttpStatus.OK) {
			return Optional.ofNullable(response.getBody());
		}

		return Optional.empty();
	}

}
