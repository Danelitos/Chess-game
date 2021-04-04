package org.pmoo.ajedrez;

public class Pieza {
	//Atributos 
	protected Color color;
	protected String piezaAImprimir;
	
	//Constructora
	public Pieza(Color pColor) {
		this.color=pColor;
	}
	
	//Metodos 
	public void mover(Casilla pCasillaDestino) {
		
	}
	
	public String visualizarPieza() {
		return piezaAImprimir;
	}
	
	public boolean puedeMover(int filaInicio, int columnaInicio, int columnaDestino, int filaDestino, Casilla casillaDestino) {
		return false;
	}
	
	public Color getColor() {
		return this.color;
	}
}
