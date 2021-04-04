package org.pmoo.ajedrez;

public class Alfil extends Pieza {
	private final String ALFIL_NEGRO="\u265D";
	private final String ALFIL_BLANCO="\u2657";

	//Constructor
	public Alfil(Color pColor) {
		super(pColor);
		if(super.color.equals(Color.NEGRA))
			piezaAImprimir=ALFIL_NEGRO;
		else {
			piezaAImprimir=ALFIL_BLANCO;
		}
	}
		
	//Metodos
}
