package br.com.whs.javaknowledge.commons.model;

public enum Genre {

	M ("M"),
	F ("F");

	private final String value;
	
	private Genre(final String value) {
		this.value = value;
	}
	
	private String getValue() {
		return value;
	}
}
