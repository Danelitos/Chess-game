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
	public boolean puedeMover(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla pCasillaDestino) {
		if (pCasillaDestino.getPieza() instanceof NoPieza) {
			// Abajo a la derecha
			if (pCoordenadaInicio.getFila() < pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() < pCoordenadaDestino.getColumna()) {
				if((pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila())==(pCoordenadaDestino.getColumna()-pCoordenadaInicio.getColumna())) {
					for (int i = 1; i < pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() + i), (pCoordenadaInicio.getColumna() + i))))) {
							return false;
						}
					}
					return true;
				}
			}
			// Arriba a la izquierda
			if (pCoordenadaInicio.getFila() > pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() > pCoordenadaDestino.getColumna()) {
				if((pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila()) == (pCoordenadaInicio.getColumna()-pCoordenadaDestino.getColumna())) {
					for (int i = 1; i < pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() - i), (pCoordenadaInicio.getColumna() - i))))) {
							return false;
						}
					}
					return true;
				}
			}
			// Abajo a la izquierda
			if (pCoordenadaInicio.getFila() < pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() > pCoordenadaDestino.getColumna()) {
				if((pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila())==(pCoordenadaInicio.getColumna() - pCoordenadaDestino.getColumna())) {
					for (int i = 1; i < pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() + i), (pCoordenadaInicio.getColumna() - i))))) {
							return false;
						}
					}
					return true;
				}
			}
			// Arriba a la derecha
			if (pCoordenadaInicio.getFila() > pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() < pCoordenadaDestino.getColumna()) {
				if((pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila()) == (pCoordenadaDestino.getColumna()-pCoordenadaInicio.getColumna())) {
					for (int i = 1; i < pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila(); i++) {
						if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() - i), (pCoordenadaInicio.getColumna() + i))))) {
							return false;
						}
					}
					return true;
				}
				
			}

		}
		return false;
	}

	public boolean puedeComer(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA && casillaDestino.getPieza().getColor()==Color.NEGRA) {
				// Abajo a la derecha
				if (pCoordenadaInicio.getFila() < pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() < pCoordenadaDestino.getColumna()) {
					if((pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila())==(pCoordenadaDestino.getColumna()-pCoordenadaInicio.getColumna())) {
						for (int i = 1; i < pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila(); i++) {
							if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() + i), (pCoordenadaInicio.getColumna() + i))))) {
								return false;
							}
						}
						return true;
					}
				}
				// Arriba a la izquierda
				if (pCoordenadaInicio.getFila() > pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() > pCoordenadaDestino.getColumna()) {
					if((pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila()) == (pCoordenadaInicio.getColumna()-pCoordenadaDestino.getColumna())) {
						for (int i = 1; i < pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila(); i++) {
							if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() - i), (pCoordenadaInicio.getColumna() - i))))) {
								return false;
							}
						}
						return true;
					}
				}
				// Abajo a la izquierda
				if (pCoordenadaInicio.getFila() < pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() > pCoordenadaDestino.getColumna()) {
					if((pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila())==(pCoordenadaInicio.getColumna() - pCoordenadaDestino.getColumna())) {
						for (int i = 1; i < pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila(); i++) {
							if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() + i), (pCoordenadaInicio.getColumna() - i))))) {
								return false;
							}
						}
						return true;
					}
				}
				// Arriba a la derecha
				if (pCoordenadaInicio.getFila() > pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() < pCoordenadaDestino.getColumna()) {
					if((pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila()) == (pCoordenadaDestino.getColumna()-pCoordenadaInicio.getColumna())) {
						for (int i = 1; i < pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila(); i++) {
							if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() - i), (pCoordenadaInicio.getColumna() + i))))) {
								return false;
							}
						}
						return true;
					}
					
				}
			}

			else if (this.color == Color.NEGRA && casillaDestino.getPieza().getColor()==Color.BLANCA){
				// Abajo a la derecha
				if (pCoordenadaInicio.getFila() < pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() < pCoordenadaDestino.getColumna()) {
					if((pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila())==(pCoordenadaDestino.getColumna()-pCoordenadaInicio.getColumna())) {
						for (int i = 1; i < pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila(); i++) {
							if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() + i), (pCoordenadaInicio.getColumna() + i))))) {
								return false;
							}
						}
						return true;
					}
				}
				// Arriba a la izquierda
				if (pCoordenadaInicio.getFila() > pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() > pCoordenadaDestino.getColumna()) {
					if((pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila()) == (pCoordenadaInicio.getColumna()-pCoordenadaDestino.getColumna())) {
						for (int i = 1; i < pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila(); i++) {
							if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() - i), (pCoordenadaInicio.getColumna() - i))))) {
								return false;
							}
						}
						return true;
					}
				}
				// Abajo a la izquierda
				if (pCoordenadaInicio.getFila() < pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() > pCoordenadaDestino.getColumna()) {
					if((pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila())==(pCoordenadaInicio.getColumna() - pCoordenadaDestino.getColumna())) {
						for (int i = 1; i < pCoordenadaDestino.getFila() - pCoordenadaInicio.getFila(); i++) {
							if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() + i), (pCoordenadaInicio.getColumna() - i))))) {
								return false;
							}
						}
						return true;
					}
				}
				// Arriba a la derecha
				if (pCoordenadaInicio.getFila() > pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() < pCoordenadaDestino.getColumna()) {
					if((pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila()) == (pCoordenadaDestino.getColumna()-pCoordenadaInicio.getColumna())) {
						for (int i = 1; i < pCoordenadaInicio.getFila() - pCoordenadaDestino.getFila(); i++) {
							if (!(Tablero.getMiTablero().casillaVacia(new Coordenada((pCoordenadaInicio.getFila() - i), (pCoordenadaInicio.getColumna() + i))))) {
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