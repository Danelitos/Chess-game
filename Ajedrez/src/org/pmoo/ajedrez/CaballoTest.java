package org.pmoo.ajedrez;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CaballoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPuedeMover() {
		//Arriba izquierda
		Casilla[][] tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(2, 3), tableroTest[2][3]));
		//Arriba derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[2][5] = new Casilla();
		tableroTest[2][5].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(2, 5), tableroTest[2][5]));
		//Izquierda arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(3, 2), tableroTest[3][2]));
		//Izquierda abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[5][2] = new Casilla();
		tableroTest[5][2].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(5, 2), tableroTest[5][2]));
		//Derecha arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[3][6] = new Casilla();
		tableroTest[3][6].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(3, 6), tableroTest[3][6]));
		//Derecha abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[5][6] = new Casilla();
		tableroTest[5][6].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(5, 6), tableroTest[5][6]));
		//Abajo izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[6][3] = new Casilla();
		tableroTest[6][3].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(6, 3), tableroTest[6][3]));
		//Abajo derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[6][5] = new Casilla();
		tableroTest[6][5].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(6, 5), tableroTest[6][5]));
		//No puede mover arriba izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(2, 3), tableroTest[2][3]));
		//No puede mover arriba derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[2][5] = new Casilla();
		tableroTest[2][5].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(2, 5), tableroTest[2][5]));
		//No puede mover si son del mismo color
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(2, 3), tableroTest[2][3]));
		
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[2][5] = new Casilla();
		tableroTest[2][5].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeMover(new Coordenada(4, 4), new Coordenada(2, 5), tableroTest[2][5]));
	}

	@Test
	public void testPuedeComer() {
		//XXX Caballo Negro
		//Arriba izquierda
		Casilla[][] tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 3), tableroTest[2][3]));
		//Arriba derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[2][5] = new Casilla();
		tableroTest[2][5].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 5), tableroTest[2][5]));
		//Izquierda arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(3, 2), tableroTest[3][2]));
		//Izquierda abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[5][2] = new Casilla();
		tableroTest[5][2].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(5, 2), tableroTest[5][2]));
		//Derecha arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[3][6] = new Casilla();
		tableroTest[3][6].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(3, 6), tableroTest[3][6]));
		//Derecha abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[5][6] = new Casilla();
		tableroTest[5][6].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(5, 6), tableroTest[5][6]));
		//Abajo izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[6][3] = new Casilla();
		tableroTest[6][3].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 3), tableroTest[6][3]));
		//Abajo derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[6][5] = new Casilla();
		tableroTest[6][5].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 5), tableroTest[6][5]));
		
		//XXX No puede comer una pieza del mismo color
		//Arriba izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 3), tableroTest[2][3]));
		//Arriba derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[2][5] = new Casilla();
		tableroTest[2][5].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 5), tableroTest[2][5]));
		//Izquierda arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(3, 2), tableroTest[3][2]));
		//Izquierda abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[5][2] = new Casilla();
		tableroTest[5][2].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(5, 2), tableroTest[5][2]));
		//Derecha arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[3][6] = new Casilla();
		tableroTest[3][6].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(3, 6), tableroTest[3][6]));
		//Derecha abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[5][6] = new Casilla();
		tableroTest[5][6].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(5, 6), tableroTest[5][6]));
		//Abajo izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[6][3] = new Casilla();
		tableroTest[6][3].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 3), tableroTest[6][3]));
		//Abajo derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.NEGRA));
		tableroTest[6][5] = new Casilla();
		tableroTest[6][5].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 5), tableroTest[6][5]));
		
		//XXX Caballo Blanco
		//Arriba izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 3), tableroTest[2][3]));
		//Arriba derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[2][5] = new Casilla();
		tableroTest[2][5].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 5), tableroTest[2][5]));
		//Izquierda arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(3, 2), tableroTest[3][2]));
		//Izquierda abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[5][2] = new Casilla();
		tableroTest[5][2].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(5, 2), tableroTest[5][2]));
		//Derecha arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[3][6] = new Casilla();
		tableroTest[3][6].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(3, 6), tableroTest[3][6]));
		//Derecha abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[5][6] = new Casilla();
		tableroTest[5][6].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(5, 6), tableroTest[5][6]));
		//Abajo izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[6][3] = new Casilla();
		tableroTest[6][3].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 3), tableroTest[6][3]));
		//Abajo derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[6][5] = new Casilla();
		tableroTest[6][5].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 5), tableroTest[6][5]));
		
		//XXX No puede comer una pieza del mismo color
		//Arriba izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 3), tableroTest[2][3]));
		//Arriba derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[2][5] = new Casilla();
		tableroTest[2][5].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(2, 5), tableroTest[2][5]));
		//Izquierda arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(3, 2), tableroTest[3][2]));
		//Izquierda abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[5][2] = new Casilla();
		tableroTest[5][2].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(5, 2), tableroTest[5][2]));
		//Derecha arriba
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[3][6] = new Casilla();
		tableroTest[3][6].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(3, 6), tableroTest[3][6]));
		//Derecha abajo
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[5][6] = new Casilla();
		tableroTest[5][6].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(5, 6), tableroTest[5][6]));
		//Abajo izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[6][3] = new Casilla();
		tableroTest[6][3].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 3), tableroTest[6][3]));
		//Abajo derecha
		tableroTest = new Casilla[8][8];
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Caballo(Color.BLANCA));
		tableroTest[6][5] = new Casilla();
		tableroTest[6][5].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[4][4].getPieza().puedeComer(new Coordenada(4, 4), new Coordenada(6, 5), tableroTest[6][5]));
	}

}
