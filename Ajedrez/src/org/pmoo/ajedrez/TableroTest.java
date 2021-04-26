package org.pmoo.ajedrez;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableroTest {

	@Before
	public void setUp() throws Exception {
		Tablero.getMiTablero();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Este metodo es necesario para copiar el nuevo tablero a la clase singleton tablero. Se necesita por
	 * que las fichas utilizan el tablero de la clase singleton para saber si hay piezas en su camino
	 * @param pTableroNuevo
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private void copiarTablero(Casilla[][] pTableroNuevo) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<Tablero> tableroOriginal=Tablero.class;
		Field tableroACambiar=tableroOriginal.getDeclaredField("tablero");
		tableroACambiar.setAccessible(true);
		tableroACambiar.set(Tablero.getMiTablero(), pTableroNuevo);
	}
	
	private Casilla[][] nuevoTablero(){
		Casilla[][] miTablero= new Casilla[8][8];
		for (int i = 0; i < miTablero.length; i++) {
			for (int j = 0; j < miTablero[i].length; j++) {
				miTablero[i][j] = new Casilla();
				miTablero[i][j].setPieza(new NoPieza());
			}
		}
		return miTablero;
	}

	@Test
	public void testJaqueMate() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//Jaque Mate a la negras
		Casilla[][] pierdenNegras= this.nuevoTablero();
		pierdenNegras[4][2].setPieza(new Alfil(Color.BLANCA));
		pierdenNegras[3][7].setPieza(new Dama(Color.BLANCA));
		pierdenNegras[0][4].setPieza(new Rey(Color.NEGRA));
		pierdenNegras[7][7].setPieza(new Rey(Color.BLANCA));
		pierdenNegras[0][3].setPieza(new Dama(Color.NEGRA));
		pierdenNegras[0][5].setPieza(new Alfil(Color.NEGRA));
		this.copiarTablero(pierdenNegras);
		assertTrue(Tablero.getMiTablero().jaqueMate());
		//Jaque Mate a la blancas
		Casilla[][] pierdenBlancas= this.nuevoTablero();
		pierdenBlancas[4][2].setPieza(new Alfil(Color.NEGRA));
		pierdenBlancas[3][7].setPieza(new Dama(Color.NEGRA));
		pierdenBlancas[0][4].setPieza(new Rey(Color.BLANCA));
		pierdenBlancas[7][7].setPieza(new Rey(Color.NEGRA));
		pierdenBlancas[0][3].setPieza(new Dama(Color.BLANCA));
		pierdenBlancas[0][5].setPieza(new Alfil(Color.BLANCA));
		this.copiarTablero(pierdenBlancas);
		assertTrue(Tablero.getMiTablero().jaqueMate());
	}

	@Test
	public void testJaque() {
		
	}

	@Test
	public void testReyAhogado() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//Primera prueba rey ahogado blanco tres piezas
		Casilla[][] reyAhogadoBlancas= this.nuevoTablero();
		reyAhogadoBlancas[0][6].setPieza(new Rey(Color.BLANCA));
		reyAhogadoBlancas[2][5].setPieza(new Dama(Color.NEGRA));
		reyAhogadoBlancas[2][7].setPieza(new Rey(Color.NEGRA));
		this.copiarTablero(reyAhogadoBlancas);
		assertTrue(Tablero.getMiTablero().reyAhogado());
		//Segunda prueba rey ahogado blanco 5 piezas
		reyAhogadoBlancas= this.nuevoTablero();
		reyAhogadoBlancas[0][0].setPieza(new Rey(Color.BLANCA));
		reyAhogadoBlancas[3][5].setPieza(new Caballo(Color.NEGRA));
		reyAhogadoBlancas[6][7].setPieza(new Rey(Color.NEGRA));
		reyAhogadoBlancas[2][1].setPieza(new Dama(Color.NEGRA));
		reyAhogadoBlancas[1][2].setPieza(new Torre(Color.NEGRA));
		this.copiarTablero(reyAhogadoBlancas);
		assertTrue(Tablero.getMiTablero().reyAhogado());
		//Primera prueba rey ahogado negro tres piezas
		Casilla[][] reyAhogadoNegras= this.nuevoTablero();
		reyAhogadoNegras[0][6].setPieza(new Rey(Color.NEGRA));
		reyAhogadoNegras[2][5].setPieza(new Dama(Color.BLANCA));
		reyAhogadoNegras[2][7].setPieza(new Rey(Color.BLANCA));
		this.copiarTablero(reyAhogadoNegras);
		assertTrue(Tablero.getMiTablero().reyAhogado());
		//Segunda prueba rey ahogado negro 5 piezas
		reyAhogadoNegras= this.nuevoTablero();
		reyAhogadoNegras[0][0].setPieza(new Rey(Color.NEGRA));
		reyAhogadoNegras[3][5].setPieza(new Caballo(Color.BLANCA));
		reyAhogadoNegras[6][7].setPieza(new Rey(Color.BLANCA));
		reyAhogadoNegras[2][1].setPieza(new Dama(Color.BLANCA));
		reyAhogadoNegras[1][2].setPieza(new Torre(Color.BLANCA));
		this.copiarTablero(reyAhogadoNegras);
		assertTrue(Tablero.getMiTablero().reyAhogado());
		//Prueba no rey ahogado blanco tres piezas
		reyAhogadoBlancas= this.nuevoTablero();
		reyAhogadoBlancas[0][6].setPieza(new Rey(Color.BLANCA));
		reyAhogadoBlancas[2][6].setPieza(new Dama(Color.NEGRA));
		reyAhogadoBlancas[2][7].setPieza(new Rey(Color.NEGRA));
		this.copiarTablero(reyAhogadoBlancas);
		assertFalse(Tablero.getMiTablero().reyAhogado());
		//Prueba no rey ahogado negro 5 piezas
		reyAhogadoNegras= this.nuevoTablero();
		reyAhogadoNegras[0][0].setPieza(new Rey(Color.NEGRA));
		reyAhogadoNegras[3][5].setPieza(new Caballo(Color.BLANCA));
		reyAhogadoNegras[6][7].setPieza(new Rey(Color.BLANCA));
		reyAhogadoNegras[2][4].setPieza(new Dama(Color.BLANCA));
		reyAhogadoNegras[1][2].setPieza(new Torre(Color.BLANCA));
		this.copiarTablero(reyAhogadoNegras);
		assertFalse(Tablero.getMiTablero().reyAhogado());
		
	}

	@Test
	public void testCoronacion() {
		
	}

	@Test
	public void testSeleccionarPieza() {
		
	}

	@Test
	public void testImprimirTableroConNumeros() {
		
	}

	@Test
	public void testSeleccionarMovimiento() {
		
	}

	@Test
	public void testCasillaVacia() {
		
	}

}
