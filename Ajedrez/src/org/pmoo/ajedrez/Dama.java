package org.pmoo.ajedrez;

public class Dama extends Pieza {
	private final String DAMA_NEGRA="\u265B";
	private final String DAMA_BLANCA="\u2655";
	
	//Constructor
	public Dama(Color pColor) {
		super(pColor);
		if(super.color.equals(Color.NEGRA))
			piezaAImprimir=DAMA_NEGRA;
		else {
			piezaAImprimir=DAMA_BLANCA;
		}
	}
	
	//Metodos
	
}
