package org.pmoo.ajedrez;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPuedeMover() {
		// Puede mover a la izquierda
		Casilla[][] tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(3, 2), tableroTest[3][2]));
		// Puede mover a la derecha
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[3][4] = new Casilla();
		tableroTest[3][4].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(3, 4), tableroTest[3][4]));
		// Puede mover a arriba
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(2, 3), tableroTest[2][3]));
		// Puede mover abajo
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[4][3] = new Casilla();
		tableroTest[4][3].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(4, 3), tableroTest[4][3]));
		// Puede mover arriba a la izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[2][2] = new Casilla();
		tableroTest[2][2].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(2, 2), tableroTest[2][2]));
		// Puede mover arriba a la derecha
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[2][4] = new Casilla();
		tableroTest[2][4].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(2, 4), tableroTest[2][4]));
		// Puede mover abajo a la izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[4][2] = new Casilla();
		tableroTest[4][2].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(4, 2), tableroTest[4][2]));
		// Puede mover abajo a la derecha
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(4, 4), tableroTest[4][4]));
		// No puede mover a los lados 
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new Peon(Color.BLANCA));
		tableroTest[3][4] = new Casilla();
		tableroTest[3][4].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(3, 2), tableroTest[3][2]));
		assertFalse(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(3, 4), tableroTest[3][4]));
		// No puede mover verticalmente
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new Peon(Color.BLANCA));
		tableroTest[4][3] = new Casilla();
		tableroTest[4][3].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(2, 3), tableroTest[2][3]));
		assertFalse(tableroTest[3][3].getPieza().puedeMover(new Coordenada(3, 3), new Coordenada(4, 3), tableroTest[4][3]));
		
	}

	@Test
	public void testPuedeComer() {
		//TODO Rey negro
		// Puede comer a la izquierda
		Casilla[][] tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(3, 2), tableroTest[3][2]));
		// Puede comer a la derecha
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[3][4] = new Casilla();
		tableroTest[3][4].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(3, 4), tableroTest[3][4]));
		// Puede comer a arriba
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[2][3] = new Casilla();
		tableroTest[2][3].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(2, 3), tableroTest[2][3]));
		// Puede comer abajo
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[4][3] = new Casilla();
		tableroTest[4][3].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(4, 3), tableroTest[4][3]));
		// Puede comer arriba a la izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[2][2] = new Casilla();
		tableroTest[2][2].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(2, 2), tableroTest[2][2]));
		// Puede comer arriba a la derecha
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[2][4] = new Casilla();
		tableroTest[2][4].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(2, 4), tableroTest[2][4]));
		// Puede comer abajo a la izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[4][2] = new Casilla();
		tableroTest[4][2].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(4, 2), tableroTest[4][2]));
		// Puede comer abajo a la derecha
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[4][4] = new Casilla();
		tableroTest[4][4].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(4, 4), tableroTest[4][4]));
		
		//No puede comer pieza mismo color
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(3, 2), tableroTest[3][2]));
		
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.NEGRA));
		tableroTest[3][4] = new Casilla();
		tableroTest[3][4].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(3, 4), tableroTest[3][4]));
		
		//TODO Rey blanco
		// Puede comer a la izquierda
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.BLANCA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(3, 2), tableroTest[3][2]));
		// Puede comer a la derecha
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.BLANCA));
		tableroTest[3][4] = new Casilla();
		tableroTest[3][4].setPieza(new Peon(Color.NEGRA));
		assertTrue(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(3, 4), tableroTest[3][4]));
		
		//No puede comer pieza mismo color
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.BLANCA));
		tableroTest[3][2] = new Casilla();
		tableroTest[3][2].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(3, 2), tableroTest[3][2]));
		
		tableroTest = new Casilla[8][8];
		tableroTest[3][3] = new Casilla();
		tableroTest[3][3].setPieza(new Rey(Color.BLANCA));
		tableroTest[3][4] = new Casilla();
		tableroTest[3][4].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[3][3].getPieza().puedeComer(new Coordenada(3, 3), new Coordenada(3, 4), tableroTest[3][4]));
	}

}
