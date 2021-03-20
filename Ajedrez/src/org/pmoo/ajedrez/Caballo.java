package org.pmoo.ajedrez;

public class Caballo extends Pieza {
	private final String CABALLO_BLANCO="\u2658";
	private final String CABALLO_NEGRO="\u265E";
	
	//Constructor
	public Caballo(Color pColor) {
		super(pColor);
	}
		
	//Metodos
	public String visualizarPieza() {
		if(super.color.equals(Color.NEGRA))
			return CABALLO_NEGRO;
		else {
			return CABALLO_BLANCO;
		}
	}
}
