package com.api.desafioapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.desafioapi.document.Breed;
import com.api.desafioapi.document.Image;
import com.api.desafioapi.service.CatApiService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CatApiController {
	
	@Autowired
	CatApiService service;
	
	@GetMapping("/breeds/search")
	@ApiOperation(tags = { "Cats" }, value = "Trás uma raça de gato pelo nome")
	public ResponseEntity<Breed[]> getBreedByName(@RequestHeader(value="x-api-key") String apiKey, @RequestParam String name) {

		Optional<Breed[]> breed = this.service.getBreedCat(apiKey, name);

		return breed.map(result -> new ResponseEntity<>(breed.get(), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}
	
	@GetMapping("/breeds")
	@ApiOperation(tags = { "Cats" }, value = "Lista as raças de gatos")
	public ResponseEntity<Breed[]> listBreed(@RequestHeader(value="x-api-key") String apiKey, String attachBreed, String limit) {

		Optional<Breed[]> breed = this.service.listBreedCat(apiKey, attachBreed, limit);

		return breed.map(result -> new ResponseEntity<>(breed.get(), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}
	
	@GetMapping("/images/search")
	@ApiOperation(tags = { "Cats" }, value = "Trás a url de uma imagem de gato aleatória ou por raça")
	public ResponseEntity<Image[]> getImages(@RequestHeader(value="x-api-key") String apiKey, String breed) {

		Optional<Image[]> image = this.service.getImage(apiKey, breed);

		return image.map(result -> new ResponseEntity<>(image.get(), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

}
