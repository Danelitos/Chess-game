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
	public boolean puedeMover(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla pCasillaDestino) {
		if (pCasillaDestino.getPieza() instanceof NoPieza) {
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() -1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() + 1)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() - 1)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() + 1)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() - 1)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() + 1)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() - 1)) {
				return true;
			}

		}
		return false;

	}

	public boolean puedeComer(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA && casillaDestino.getPieza().getColor()==Color.NEGRA) {
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + -1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() + 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() - 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() + 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() - 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() + 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() - 1)) {
					return true;
				}
			}

			else if (this.color == Color.NEGRA && casillaDestino.getPieza().getColor()==Color.BLANCA){
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + -1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() + 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == pCoordenadaDestino.getFila() && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() - 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() + 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() - 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() + 1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() - 1)) {
					return true;
				}
			}
		}
		return false;
	}
}
