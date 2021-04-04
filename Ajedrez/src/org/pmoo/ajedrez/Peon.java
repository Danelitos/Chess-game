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
	public boolean puedeMover(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		//FIXME esta incompleto es para probar'
		if(casillaDestino.getPieza() instanceof NoPieza){
			if (this.color==Color.BLANCA) {
				if(filaInicio==(filaDestino+1) && columnaInicio==columnaDestino) {
					return true;
				}
			}
			else {
				if(filaInicio==(filaDestino-1) && columnaInicio==columnaDestino) {
					return true;
				}
			}
		}
		return false;
	}
}
