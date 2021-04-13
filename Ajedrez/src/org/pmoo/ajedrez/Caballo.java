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
	public boolean puedeMover(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (casillaDestino.getPieza() instanceof NoPieza) {
			if (filaInicio == (filaDestino + 2) && columnaInicio == (columnaDestino +1)) {
				return true;
			}
			if (filaInicio == (filaDestino + 2) && columnaInicio == (columnaDestino -1)) {
				return true;
			}
			if (filaInicio == (filaDestino - 2) && columnaInicio == (columnaDestino +1)) {
				return true;
			}
			if (filaInicio == (filaDestino - 2) && columnaInicio == (columnaDestino -1)) {
				return true;
			}
			if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino +2)) {
				return true;
			}
			if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino -2)) {
				return true;
			}
			if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino +2)) {
				return true;
			}
			if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino -2)) {
				return true;
			}
			
		}
		return false;
	}

	public boolean puedeComer(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA && casillaDestino.getPieza().getColor()==Color.NEGRA) {
				if (filaInicio == (filaDestino + 2) && columnaInicio == (columnaDestino +1)) {
					return true;
				}
				if (filaInicio == (filaDestino + 2) && columnaInicio == (columnaDestino -1)) {
					return true;
				}
				if (filaInicio == (filaDestino - 2) && columnaInicio == (columnaDestino +1)) {
					return true;
				}
				if (filaInicio == (filaDestino - 2) && columnaInicio == (columnaDestino -1)) {
					return true;
				}
				if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino +2)) {
					return true;
				}
				if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino -2)) {
					return true;
				}
				if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino +2)) {
					return true;
				}
				if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino -2)) {
					return true;
				}
			}

			else if (this.color == Color.NEGRA && casillaDestino.getPieza().getColor()==Color.BLANCA){
				if (filaInicio == (filaDestino + 2) && columnaInicio == (columnaDestino +1)) {
					return true;
				}
				if (filaInicio == (filaDestino + 2) && columnaInicio == (columnaDestino -1)) {
					return true;
				}
				if (filaInicio == (filaDestino - 2) && columnaInicio == (columnaDestino +1)) {
					return true;
				}
				if (filaInicio == (filaDestino - 2) && columnaInicio == (columnaDestino -1)) {
					return true;
				}
				if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino +2)) {
					return true;
				}
				if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino -2)) {
					return true;
				}
				if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino +2)) {
					return true;
				}
				if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino -2)) {
					return true;
				}
			}
		}
		return false;
	}
}
