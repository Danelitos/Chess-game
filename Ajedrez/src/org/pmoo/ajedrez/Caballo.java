package org.pmoo.ajedrez;

public class Caballo extends Pieza {
	private final String CABALLO_BLANCO="\u2658";
	private final String CABALLO_NEGRO="\u265E";
	
	//Constructor
	public Caballo(Color pColor) {
		super(pColor);
		if(pColor.equals(Color.NEGRA))
			this.setPiezaAImprimir(CABALLO_NEGRO);
		else {
			this.setPiezaAImprimir(CABALLO_BLANCO);
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
			if (this.getColor() == Color.BLANCA && casillaDestino.getPieza().getColor()==Color.NEGRA) {
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

			else if (this.getColor() == Color.NEGRA && casillaDestino.getPieza().getColor()==Color.BLANCA){
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
