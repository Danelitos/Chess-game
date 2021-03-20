package org.pmoo.ajedrez;

public class Rey extends Pieza {
	private final String REY_NEGRO="\u265A";
	private final String REY_BLANCO="\u2654";
	
	//Constructor
	public Rey(Color pColor) {
		super(pColor);
	}
		
	//Metodos
	public String visualizarPieza() {
		if(super.color.equals(Color.NEGRA))
			return REY_NEGRO;
		else {
			return REY_BLANCO;
		}
	}
}
