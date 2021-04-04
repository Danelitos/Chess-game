package org.pmoo.ajedrez;

public class Torre extends Pieza {
	
	private final String TORRE_NEGRA="\u265C";
	private final String TORRE_BLANCA="\u2656";
	
	
	//Constructor
	public Torre(Color pColor) {
		super(pColor);	
		if(super.color.equals(Color.NEGRA))
			piezaAImprimir=TORRE_NEGRA;
		else {
			piezaAImprimir=TORRE_BLANCA;
		}
	}
		
	//Metodos
}
