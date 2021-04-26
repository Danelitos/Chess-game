package org.pmoo.ajedrez;



import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AjedrezTest {
	

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//XXX ESTOS METODOS HAY QUE EJECUTARLOS DE UNO EN UNO PORQUE TODOS A LA VEZ NO SABEMOS PORQUE CASCA EL PROGRAMA
	
	@Test
	public void testJugarPartida() throws FileNotFoundException {
		System.setIn(new BufferedInputStream(new FileInputStream("PartidasTxts/Coronacion.txt")));
		Ajedrez.getMiAjedrez().jugarPartida();
		
	}
	
	@Test
	public void testJugarPartida2() throws FileNotFoundException {
		
		System.setIn(new BufferedInputStream(new FileInputStream("PartidasTxts/GananBlancas.txt")));
		Ajedrez.getMiAjedrez().jugarPartida();
	}

	@Test
	public void testTurno() throws NoSuchMethodException, SecurityException, IllegalAccessException,
		IllegalArgumentException, InvocationTargetException, FileNotFoundException {
		System.setIn(new BufferedInputStream(new FileInputStream("PartidasTxts/turno.txt")));
		Class<Ajedrez> ajedrez = Ajedrez.class;
		Method crearJugadores = ajedrez.getDeclaredMethod("crearJugadores", null);
		crearJugadores.setAccessible(true);
		crearJugadores.invoke(Ajedrez.getMiAjedrez(), null);
		Ajedrez.getMiAjedrez().turno();
	}

}
