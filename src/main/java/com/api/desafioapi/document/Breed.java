package com.api.desafioapi.document;

/**
 * Classe que representa as raças da api.thecatapi.com
 * @author Stefanny
 *
 */
public class Breed {

	private String id;
	private String name;
	private String temperament;
	private String life_span;
	private Integer energy_level;
	private String wikipedia_url;
	private Integer intelligence;
	private String origin;
	private Integer social_needs;
	private Integer child_friendly;
	private Integer dog_friendly;

	public Breed() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public String getLife_span() {
		return life_span;
	}

	public void setLife_span(String life_span) {
		this.life_span = life_span;
	}

	public Integer getEnergy_level() {
		return energy_level;
	}

	public void setEnergy_level(Integer energy_level) {
		this.energy_level = energy_level;
	}

	public String getWikipedia_url() {
		return wikipedia_url;
	}

	public void setWikipedia_url(String wikipedia_url) {
		this.wikipedia_url = wikipedia_url;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getSocial_needs() {
		return social_needs;
	}

	public void setSocial_needs(Integer social_needs) {
		this.social_needs = social_needs;
	}

	public Integer getChild_friendly() {
		return child_friendly;
	}

	public void setChild_friendly(Integer child_friendly) {
		this.child_friendly = child_friendly;
	}

	public Integer getDog_friendly() {
		return dog_friendly;
	}

	public void setDog_friendly(Integer dog_friendly) {
		this.dog_friendly = dog_friendly;
	}

}
