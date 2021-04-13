package org.pmoo.ajedrez;

public class Alfil extends Pieza {
	private final String ALFIL_NEGRO = "\u265D";
	private final String ALFIL_BLANCO = "\u2657";

	// Constructor
	public Alfil(Color pColor) {
		super(pColor);
		if (super.color.equals(Color.NEGRA))
			piezaAImprimir = ALFIL_NEGRO;
		else {
			piezaAImprimir = ALFIL_BLANCO;
		}
	}

	// Metodos
	public boolean puedeMover(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (casillaDestino.getPieza() instanceof NoPieza) {
			// Abajo a la derecha
			if (filaInicio < filaDestino && columnaInicio < columnaDestino) {
				if((filaDestino - filaInicio)==(columnaDestino-columnaInicio)) {
					for (int i = 1; i < filaDestino - filaInicio; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio + i), (columnaInicio + i)))) {
							return false;
						}
					}
					return true;
				}
			}
			// Arriba a la izquierda
			if (filaInicio > filaDestino && columnaInicio > columnaDestino) {
				if((filaInicio - filaDestino) == (columnaInicio-columnaDestino)) {
					for (int i = 1; i < filaInicio - filaDestino; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio - i), (columnaInicio - i)))) {
							return false;
						}
					}
					return true;
				}
			}
			// Abajo a la izquierda
			if (filaInicio < filaDestino && columnaInicio > columnaDestino) {
				if((filaDestino - filaInicio)==(columnaInicio - columnaDestino)) {
					for (int i = 1; i < filaDestino - filaInicio; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio + i), (columnaInicio - i)))) {
							return false;
						}
					}
					return true;
				}
			}
			// Arriba a la derecha
			if (filaInicio > filaDestino && columnaInicio < columnaDestino) {
				if((filaInicio - filaDestino) == (columnaDestino-columnaInicio)) {
					for (int i = 1; i < filaInicio - filaDestino; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio - i), (columnaInicio + i)))) {
							return false;
						}
					}
					return true;
				}
				
			}

		}
		return false;
	}

	public boolean puedeComer(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA && casillaDestino.getPieza().getColor()==Color.NEGRA) {
				// Abajo a la derecha
				if (filaInicio < filaDestino && columnaInicio < columnaDestino) {
					if((filaDestino - filaInicio)==(columnaDestino-columnaInicio)) {
						for (int i = 1; i < filaDestino - filaInicio; i++) {
							if (!(Tablero.getMiTablero().casillaVacia((filaInicio + i), (columnaInicio + i)))) {
								return false;
							}
						}
						return true;
					}
				}
				// Arriba a la izquierda
				if (filaInicio > filaDestino && columnaInicio > columnaDestino) {
					if((filaInicio - filaDestino) == (columnaInicio-columnaDestino)) {
						for (int i = 1; i < filaInicio - filaDestino; i++) {
							if (!(Tablero.getMiTablero().casillaVacia((filaInicio - i), (columnaInicio - i)))) {
								return false;
							}
						}
						return true;
					}
				}
				// Abajo a la izquierda
				if (filaInicio < filaDestino && columnaInicio > columnaDestino) {
					if((filaDestino - filaInicio)==(columnaInicio - columnaDestino)) {
						for (int i = 1; i < filaDestino - filaInicio; i++) {
							if (!(Tablero.getMiTablero().casillaVacia((filaInicio + i), (columnaInicio - i)))) {
								return false;
							}
						}
						return true;
					}
				}
				// Arriba a la derecha
				if (filaInicio > filaDestino && columnaInicio < columnaDestino) {
					if((filaInicio - filaDestino) == (columnaDestino-columnaInicio)) {
						for (int i = 1; i < filaInicio - filaDestino; i++) {
							if (!(Tablero.getMiTablero().casillaVacia((filaInicio - i), (columnaInicio + i)))) {
								return false;
							}
						}
						return true;
					}
					
				}
			}

			else if (this.color == Color.NEGRA && casillaDestino.getPieza().getColor()==Color.BLANCA){
				// Abajo a la derecha
				if (filaInicio < filaDestino && columnaInicio < columnaDestino) {
					if((filaDestino - filaInicio)==(columnaDestino-columnaInicio)) {
						for (int i = 1; i < filaDestino - filaInicio; i++) {
							if (!(Tablero.getMiTablero().casillaVacia((filaInicio + i), (columnaInicio + i)))) {
								return false;
							}
						}
						return true;
					}
				}
				// Arriba a la izquierda
				if (filaInicio > filaDestino && columnaInicio > columnaDestino) {
					if((filaInicio - filaDestino) == (columnaInicio-columnaDestino)) {
						for (int i = 1; i < filaInicio - filaDestino; i++) {
							if (!(Tablero.getMiTablero().casillaVacia((filaInicio - i), (columnaInicio - i)))) {
								return false;
							}
						}
						return true;
					}
				}
				// Abajo a la izquierda
				if (filaInicio < filaDestino && columnaInicio > columnaDestino) {
					if((filaDestino - filaInicio)==(columnaInicio - columnaDestino)) {
						for (int i = 1; i < filaDestino - filaInicio; i++) {
							if (!(Tablero.getMiTablero().casillaVacia((filaInicio + i), (columnaInicio - i)))) {
								return false;
							}
						}
						return true;
					}
				}
				// Arriba a la derecha
				if (filaInicio > filaDestino && columnaInicio < columnaDestino) {
					if((filaInicio - filaDestino) == (columnaDestino-columnaInicio)) {
						for (int i = 1; i < filaInicio - filaDestino; i++) {
							if (!(Tablero.getMiTablero().casillaVacia((filaInicio - i), (columnaInicio + i)))) {
								return false;
							}
						}
						return true;
					}
					
				}

			}
		}
		return false;
	}
}