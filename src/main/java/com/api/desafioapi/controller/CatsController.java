package com.api.desafioapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafioapi.document.Fact;
import com.api.desafioapi.service.CatsService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CatsController {

	@Autowired
	CatsService service;

	@GetMapping("/facts/{factId}")
	@ApiOperation(tags = { "Cats" }, value = "trás um fato sobre o gato por id")
	public ResponseEntity<Fact> fact(@PathVariable String factId) {

		Optional<Fact> fact = this.service.getFact(factId);

		return fact.map(result -> new ResponseEntity<>(fact.get(), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@GetMapping("/facts")
	@ApiOperation(tags = { "Cats" }, value = "lista de curiosidades sobre gatos")
	public ResponseEntity<String> facts(String animalType) {

		Optional<String> facts = this.service.listFactCat(animalType);

		return facts.map(result -> new ResponseEntity<>(facts.get(), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/facts/random")
	@ApiOperation(tags = { "Cats" }, value = "lista uma quantidade de curiosidades sobre gatos")
	public ResponseEntity<String> factsRandom(String animalType, String amount) {

		Optional<String> facts = this.service.listFactCatRandom(animalType, amount);

		return facts.map(result -> new ResponseEntity<>(facts.get(), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@ResponseBody
	@RequestMapping(value = "/htpp-cat", method = RequestMethod.GET)
	@ApiOperation(tags = { "Cats" }, value = "imagem de gatos")
	public ResponseEntity<byte[]> httpCat(@RequestParam String http) {

		byte[] in = this.service.obterHttpImagemCat(http);

		return new ResponseEntity<>(in, HttpStatus.OK);
	}

}
