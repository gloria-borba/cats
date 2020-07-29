package com.api.desafioapi.document;
/**
 * Classe que representa os fatos sobre gatos
 * @author Stefanny
 *
 */
public class Fact {
	
	private String _id;
	private Long _v;
	private String text;
	private String type;

	public Fact() {
		super();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Long get_v() {
		return _v;
	}

	public void set_v(Long _v) {
		this._v = _v;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
