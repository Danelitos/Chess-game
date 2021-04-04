package org.pmoo.ajedrez;

public class Caballo extends Pieza {
	private final String CABALLO_BLANCO="\u2658";
	private final String CABALLO_NEGRO="\u265E";
	
	//Constructor
	public Caballo(Color pColor) {
		super(pColor);
		if(super.color.equals(Color.NEGRA))
			piezaAImprimir=CABALLO_NEGRO;
		else {
			piezaAImprimir=CABALLO_BLANCO;
		}
	}
		
	//Metodos
	
}
