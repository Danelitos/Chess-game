package org.pmoo.ajedrez;

public class Pieza {
	//Atributos 
	protected Color color;
	
	//Constructora
	public Pieza(Color pColor) {
		this.color=pColor;
	}
	
	//Metodos 
	public void mover() {
		
	}
	
	public String visualizarPieza() {
		return new String();
	}
	
	public boolean puedeMover(String pPosicion) {
		return false;
	}
}
