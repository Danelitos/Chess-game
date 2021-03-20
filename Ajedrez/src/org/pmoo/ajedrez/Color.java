package org.pmoo.ajedrez;

public enum Color {
	NEGRA("negra"), BLANCA("blanca");
	
	private final String COLOR;
	
	//Constructora
	private Color(String pColor) {
		this.COLOR=pColor;
	}
	
	public String getColor() {
		return COLOR;
	}
}
