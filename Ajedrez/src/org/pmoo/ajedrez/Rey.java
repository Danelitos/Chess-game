package org.pmoo.ajedrez;

public class Rey extends Pieza {
	private final String REY_NEGRO="\u265A";
	private final String REY_BLANCO="\u2654";
	
	//Constructor
	public Rey(Color pColor) {
		super(pColor);
		if(super.color.equals(Color.NEGRA))
			piezaAImprimir=REY_NEGRO;
		else {
			piezaAImprimir=REY_BLANCO;
		}
	}
		
	//Metodos
}
