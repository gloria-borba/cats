package com.api.desafioapi.repository;

import java.util.Optional;

import com.api.desafioapi.document.Fact;

public interface CatFactsRepository {
	
	/**
	 * Listagem das curiosidades de gatos 
	 * @param animalType
	 * @return Optional<String> 
	 */
	public Optional<String> listFactCat(String animalType);

	/**
	 * Trás uma curiosidade de gato pelo id
	 * @param factId
	 * @return Optional<Fact>
	 */
	public Optional<Fact> getFact(String factId);

	/**
	 * Listagem das curiosidades de gatos pela quantidade requerida
	 * @param animalType
	 * @param amount
	 * @return Optional<String> 
	 */
	public Optional<String> listFactCatRandom(String animalType, String amount);

}
