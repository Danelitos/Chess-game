package org.pmoo.ajedrez;

public class Peon extends Pieza {

	private final String PEON_NEGRO = "\u265F";
	private final String PEON_BLANCO = "\u2659";

	// Constructor
	public Peon(Color pColor) {
		super(pColor);
		if (super.color.equals(Color.NEGRA))
			piezaAImprimir = PEON_NEGRO;
		else {
			piezaAImprimir = PEON_BLANCO;
		}
	}

	// Metodos
	public boolean puedeMover(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (casillaDestino.getPieza() instanceof NoPieza) {
			if (this.color == Color.BLANCA) {
				if (filaInicio == (filaDestino + 1) && columnaInicio == columnaDestino) {
					return true;
				}
				if (filaInicio == 7 && filaInicio == (filaDestino + 2) && columnaInicio == columnaDestino) {
					return true;
				}
			} else {
				if (filaInicio == (filaDestino - 1) && columnaInicio == columnaDestino) {
					return true;
				}
				if (filaInicio == 1 && filaInicio == (filaDestino - 2) && columnaInicio == columnaDestino) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean puedeComer(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA) {
				if (((filaInicio == (filaDestino + 1) && columnaInicio == columnaDestino - 1)
						|| (filaInicio == (filaDestino - 1) && columnaInicio == columnaDestino - 1))
						&& casillaDestino.getPieza().getColor() == Color.NEGRA) {
					return true;
				}
			}

			else {
				if (((filaInicio == (filaDestino + 1) && columnaInicio == columnaDestino + 1)
						|| (filaInicio == (filaDestino - 1) && columnaInicio == columnaDestino + 1))
						&& casillaDestino.getPieza().getColor() == Color.BLANCA) {
					return true;
				}
			}
		}
		return false;
	}
}
