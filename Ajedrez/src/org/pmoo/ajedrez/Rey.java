package org.pmoo.ajedrez;

public class Rey extends Pieza {
	private final String REY_NEGRO = "\u265A";
	private final String REY_BLANCO = "\u2654";
	
	// Constructor
	public Rey(Color pColor) {
		super(pColor);
		if (pColor.equals(Color.NEGRA))
			this.setPiezaAImprimir(REY_NEGRO);
		else {
			this.setPiezaAImprimir(REY_BLANCO);
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
			if (this.getColor() == Color.BLANCA && casillaDestino.getPieza().getColor()==Color.NEGRA) {
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

			else if (this.getColor() == Color.NEGRA && casillaDestino.getPieza().getColor()==Color.BLANCA){
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
