package com.api.desafioapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.desafioapi.document.Fact;
import com.api.desafioapi.repository.CatFactsRepository;
import com.api.desafioapi.service.CatFactsService;

@Service
public class CatFactsServiceImpl implements CatFactsService {

	@Autowired
	CatFactsRepository repository;

	@Override
	public Optional<String> listFactCat(String animalType) {
		return repository.listFactCat(animalType);
	}

	@Override
	public Optional<Fact> getFact(String factId) {

		return repository.getFact(factId);

	}

	@Override
	public Optional<String> listFactCatRandom(String animalType, String amount) {

		return repository.listFactCatRandom(animalType, amount);
	}
}
