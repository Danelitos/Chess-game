package org.pmoo.ajedrez;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class AjedrezTest {
	private Tablero miTablero;
	@Before
	public void setUp() throws Exception {
		miTablero= Tablero.getMiTablero();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testJugarPartida() throws FileNotFoundException {
//		System.setIn(new BufferedInputStream(new FileInputStream("PartidasTxts/ReyAhogado.txt")));
//		Ajedrez.getMiAjedrez().jugarPartida();
		System.setIn(new BufferedInputStream(new FileInputStream("PartidasTxts/GananBlancas.txt")));
		Ajedrez.getMiAjedrez().jugarPartida();
	}

	@Test
	public void testTurno() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException {
		System.setIn(new BufferedInputStream(new FileInputStream("PartidasTxts/turno.txt")));
		Class<Ajedrez> ajedrez=Ajedrez.class;
		Method crearJugadores=ajedrez.getDeclaredMethod("crearJugadores", null);
		crearJugadores.setAccessible(true);
		crearJugadores.invoke(Ajedrez.getMiAjedrez(), null);
		Ajedrez.getMiAjedrez().turno();
	}

}
