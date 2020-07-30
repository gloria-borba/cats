package com.api.desafioapi.service;

import java.util.Optional;

import com.api.desafioapi.document.Fact;

public interface CatFactsService {
			
	/**
	 * Listagem dos fatores de gatos 
	 * @param animalType
	 * @return Optional<String> 
	 */
	public Optional<String> listFactCat(String animalType);

	/**
	 * Trás um fator de gato pelo id
	 * @param factId
	 * @return Optional<Fact>
	 */
	public Optional<Fact> getFact(String factId);

	/**
	 * Listagem dos fatores de gatos pela quantidade requerida
	 * @param animalType
	 * @param amount
	 * @return Optional<String> 
	 */
	public Optional<String> listFactCatRandom(String animalType, String amount);

}
