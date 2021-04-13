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
				if (filaInicio == 6 && filaInicio == (filaDestino + 2) && columnaInicio == columnaDestino &&
						Tablero.getMiTablero().casillaVacia(5, columnaDestino)) {
					return true;
				}
			} else {
				if (filaInicio == (filaDestino - 1) && columnaInicio == columnaDestino) {
					return true;
				}
				if (filaInicio == 1 && filaInicio == (filaDestino - 2) && columnaInicio == columnaDestino &&
						Tablero.getMiTablero().casillaVacia(2, columnaDestino)) {
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
				//comer arriba a la derecha
				if (((filaInicio == (filaDestino + 1) && columnaInicio == columnaDestino + 1))
						&& casillaDestino.getPieza().getColor() == Color.NEGRA) {
					return true;
				}
				//comer arriba a la izquierda
				if((filaInicio == (filaDestino + 1) && columnaInicio == columnaDestino - 1) && 
						(casillaDestino.getPieza().getColor() == Color.NEGRA)) {
					return true;
				}
			}

			else {
				//comer abajo a la derecha
				if ((filaInicio == (filaDestino - 1) && columnaInicio == columnaDestino + 1)
						&& casillaDestino.getPieza().getColor() == Color.BLANCA) {
					return true;
				}
				//comer abajo a la izquierda
				if((filaInicio == (filaDestino - 1) && columnaInicio == columnaDestino - 1) &&
						casillaDestino.getPieza().getColor() == Color.BLANCA) {
					return true;
				}
			}
		}
		return false;
	}
}
