package com.api.desafioapi.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.desafioapi.document.Fact;
import com.api.desafioapi.repository.CatFactsRepository;

@Repository
public class CatFactsRepositoryImpl implements CatFactsRepository {

	@Autowired
	RestTemplate restTemplate;

	private UriComponentsBuilder uriCatFact() {
		return UriComponentsBuilder.newInstance().scheme("https").host("cat-fact.herokuapp.com").path("facts/");
	}

	@Override
	public Optional<String> listFactCat(String animalType) {

		UriComponents uri = animalType != null ? this.uriCatFact().queryParam("animal_type", animalType).build()
				: this.uriCatFact().build();

		ResponseEntity<String> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				});

		if (response.getStatusCode() == HttpStatus.OK) {
			return Optional.ofNullable(response.getBody());
		}

		return Optional.empty();
	}

	@Override
	public Optional<Fact> getFact(String factId) {

		UriComponents uri = this.uriCatFact().path(factId).build();

		ResponseEntity<Fact> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<Fact>() {
				});

		if (response.getStatusCode() == HttpStatus.OK) {
			return Optional.ofNullable(response.getBody());
		}

		return Optional.empty();
	}

	@Override
	public Optional<String> listFactCatRandom(String animalType, String amount) {

		UriComponentsBuilder uri = this.uriCatFact().path("random/");

		if (animalType != null) {
			uri.queryParam("animal_type/", animalType);
		}

		if (amount != null) {
			uri.queryParam("amount", amount);
		}

		ResponseEntity<String> response = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				});

		if (response.getStatusCode() == HttpStatus.OK) {
			return Optional.ofNullable(response.getBody());
		}

		return Optional.empty();
	}
}
