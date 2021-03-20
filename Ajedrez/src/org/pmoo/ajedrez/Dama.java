package org.pmoo.ajedrez;

public class Dama extends Pieza {
	private final String DAMA_NEGRA="\u265B";
	private final String DAMA_BLANCA="\u2655";
	
	//Constructor
	public Dama(Color pColor) {
		super(pColor);
	}
	
	//Metodos
	public String visualizarPieza() {
		if(super.color.equals(Color.NEGRA))
			return DAMA_NEGRA;
		else {
			return DAMA_BLANCA;
		}
	}
	
}
