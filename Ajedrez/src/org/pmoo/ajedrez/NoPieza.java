package org.pmoo.ajedrez;

public class NoPieza extends Pieza {
	//Atributos
	private final String NO_PIEZA=" ";
	
	//Constructor
	public NoPieza(Color pColor) {
		super(pColor);
	}
	
	//Metodos
	public String visualizarPieza() {
		return NO_PIEZA;
	}
}
