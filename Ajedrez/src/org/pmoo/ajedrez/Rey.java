package org.pmoo.ajedrez;

public class Rey extends Pieza {
	private final String REY_NEGRO = "\u265A";
	private final String REY_BLANCO = "\u2654";

	// Constructor
	public Rey(Color pColor) {
		super(pColor);
		if (super.color.equals(Color.NEGRA))
			piezaAImprimir = REY_NEGRO;
		else {
			piezaAImprimir = REY_BLANCO;
		}
	}

	// Metodos
	public boolean puedeMover(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (casillaDestino.getPieza() instanceof NoPieza) {
			if (filaInicio == (filaDestino + 1) && columnaInicio == columnaDestino) {
				return true;
			}
			if (filaInicio == (filaDestino + -1) && columnaInicio == columnaDestino) {
				return true;
			}
			if (filaInicio == filaDestino && columnaInicio == (columnaDestino + 1)) {
				return true;
			}
			if (filaInicio == filaDestino && columnaInicio == (columnaDestino - 1)) {
				return true;
			}
			if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino + 1)) {
				return true;
			}
			if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino - 1)) {
				return true;
			}
			if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino + 1)) {
				return true;
			}
			if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino - 1)) {
				return true;
			}

		}
		return false;

	}

	public boolean puedeComer(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA && casillaDestino.getPieza().getColor()==Color.NEGRA) {
				if (filaInicio == (filaDestino + 1) && columnaInicio == columnaDestino) {
					return true;
				}
				if (filaInicio == (filaDestino + -1) && columnaInicio == columnaDestino) {
					return true;
				}
				if (filaInicio == filaDestino && columnaInicio == (columnaDestino + 1)) {
					return true;
				}
				if (filaInicio == filaDestino && columnaInicio == (columnaDestino - 1)) {
					return true;
				}
				if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino + 1)) {
					return true;
				}
				if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino - 1)) {
					return true;
				}
				if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino + 1)) {
					return true;
				}
				if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino - 1)) {
					return true;
				}
			}

			else if (this.color == Color.NEGRA && casillaDestino.getPieza().getColor()==Color.BLANCA){
				if (filaInicio == (filaDestino + 1) && columnaInicio == columnaDestino) {
					return true;
				}
				if (filaInicio == (filaDestino + -1) && columnaInicio == columnaDestino) {
					return true;
				}
				if (filaInicio == filaDestino && columnaInicio == (columnaDestino + 1)) {
					return true;
				}
				if (filaInicio == filaDestino && columnaInicio == (columnaDestino - 1)) {
					return true;
				}
				if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino + 1)) {
					return true;
				}
				if (filaInicio == (filaDestino + 1) && columnaInicio == (columnaDestino - 1)) {
					return true;
				}
				if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino + 1)) {
					return true;
				}
				if (filaInicio == (filaDestino - 1) && columnaInicio == (columnaDestino - 1)) {
					return true;
				}
			}
		}
		return false;
	}
}
