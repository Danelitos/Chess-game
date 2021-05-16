package org.pmoo.ajedrez;

public class Pieza {
	// Atributos
	private Color color;
	private String piezaAImprimir;
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

	public boolean puedeMover(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla pCasillaDestino) {
		return false;
	}

	public Color getColor() {
		return this.color;
	}
	public void setColor(Color pColor) {
		this.color=pColor;
	}

	public int getNumeroPieza() {
		return numeroPieza;
	}

	public void setNumeroPieza(int pNumeroPieza) {
		this.numeroPieza = pNumeroPieza;
	}
	
	public void resetearNumeroPieza() {
		this.numeroPieza=-2;
	}
	
	public boolean puedeComer(Coordenada pCoordenadaInicio, Coordenada pCoordenadaDestino,Casilla casillaDestino) {
		return false;
	}
	public void setPiezaAImprimir(String pPiezaAImprimir) {
		this.piezaAImprimir=pPiezaAImprimir;
	}

}
