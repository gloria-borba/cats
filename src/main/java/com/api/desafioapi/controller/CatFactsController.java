package com.api.desafioapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafioapi.document.Fact;
import com.api.desafioapi.service.CatFactsService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/facts")
public class CatFactsController {

	@Autowired
	CatFactsService service;

	@GetMapping("/{factId}")
	@ApiOperation(tags = { "Cats Fact" }, value = "Trás um fato sobre o gato por id")
	public ResponseEntity<Fact> fact(@PathVariable String factId) {

		Optional<Fact> fact = this.service.getFact(factId);

		return fact.map(result -> new ResponseEntity<>(fact.get(), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@GetMapping()
	@ApiOperation(tags = { "Cats Fact" }, value = "Lista de curiosidades sobre gatos")
	public ResponseEntity<String> facts(String animalType) {

		Optional<String> facts = this.service.listFactCat(animalType);

		return facts.map(result -> new ResponseEntity<>(facts.get(), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/random")
	@ApiOperation(tags = { "Cats Fact" }, value = "Lista uma quantidade de curiosidades sobre gatos")
	public ResponseEntity<String> factsRandom(String animalType, String amount) {

		Optional<String> facts = this.service.listFactCatRandom(animalType, amount);

		return facts.map(result -> new ResponseEntity<>(facts.get(), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
