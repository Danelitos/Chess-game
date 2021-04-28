package org.pmoo.ajedrez;

public class Dama extends Pieza {
	private final String DAMA_NEGRA="\u265B";
	private final String DAMA_BLANCA="\u2655";
	
	//Constructor
	public Dama(Color pColor) {
		super(pColor);
		if(super.color.equals(Color.NEGRA))
			piezaAImprimir=DAMA_NEGRA;
		else {
			piezaAImprimir=DAMA_BLANCA;
		}
	}
	
	//Metodos
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
