package org.pmoo.ajedrez;

public class  Peon extends Pieza {
	
	private final String PEON_NEGRO="\u265F"; 
	private final String PEON_BLANCO="\u2659";
	
	//Constructor
	public Peon(Color pColor) {
		super(pColor);
	}
	
	//Metodos
	public String visualizarPieza() {
		if(super.color.equals(Color.NEGRA))
			return PEON_NEGRO;
		else {
			return PEON_BLANCO;
		}
	}
	
//	public boolean[][] movimientosPosibles(){
//
//	}
}
