package org.pmoo.ajedrez;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DamaTest {

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
	public void testPuedeMover() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//XXX Ninguna pieza que obstaculice entonces puede mover
		//Arriba izquierda
		Casilla[][] tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(0, 0), tableroTest[0][0]));
		
		//Arriba derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(2, 6), tableroTest[2][6]));
		//Abajo izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(6, 2), tableroTest[6][2]));
		//Abajo derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(6, 6), tableroTest[6][6]));
		
		//Arriba
		tableroTest= new Casilla[8][8];
		tableroTest[5][0]= new Casilla();
		tableroTest[5][0].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[5][0].getPieza().puedeMover(new Coordenada(5, 0), new Coordenada(0, 0), tableroTest[0][0]));
		
		//Abajo
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[0][0].getPieza().puedeMover(new Coordenada(0, 0), new Coordenada(5, 0), tableroTest[5][0]));
		//Derecha
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[0][0].getPieza().puedeMover(new Coordenada(0, 0), new Coordenada(0, 5), tableroTest[0][5]));
		//Izquierda
		tableroTest= new Casilla[8][8];
		tableroTest[0][5]= new Casilla();
		tableroTest[0][5].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[0][5].getPieza().puedeMover(new Coordenada(0, 5), new Coordenada(0, 0), tableroTest[0][0]));
		
		//XXX pieza que obstaculice de diferente color entonces no puede mover
		//Arriba izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[2][2].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(0, 0), tableroTest[0][0]));
		
		//Arriba derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[3][5].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(2, 6), tableroTest[2][6]));
		//Abajo izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[5][3].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(6, 2), tableroTest[6][2]));
		//Abajo derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[5][5].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(6, 6), tableroTest[6][6]));
		
		//Arriba
		tableroTest= new Casilla[8][8];
		tableroTest[5][0]= new Casilla();
		tableroTest[5][0].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[3][0].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[5][0].getPieza().puedeMover(new Coordenada(5, 0), new Coordenada(2, 0), tableroTest[2][0]));
		
		//Abajo
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[3][0].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][0].getPieza().puedeMover(new Coordenada(0, 0), new Coordenada(4, 0), tableroTest[4][0]));
		//Derecha
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][3].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][0].getPieza().puedeMover(new Coordenada(0, 0), new Coordenada(0, 4), tableroTest[0][4]));
		//Izquierda
		tableroTest= new Casilla[8][8];
		tableroTest[0][5]= new Casilla();
		tableroTest[0][5].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][3].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][5].getPieza().puedeMover(new Coordenada(0, 5), new Coordenada(0, 2), tableroTest[0][2]));
				
		//XXX pieza que obstaculice del mismo color entonces no puede mover
		//Arriba izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[2][2].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(0, 0), tableroTest[0][0]));
		
		//Arriba derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[3][5].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(2, 6), tableroTest[2][6]));
		//Abajo izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[5][3].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(6, 2), tableroTest[6][2]));
		//Abajo derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[5][5].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(6, 6), tableroTest[6][6]));
		
		//Arriba
		tableroTest= new Casilla[8][8];
		tableroTest[5][0]= new Casilla();
		tableroTest[5][0].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[3][0].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[5][0].getPieza().puedeMover(new Coordenada(5, 0), new Coordenada(2, 0), tableroTest[2][0]));
		
		//Abajo
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[3][0].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][0].getPieza().puedeMover(new Coordenada(0, 0), new Coordenada(4, 0), tableroTest[4][0]));
		//Derecha
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][3].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][0].getPieza().puedeMover(new Coordenada(0, 0), new Coordenada(0, 4), tableroTest[0][4]));
		//Izquierda
		tableroTest= new Casilla[8][8];
		tableroTest[0][5]= new Casilla();
		tableroTest[0][5].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][3].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][5].getPieza().puedeMover(new Coordenada(0, 5), new Coordenada(0, 2), tableroTest[0][2]));
				
	}

	@Test
	public void testPuedeComer() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//XXX Ninguna pieza que obstaculice entonces puede comer (Negra come a blanca)
		//Arriba izquierda
		Casilla[][] tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[0][0].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(0, 0), tableroTest[0][0]));
		
		//Arriba derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[2][6].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 6), tableroTest[2][6]));
		//Abajo izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[6][2].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 2), tableroTest[6][2]));
		//Abajo derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[6][6].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 6), tableroTest[6][6]));
		
		//Arriba
		tableroTest= new Casilla[8][8];
		tableroTest[5][0]= new Casilla();
		tableroTest[5][0].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[3][0].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[5][0].getPieza().puedeComer(new Coordenada(5, 0), new Coordenada(3, 0), tableroTest[3][0]));
		
		//Abajo
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[3][0].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(3, 0), tableroTest[3][0]));
		//Derecha
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][3].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(0, 3), tableroTest[0][3]));
		//Izquierda
		tableroTest= new Casilla[8][8];
		tableroTest[0][5]= new Casilla();
		tableroTest[0][5].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][3].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[0][5].getPieza().puedeComer(new Coordenada(0, 5), new Coordenada(0, 3), tableroTest[0][3]));
				
		//XXX Ninguna pieza que obstaculice entonces puede comer (Blanca come a negra)
		//Arriba izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[0][0].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(0, 0), tableroTest[0][0]));
		
		//Arriba derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[2][6].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 6), tableroTest[2][6]));
		//Abajo izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[6][2].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 2), tableroTest[6][2]));
		//Abajo derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[6][6].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 6), tableroTest[6][6]));
		
		//Arriba
		tableroTest= new Casilla[8][8];
		tableroTest[5][0]= new Casilla();
		tableroTest[5][0].setPieza(new Dama(Color.BLANCA));
		for (int i=4;i>=0;i--) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[3][0].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[5][0].getPieza().puedeComer(new Coordenada(5, 0), new Coordenada(3, 0), tableroTest[3][0]));
		
		//Abajo
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.BLANCA));
		for (int i=1;i<=5;i++) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[3][0].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(3, 0), tableroTest[3][0]));
		//Derecha
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.BLANCA));
		for (int i=1;i<=5;i++) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][3].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(0, 3), tableroTest[0][3]));
		//Izquierda
		tableroTest= new Casilla[8][8];
		tableroTest[0][5]= new Casilla();
		tableroTest[0][5].setPieza(new Dama(Color.BLANCA));
		for (int i=4;i>=0;i--) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][3].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertTrue(tableroTest[0][5].getPieza().puedeComer(new Coordenada(0, 5), new Coordenada(0, 3), tableroTest[0][3]));
				
		//XXX Pieza que obstaculice del mismo color entonces no puede comer (Negra come a blanca)
		//Arriba izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[3][3].setPieza(new Peon(Color.NEGRA));
		tableroTest[2][2].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(0, 0), tableroTest[0][0]));
		
		//Arriba derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[3][5].setPieza(new Peon(Color.NEGRA));
		tableroTest[2][6].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 6), tableroTest[2][6]));
		//Abajo izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[5][3].setPieza(new Peon(Color.NEGRA));
		tableroTest[6][2].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 2), tableroTest[6][2]));
		//Abajo derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.NEGRA));
		tableroTest[5][5].setPieza(new Peon(Color.NEGRA));
		tableroTest[6][6].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 6), tableroTest[6][6]));
		
		//Arriba
		tableroTest= new Casilla[8][8];
		tableroTest[5][0]= new Casilla();
		tableroTest[5][0].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[4][0].setPieza(new Peon(Color.NEGRA));
		tableroTest[3][0].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[5][0].getPieza().puedeComer(new Coordenada(5, 0), new Coordenada(3, 0), tableroTest[3][0]));
		
		//Abajo
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[2][0].setPieza(new Peon(Color.NEGRA));
		tableroTest[3][0].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(3, 0), tableroTest[3][0]));
		//Derecha
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.NEGRA));
		for (int i=1;i<=5;i++) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][2].setPieza(new Peon(Color.NEGRA));
		tableroTest[0][3].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(0, 3), tableroTest[0][3]));
		//Izquierda
		tableroTest= new Casilla[8][8];
		tableroTest[0][5]= new Casilla();
		tableroTest[0][5].setPieza(new Dama(Color.NEGRA));
		for (int i=4;i>=0;i--) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][4].setPieza(new Peon(Color.NEGRA));
		tableroTest[0][3].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][5].getPieza().puedeComer(new Coordenada(0, 5), new Coordenada(0, 3), tableroTest[0][3]));
				
		//XXX Pieza que obstaculice del mismo color entonces no puede comer (Blanca come a negra)
		//Arriba izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[2][2].setPieza(new Peon(Color.BLANCA));
		tableroTest[0][0].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(0, 0), tableroTest[0][0]));
		
		//Arriba derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[2][6].setPieza(new Peon(Color.NEGRA));
		tableroTest[3][5].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 6), tableroTest[2][6]));
		//Abajo izquierda
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[6][2].setPieza(new Peon(Color.NEGRA));
		tableroTest[5][3].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 2), tableroTest[6][2]));
		//Abajo derecha
		tableroTest= this.nuevoTablero();
		tableroTest[4][4].setPieza(new Dama(Color.BLANCA));
		tableroTest[6][6].setPieza(new Peon(Color.NEGRA));
		tableroTest[5][5].setPieza(new Peon(Color.BLANCA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 6), tableroTest[6][6]));
		
		//Arriba
		tableroTest= new Casilla[8][8];
		tableroTest[5][0]= new Casilla();
		tableroTest[5][0].setPieza(new Dama(Color.BLANCA));
		for (int i=4;i>=0;i--) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[4][0].setPieza(new Peon(Color.BLANCA));
		tableroTest[3][0].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[5][0].getPieza().puedeComer(new Coordenada(5, 0), new Coordenada(3, 0), tableroTest[3][0]));
		
		//Abajo
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.BLANCA));
		for (int i=1;i<=5;i++) {
			tableroTest[i][0]= new Casilla();
			tableroTest[i][0].setPieza(new NoPieza());
		}
		tableroTest[2][0].setPieza(new Peon(Color.BLANCA));
		tableroTest[3][0].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(3, 0), tableroTest[3][0]));
		//Derecha
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Dama(Color.BLANCA));
		for (int i=1;i<=5;i++) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][2].setPieza(new Peon(Color.BLANCA));
		tableroTest[0][3].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(0, 3), tableroTest[0][3]));
		//Izquierda
		tableroTest= new Casilla[8][8];
		tableroTest[0][5]= new Casilla();
		tableroTest[0][5].setPieza(new Dama(Color.BLANCA));
		for (int i=4;i>=0;i--) {
			tableroTest[0][i]= new Casilla();
			tableroTest[0][i].setPieza(new NoPieza());
		}
		tableroTest[0][4].setPieza(new Peon(Color.BLANCA));
		tableroTest[0][3].setPieza(new Peon(Color.NEGRA));
		this.copiarTablero(tableroTest);
		assertFalse(tableroTest[0][5].getPieza().puedeComer(new Coordenada(0, 5), new Coordenada(0, 3), tableroTest[0][3]));
	}
}
