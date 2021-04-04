package org.pmoo.ajedrez;

public class Jugador {
	//Atributos
	private String nombre;
	private Color color;
	
	//Constructora
	public Jugador(String pNombre, Color pColor) {
		this.nombre=pNombre;
		this.color=pColor;
	}
	
	//Metodos
	public String getNombre() {
		return this.nombre;
	}
	
	public String imprimirColor() {
		return this.color.getColor();
	}
	
	public Color getColor() {
		return this.color;
	}
}
