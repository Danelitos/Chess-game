package org.pmoo.ajedrez;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class PeonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPuedeMover() throws NoSuchFieldException, SecurityException {
		//Test para probar que el peon no puede moverse
		Casilla[][] tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Peon(Color.NEGRA));
		tableroTest[1][0]= new Casilla();
		tableroTest[1][0].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[0][0].getPieza().puedeMover(new Coordenada(0, 0), new Coordenada(1, 0), tableroTest[1][0]));
		assertFalse(tableroTest[1][0].getPieza().puedeMover(new Coordenada(1, 0), new Coordenada(0, 0), tableroTest[0][0]));
		//Puede Mover 1 casilla
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Peon(Color.NEGRA));
		tableroTest[1][1]= new Casilla();
		tableroTest[1][1].setPieza(new Peon(Color.BLANCA));
		tableroTest[1][0]= new Casilla();
		tableroTest[1][0].setPieza(new NoPieza(Color.BLANCA));
		tableroTest[0][1]= new Casilla();
		tableroTest[0][1].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[0][0].getPieza().puedeMover(new Coordenada(0, 0), new Coordenada(1, 0), tableroTest[1][0]));
		assertTrue(tableroTest[1][1].getPieza().puedeMover(new Coordenada(1, 1), new Coordenada(0, 1), tableroTest[0][1]));
		//Puede mover 2 casillas
		tableroTest= new Casilla[8][8];
		tableroTest[1][0]= new Casilla();
		tableroTest[1][0].setPieza(new Peon(Color.NEGRA));
		tableroTest[6][1]= new Casilla();
		tableroTest[6][1].setPieza(new Peon(Color.BLANCA));
		tableroTest[3][0]= new Casilla();
		tableroTest[3][0].setPieza(new NoPieza(Color.BLANCA));
		tableroTest[4][1]= new Casilla();
		tableroTest[4][1].setPieza(new NoPieza(Color.BLANCA));
		assertTrue(tableroTest[1][0].getPieza().puedeMover(new Coordenada(1, 0), new Coordenada(3, 0), tableroTest[3][0]));
		assertTrue(tableroTest[6][1].getPieza().puedeMover(new Coordenada(6, 1), new Coordenada(4, 1), tableroTest[4][1]));
		//No puede mover 2 casillas
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Peon(Color.NEGRA));
		tableroTest[1][1]= new Casilla();
		tableroTest[1][1].setPieza(new Peon(Color.BLANCA));
		tableroTest[2][0]= new Casilla();
		tableroTest[2][0].setPieza(new NoPieza(Color.BLANCA));
		tableroTest[3][1]= new Casilla();
		tableroTest[3][1].setPieza(new NoPieza(Color.BLANCA));
		assertFalse(tableroTest[0][0].getPieza().puedeMover(new Coordenada(0, 0), new Coordenada(2, 0), tableroTest[2][0]));
		assertFalse(tableroTest[1][1].getPieza().puedeMover(new Coordenada(1, 1), new Coordenada(3, 1), tableroTest[3][1]));
		
		
	}

	@Test
	public void testPuedeComer() {
		//Puede comer la negra a la derecha y la blanca a la izquierda
		Casilla[][] tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Peon(Color.NEGRA));
		tableroTest[1][1]= new Casilla();
		tableroTest[1][1].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(1, 1), tableroTest[1][1]));
		assertTrue(tableroTest[1][1].getPieza().puedeComer(new Coordenada(1, 1), new Coordenada(0, 0), tableroTest[0][0]));
		//Puede comer la negra a la izquierda y la blanca a la derecha
		tableroTest= new Casilla[8][8];
		tableroTest[1][1]= new Casilla();
		tableroTest[1][1].setPieza(new Peon(Color.NEGRA));
		tableroTest[2][0]= new Casilla();
		tableroTest[2][0].setPieza(new Peon(Color.BLANCA));
		assertTrue(tableroTest[1][1].getPieza().puedeComer(new Coordenada(1, 1), new Coordenada(2, 0), tableroTest[2][0]));
		assertTrue(tableroTest[2][0].getPieza().puedeComer(new Coordenada(2, 0), new Coordenada(1,1), tableroTest[1][1]));
		//No puede comer
		tableroTest= new Casilla[8][8];
		tableroTest[0][0]= new Casilla();
		tableroTest[0][0].setPieza(new Peon(Color.NEGRA));
		tableroTest[1][1]= new Casilla();
		tableroTest[1][1].setPieza(new Peon(Color.BLANCA));
		tableroTest[1][0]= new Casilla();
		tableroTest[1][0].setPieza(new NoPieza(Color.BLANCA));
		tableroTest[0][1]= new Casilla();
		tableroTest[0][1].setPieza(new NoPieza(Color.BLANCA));
		assertFalse(tableroTest[0][0].getPieza().puedeComer(new Coordenada(0, 0), new Coordenada(1, 0), tableroTest[1][0]));
		assertFalse(tableroTest[1][1].getPieza().puedeComer(new Coordenada(1, 1), new Coordenada(0, 1), tableroTest[0][1]));
		//No puede comer una de su mismo color
		tableroTest= new Casilla[8][8];
		tableroTest[1][1]= new Casilla();
		tableroTest[1][1].setPieza(new Peon(Color.NEGRA));
		tableroTest[2][0]= new Casilla();
		tableroTest[2][0].setPieza(new Peon(Color.NEGRA));
		assertFalse(tableroTest[1][1].getPieza().puedeComer(new Coordenada(1, 1), new Coordenada(2, 0), tableroTest[2][0]));
		
		tableroTest= new Casilla[8][8];
		tableroTest[1][1]= new Casilla();
		tableroTest[1][1].setPieza(new Peon(Color.BLANCA));
		tableroTest[2][0]= new Casilla();
		tableroTest[2][0].setPieza(new Peon(Color.BLANCA));
		assertFalse(tableroTest[2][0].getPieza().puedeComer(new Coordenada(2, 0), new Coordenada(1, 1), tableroTest[1][1]));
		
	}

}
