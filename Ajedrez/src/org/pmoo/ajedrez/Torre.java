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
	public boolean puedeMover(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla casillaDestino) {
		if (casillaDestino.getPieza() instanceof NoPieza) {
			// Arriba
			if (pCoordenadaInicio.getFila() > pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
				for (int i = 1; i < pCoordenadaInicio.getFila()-pCoordenadaDestino.getFila(); i++) {
					if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() - i), (pCoordenadaInicio.getColumna()))))) {
						return false;
					}
				}
				return true;
			}
			// Abajo
			if (pCoordenadaInicio.getFila() < pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
				for (int i = 1; i < pCoordenadaDestino.getFila()-pCoordenadaInicio.getFila(); i++) {
					if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() + i), (pCoordenadaInicio.getColumna()))))) {
						return false;
					}
				}
				return true;
			}
			// Izquierda
			if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() < pCoordenadaDestino.getColumna()) {
				for (int i = 1; i < pCoordenadaDestino.getColumna()-pCoordenadaInicio.getColumna(); i++) {
					if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila()), (pCoordenadaInicio.getColumna() + i))))) {
						return false;
					}
				}
				return true;
			}
			// Derecha
			if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() > pCoordenadaDestino.getColumna()) {
				for (int i = 1; i < pCoordenadaInicio.getColumna()-pCoordenadaDestino.getColumna(); i++) {
					if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila()), (pCoordenadaInicio.getColumna() - i))))) {
						return false;
					}
				}
				return true;
			}

		}
		return false;
	}

	public boolean puedeComer(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA && casillaDestino.getPieza().getColor() == Color.NEGRA) {
				// Arriba
				if (pCoordenadaInicio.getFila() > pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					for (int i = 1; i < pCoordenadaInicio.getFila()-pCoordenadaDestino.getFila(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() - i), (pCoordenadaInicio.getColumna()))))) {
							return false;
						}
					}
					return true;
				}
				// Abajo
				if (pCoordenadaInicio.getFila() < pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					for (int i = 1; i < pCoordenadaDestino.getFila()-pCoordenadaInicio.getFila(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() + i), (pCoordenadaInicio.getColumna()))))) {
							return false;
						}
					}
					return true;
				}
				// Izquierda
				if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() < pCoordenadaDestino.getColumna()) {
					for (int i = 1; i < pCoordenadaDestino.getColumna()-pCoordenadaInicio.getColumna(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila()), (pCoordenadaInicio.getColumna() + i))))) {
							return false;
						}
					}
					return true;
				}
				// Derecha
				if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() > pCoordenadaDestino.getColumna()) {
					for (int i = 1; i < pCoordenadaInicio.getColumna()-pCoordenadaDestino.getColumna(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila()), (pCoordenadaInicio.getColumna() - i))))) {
							return false;
						}
					}
					return true;
				}

			}

			else if (this.color == Color.NEGRA && casillaDestino.getPieza().getColor() == Color.BLANCA) {
				// Arriba
				if (pCoordenadaInicio.getFila() > pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					for (int i = 1; i < pCoordenadaInicio.getFila()-pCoordenadaDestino.getFila(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() - i), (pCoordenadaInicio.getColumna()))))) {
							return false;
						}
					}
					return true;
				}
				// Abajo
				if (pCoordenadaInicio.getFila() < pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					for (int i = 1; i < pCoordenadaDestino.getFila()-pCoordenadaInicio.getFila(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() + i), (pCoordenadaInicio.getColumna()))))) {
							return false;
						}
					}
					return true;
				}
				// Izquierda
				if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() < pCoordenadaDestino.getColumna()) {
					for (int i = 1; i < pCoordenadaDestino.getColumna()-pCoordenadaInicio.getColumna(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila()), (pCoordenadaInicio.getColumna() + i))))) {
							return false;
						}
					}
					return true;
				}
				// Derecha
				if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() > pCoordenadaDestino.getColumna()) {
					for (int i = 1; i < pCoordenadaInicio.getColumna()-pCoordenadaDestino.getColumna(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila()), (pCoordenadaInicio.getColumna() - i))))) {
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
