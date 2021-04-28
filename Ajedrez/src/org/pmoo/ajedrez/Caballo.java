package org.pmoo.ajedrez;

public class Caballo extends Pieza {
	private final String CABALLO_BLANCO="\u2658";
	private final String CABALLO_NEGRO="\u265E";
	
	//Constructor
	public Caballo(Color pColor) {
		super(pColor);
		if(super.color.equals(Color.NEGRA))
			piezaAImprimir=CABALLO_NEGRO;
		else {
			piezaAImprimir=CABALLO_BLANCO;
		}
	}
		
	//Metodos
	public boolean puedeMover(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla pCasillaDestino) {
		if (pCasillaDestino.getPieza() instanceof NoPieza) {
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +1)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -1)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +1)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -1)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +2)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -2)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +2)) {
				return true;
			}
			if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -2)) {
				return true;
			}
			
		}
		return false;
	}

	public boolean puedeComer(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla casillaDestino) {
		if (!(casillaDestino.getPieza() instanceof NoPieza)) {
			if (this.color == Color.BLANCA && casillaDestino.getPieza().getColor()==Color.NEGRA) {
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +2)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -2)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +2)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -2)) {
					return true;
				}
			}

			else if (this.color == Color.NEGRA && casillaDestino.getPieza().getColor()==Color.BLANCA){
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 2) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -1)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +2)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() + 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -2)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() +2)) {
					return true;
				}
				if (pCoordenadaInicio.getFila() == (pCoordenadaDestino.getFila() - 1) && pCoordenadaInicio.getColumna() == (pCoordenadaDestino.getColumna() -2)) {
					return true;
				}
			}
		}
		return false;
	}
}
