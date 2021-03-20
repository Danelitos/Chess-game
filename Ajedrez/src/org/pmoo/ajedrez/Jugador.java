package org.pmoo.ajedrez;

public class Jugador {
	//Atributos
	private String nombre;
	private Color color;
	private boolean turno;
	
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
	
	public boolean getTurno() {
		return this.turno;
	}
}
