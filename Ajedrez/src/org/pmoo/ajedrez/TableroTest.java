package org.pmoo.ajedrez;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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
		//No jaque Mate a la negras
		Casilla[][] pierdenNegras= this.nuevoTablero();
		pierdenNegras[4][2].setPieza(new Alfil(Color.BLANCA));
		pierdenNegras[3][7].setPieza(new Dama(Color.BLANCA));
		pierdenNegras[0][4].setPieza(new Rey(Color.NEGRA));
		pierdenNegras[7][7].setPieza(new Rey(Color.BLANCA));
		pierdenNegras[0][3].setPieza(new Dama(Color.NEGRA));
		pierdenNegras[0][5].setPieza(new Alfil(Color.NEGRA));
		this.copiarTablero(pierdenNegras);
		assertFalse(Tablero.getMiTablero().jaqueMate());
		//No jaque Mate a la blancas
		Casilla[][] pierdenBlancas= this.nuevoTablero();
		pierdenBlancas[4][2].setPieza(new Alfil(Color.NEGRA));
		pierdenBlancas[3][7].setPieza(new Dama(Color.NEGRA));
		pierdenBlancas[0][4].setPieza(new Rey(Color.BLANCA));
		pierdenBlancas[7][7].setPieza(new Rey(Color.NEGRA));
		pierdenBlancas[0][3].setPieza(new Dama(Color.BLANCA));
		pierdenBlancas[0][5].setPieza(new Alfil(Color.BLANCA));
		this.copiarTablero(pierdenBlancas);
		assertFalse(Tablero.getMiTablero().jaqueMate());
		//Jaque Mate a la negras
		pierdenNegras= this.nuevoTablero();
		pierdenNegras[4][2].setPieza(new Alfil(Color.BLANCA));
		pierdenNegras[3][7].setPieza(new Dama(Color.BLANCA));
		pierdenNegras[7][7].setPieza(new Rey(Color.BLANCA));
		pierdenNegras[0][3].setPieza(new Dama(Color.NEGRA));
		pierdenNegras[0][5].setPieza(new Alfil(Color.NEGRA));
		this.copiarTablero(pierdenNegras);
		assertTrue(Tablero.getMiTablero().jaqueMate());
		//Jaque Mate a la blancas
		pierdenBlancas= this.nuevoTablero();
		pierdenBlancas[4][2].setPieza(new Alfil(Color.NEGRA));
		pierdenBlancas[3][7].setPieza(new Dama(Color.NEGRA));
		pierdenBlancas[7][7].setPieza(new Rey(Color.NEGRA));
		pierdenBlancas[0][3].setPieza(new Dama(Color.BLANCA));
		pierdenBlancas[0][5].setPieza(new Alfil(Color.BLANCA));
		this.copiarTablero(pierdenBlancas);
		assertTrue(Tablero.getMiTablero().jaqueMate());
	}

	@Test
	public void testJaque() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//Jaque a la negras
		Casilla[][] pierdenNegras= this.nuevoTablero();
		pierdenNegras[4][2].setPieza(new Alfil(Color.BLANCA));
		pierdenNegras[3][7].setPieza(new Dama(Color.BLANCA));
		pierdenNegras[0][4].setPieza(new Rey(Color.NEGRA));
		pierdenNegras[7][7].setPieza(new Rey(Color.BLANCA));
		pierdenNegras[0][3].setPieza(new Dama(Color.NEGRA));
		pierdenNegras[0][5].setPieza(new Alfil(Color.NEGRA));
		this.copiarTablero(pierdenNegras);
		Tablero.getMiTablero().jaque(new Jugador("Manolo",Color.BLANCA));

		//Jaque a la blancas
		Casilla[][] pierdenBlancas= this.nuevoTablero();
		pierdenBlancas[4][2].setPieza(new Alfil(Color.NEGRA));
		pierdenBlancas[3][7].setPieza(new Dama(Color.NEGRA));
		pierdenBlancas[0][4].setPieza(new Rey(Color.BLANCA));
		pierdenBlancas[7][7].setPieza(new Rey(Color.NEGRA));
		pierdenBlancas[0][3].setPieza(new Dama(Color.BLANCA));
		pierdenBlancas[0][5].setPieza(new Alfil(Color.BLANCA));
		this.copiarTablero(pierdenBlancas);
		Tablero.getMiTablero().jaque(new Jugador("Maialen",Color.NEGRA));
		
		//No jaque a la negras
		pierdenNegras= this.nuevoTablero();
		pierdenNegras[4][2].setPieza(new Alfil(Color.BLANCA));
		pierdenNegras[3][7].setPieza(new Dama(Color.BLANCA));
		pierdenNegras[0][0].setPieza(new Rey(Color.NEGRA));
		pierdenNegras[7][7].setPieza(new Rey(Color.BLANCA));
		pierdenNegras[0][3].setPieza(new Dama(Color.NEGRA));
		pierdenNegras[0][5].setPieza(new Alfil(Color.NEGRA));
		this.copiarTablero(pierdenNegras);
		Tablero.getMiTablero().jaque(new Jugador("Manolo",Color.BLANCA));
		
		//No jaque a la blancas
		pierdenBlancas= this.nuevoTablero();
		pierdenBlancas[4][2].setPieza(new Alfil(Color.NEGRA));
		pierdenBlancas[3][7].setPieza(new Dama(Color.NEGRA));
		pierdenBlancas[0][0].setPieza(new Rey(Color.BLANCA));
		pierdenBlancas[7][7].setPieza(new Rey(Color.NEGRA));
		pierdenBlancas[0][3].setPieza(new Dama(Color.BLANCA));
		pierdenBlancas[0][5].setPieza(new Alfil(Color.BLANCA));
		this.copiarTablero(pierdenBlancas);
		Tablero.getMiTablero().jaque(new Jugador("Maialen",Color.NEGRA));
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

	private Casilla getCasilla(Coordenada pCoordenada) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<Tablero> tableroOriginal=Tablero.class;
		Field tableroACambiar=tableroOriginal.getDeclaredField("tablero");
		tableroACambiar.setAccessible(true);
		Casilla[][] miTablero= (Casilla[][]) tableroACambiar.get(Tablero.getMiTablero());
		Casilla casillaDevolver= miTablero[pCoordenada.getFila()][pCoordenada.getColumna()];
		return casillaDevolver;
		
	}
	
	@Test
	public void testCoronacion() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//Coronacion negras
		Casilla[][] coronacionNegras= this.nuevoTablero();
		coronacionNegras[7][4].setPieza(new Peon(Color.NEGRA));
		coronacionNegras[7][7].setPieza(new Rey(Color.BLANCA));
		coronacionNegras[0][0].setPieza(new Rey(Color.NEGRA));
		this.copiarTablero(coronacionNegras);
		Tablero.getMiTablero().coronacion();
		assertEquals(this.getCasilla(new Coordenada(7,4)).getPieza().getClass(),Dama.class);
		//Coronacion blancas
		Casilla[][] coronacionBlancas= this.nuevoTablero();
		coronacionBlancas[0][4].setPieza(new Peon(Color.BLANCA));
		coronacionBlancas[7][7].setPieza(new Rey(Color.BLANCA));
		coronacionBlancas[0][0].setPieza(new Rey(Color.NEGRA));
		this.copiarTablero(coronacionBlancas);
		Tablero.getMiTablero().coronacion();
		assertEquals(this.getCasilla(new Coordenada(0,4)).getPieza().getClass(),Dama.class);
		//No coronacion negras
		coronacionNegras= this.nuevoTablero();
		coronacionNegras[5][4].setPieza(new Peon(Color.NEGRA));
		coronacionNegras[7][7].setPieza(new Rey(Color.BLANCA));
		coronacionNegras[0][0].setPieza(new Rey(Color.NEGRA));
		this.copiarTablero(coronacionNegras);
		Tablero.getMiTablero().coronacion();
		assertEquals(this.getCasilla(new Coordenada(5,4)).getPieza().getClass(),Peon.class);
		//No coronacion blancas
		coronacionBlancas= this.nuevoTablero();
		coronacionBlancas[5][4].setPieza(new Peon(Color.NEGRA));
		coronacionBlancas[7][7].setPieza(new Rey(Color.BLANCA));
		coronacionBlancas[0][0].setPieza(new Rey(Color.NEGRA));
		this.copiarTablero(coronacionBlancas);
		Tablero.getMiTablero().coronacion();
		assertEquals(this.getCasilla(new Coordenada(5,4)).getPieza().getClass(),Peon.class);
	}

	@Test
	public void testCasillaVacia() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//Casilla vacia
		Casilla[][] casillaVacia= this.nuevoTablero();
		casillaVacia[0][4].setPieza(new NoPieza());
		this.copiarTablero(casillaVacia);
		assertTrue(Tablero.getMiTablero().casillaVacia(new Coordenada(0,4)));
		 //No casilla vacia
		 casillaVacia= this.nuevoTablero();
		 casillaVacia[0][4].setPieza(new Peon(Color.BLANCA));
		 this.copiarTablero(casillaVacia);
		 assertFalse(Tablero.getMiTablero().casillaVacia(new Coordenada(0,4)));
	}

}
