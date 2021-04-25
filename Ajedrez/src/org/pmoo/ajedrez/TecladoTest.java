package org.pmoo.ajedrez;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TecladoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPedirEntrada() {
		System.out.println("Introduce la palabra Ajedrez");
		assertEquals(Teclado.getTeclado().pedirEntrada(),"Ajedrez");
		System.out.println("Introduce el numero 5");
		assertEquals(Integer.parseInt(Teclado.getTeclado().pedirEntrada()),5);
		System.out.println("Introduce el caracter a");
		assertEquals(Teclado.getTeclado().pedirEntrada(),"a");
	}

}
