package org.pmoo.ajedrez;

public class  Peon extends Pieza {
	
	private final String PEON_NEGRO="\u265F"; 
	private final String PEON_BLANCO="\u2659";
	
	//Constructor
	public Peon(Color pColor) {
		super(pColor);
		if(super.color.equals(Color.NEGRA))
			piezaAImprimir=PEON_NEGRO;
		else {
			piezaAImprimir=PEON_BLANCO;
		}
	}
	
	//Metodos
	
}
