package org.pmoo.ajedrez;

public class Torre extends Pieza {

	private final String TORRE_NEGRA = "\u265C";
	private final String TORRE_BLANCA = "\u2656";

	// Constructor
	public Torre(Color pColor) {
		super(pColor);
		if (super.color.equals(Color.NEGRA))
			piezaAImprimir = TORRE_NEGRA;
		else {
			piezaAImprimir = TORRE_BLANCA;
		}
	}

	// Metodos
	public boolean puedeMover(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (casillaDestino.getPieza() instanceof NoPieza) {
			// Arriba
			if (filaInicio > filaDestino && columnaInicio == columnaDestino) {
				for (int i = 1; i < filaInicio-filaDestino; i++) {
					if (!(Tablero.getMiTablero().casillaVacia((filaInicio - i), (columnaInicio)))) {
						return false;
					}
				}
				return true;
			}
			// Abajo
			if (filaInicio < filaDestino && columnaInicio == columnaDestino) {
				for (int i = 1; i < filaDestino-filaInicio; i++) {
					if (!(Tablero.getMiTablero().casillaVacia((filaInicio + i), (columnaInicio)))) {
						return false;
					}
				}
				return true;
			}
			// Izquierda
			if (filaInicio == filaDestino && columnaInicio < columnaDestino) {
				for (int i = 1; i < columnaDestino-columnaInicio; i++) {
					if (!(Tablero.getMiTablero().casillaVacia((filaInicio), (columnaInicio + i)))) {
						return false;
					}
				}
				return true;
			}
			// Derecha
			if (filaInicio == filaDestino && columnaInicio > columnaDestino) {
				for (int i = 1; i < columnaInicio-columnaDestino; i++) {
					if (!(Tablero.getMiTablero().casillaVacia((filaInicio), (columnaInicio - i)))) {
						return false;
					}
				}
				return true;
			}

		}
		return false;
	}

	public boolean puedeComer(int filaInicio, int columnaInicio, int filaDestino, int columnaDestino,
			Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA && casillaDestino.getPieza().getColor() == Color.NEGRA) {
				// Arriba
				if (filaInicio > filaDestino && columnaInicio == columnaDestino) {
					for (int i = 1; i < filaInicio-filaDestino; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio - i), (columnaInicio)))) {
							return false;
						}
					}
					return true;
				}
				// Abajo
				if (filaInicio < filaDestino && columnaInicio == columnaDestino) {
					for (int i = 1; i < filaDestino-filaInicio; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio + i), (columnaInicio)))) {
							return false;
						}
					}
					return true;
				}
				// Izquierda
				if (filaInicio == filaDestino && columnaInicio < columnaDestino) {
					for (int i = 1; i < columnaDestino-columnaInicio; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio), (columnaInicio + i)))) {
							return false;
						}
					}
					return true;
				}
				// Derecha
				if (filaInicio == filaDestino && columnaInicio > columnaDestino) {
					for (int i = 1; i < columnaInicio-columnaDestino; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio), (columnaInicio - i)))) {
							return false;
						}
					}
					return true;
				}

			}

			else if (this.color == Color.NEGRA && casillaDestino.getPieza().getColor() == Color.BLANCA) {
				// Arriba
				if (filaInicio > filaDestino && columnaInicio == columnaDestino) {
					for (int i = 1; i < filaInicio-filaDestino; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio - i), (columnaInicio)))) {
							return false;
						}
					}
					return true;
				}
				// Abajo
				if (filaInicio < filaDestino && columnaInicio == columnaDestino) {
					for (int i = 1; i < filaDestino-filaInicio; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio + i), (columnaInicio)))) {
							return false;
						}
					}
					return true;
				}
				// Izquierda
				if (filaInicio == filaDestino && columnaInicio < columnaDestino) {
					for (int i = 1; i < columnaDestino-columnaInicio; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio), (columnaInicio + i)))) {
							return false;
						}
					}
					return true;
				}
				// Derecha
				if (filaInicio == filaDestino && columnaInicio > columnaDestino) {
					for (int i = 1; i < columnaInicio-columnaDestino; i++) {
						if (!(Tablero.getMiTablero().casillaVacia((filaInicio), (columnaInicio - i)))) {
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
}
