package com.api.desafioapi.service;

import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.desafioapi.document.Fact;

@Service
public class CatsServiceImpl implements CatsService {

	@Override
	public byte[] obterHttpImagemCat(String http) {
		RestTemplate restTemplate = new RestTemplate(this.getClientHttpRequestFactory());

		byte[] in = restTemplate.getForObject(this.urlHttpCat(http) + ".jpg", byte[].class);

		return in;
	}

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 60000;
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(timeout);
		clientHttpRequestFactory.setReadTimeout(timeout);
		return clientHttpRequestFactory;
	}

	private String urlHttpCat(String http) {
		return "https://http.cat/" + http;
	}

	private UriComponentsBuilder uriCatFat() {
		return UriComponentsBuilder.newInstance().scheme("https").host("cat-fact.herokuapp.com").path("facts/");
	}

	@Override
	public Optional<String> listFactCat(String animalType) {
		RestTemplate restTemplate = new RestTemplate(this.getClientHttpRequestFactory());

		UriComponents uri = animalType != null ? this.uriCatFat().queryParam("animal_type", animalType).build()
				: this.uriCatFat().build();

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
		RestTemplate restTemplate = new RestTemplate(this.getClientHttpRequestFactory());

		UriComponents uri = this.uriCatFat().path(factId).build();

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
		RestTemplate restTemplate = new RestTemplate(this.getClientHttpRequestFactory());

		UriComponentsBuilder uri = this.uriCatFat().path("random/");

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
