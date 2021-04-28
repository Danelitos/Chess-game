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
	public boolean puedeMover(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla pCasillaDestino) {
		if (pCasillaDestino.getPieza() instanceof NoPieza) {
			if (this.color == Color.BLANCA) {
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == 6 && pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 2) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna() &&
						Tablero.getMiTablero().casillaVacia(new Coordenada(4, pCoordenadaDestino.getColumna()))) {
					return true;
				}
			} else {
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna()) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == 1 && pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 2) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna() &&
						Tablero.getMiTablero().casillaVacia(new Coordenada(2, pCoordenadaDestino.getColumna()))) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean puedeComer(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA) {
				//comer arriba a la derecha
				if (((pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna() + 1))
						&& casillaDestino.getPieza().getColor() == Color.NEGRA) {
					return true;
				}
				//comer arriba a la izquierda
				if((pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna() - 1) && 
						(casillaDestino.getPieza().getColor() == Color.NEGRA)) {
					return true;
				}
			}

			else {
				//comer abajo a la derecha
				if ((pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna() + 1)
						&& casillaDestino.getPieza().getColor() == Color.BLANCA) {
					return true;
				}
				//comer abajo a la izquierda
				if((pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == pCoordenadaDestino.getColumna() - 1) &&
						casillaDestino.getPieza().getColor() == Color.BLANCA) {
					return true;
				}
			}
		}
		return false;
	}
}
