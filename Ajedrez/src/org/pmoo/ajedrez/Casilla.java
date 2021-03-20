package org.pmoo.ajedrez;

public class Casilla {
	//Atributos
	private Pieza piezaActual;
	
	//Constructora
	public Casilla() {
		piezaActual=new NoPieza(null);
	}
	//Metodos
	public void imprimirPieza() {
		System.out.print(piezaActual.visualizarPieza());
	}
	
	public void setPieza(Pieza pPieza) {
		this.piezaActual=pPieza;
	}
	
	public Pieza getPieza() {
		return this.piezaActual;
	}
}
