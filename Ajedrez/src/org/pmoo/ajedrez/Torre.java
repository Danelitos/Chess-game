package org.pmoo.ajedrez;

public class Torre extends Pieza {
	
	private final String TORRE_NEGRA="\u265C";
	private final String TORRE_BLANCA="\u2656";
	
	
	//Constructor
	public Torre(Color pColor) {
		super(pColor);	
	}
		
	//Metodos
	public String visualizarPieza() {
		if(super.color.equals(Color.NEGRA))
			return TORRE_NEGRA;
		else {
			return TORRE_BLANCA;
		}
	}
	
}
