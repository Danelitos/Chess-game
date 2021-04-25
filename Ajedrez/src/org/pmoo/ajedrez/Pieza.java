package org.pmoo.ajedrez;

public class Pieza {
	// Atributos
	protected Color color;
	protected String piezaAImprimir;
	private int numeroPieza;

	// Constructora
	public Pieza(Color pColor) {
		this.color = pColor;
		this.numeroPieza=-2;
	}

	// Metodos
	public void mover(Casilla pCasillaDestino) {
		pCasillaDestino.setPieza(this);
	}

	public String visualizarPieza() {
		return piezaAImprimir;
	}

	public boolean puedeMover(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla casillaDestino) {
		return false;
	}

	public Color getColor() {
		return this.color;
	}

	public int getNumeroPieza() {
		return numeroPieza;
	}

	public void setNumeroPieza(int numeroPieza) {
		this.numeroPieza = numeroPieza;
	}
	
	public void resetearNumeroPieza() {
		this.numeroPieza=-2;
	}
	
	public boolean puedeComer(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla casillaDestino) {
		return false;
	}

}
