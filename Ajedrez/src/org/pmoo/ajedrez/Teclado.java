package org.pmoo.ajedrez;

import java.util.Scanner;


public class Teclado {
	//Atributos 
	private static Teclado miTeclado;
	private Scanner teclado;
	
	//Constructora
	private Teclado() {
		this.teclado= new Scanner(System.in);
	}
	
	public String pedirEntrada() {
		String texto=teclado.nextLine();
		return texto;
	}
	
	public static Teclado getTeclado() {
		if(Teclado.miTeclado==null) {
			Teclado.miTeclado = new Teclado();
		}
		return Teclado.miTeclado;
	}
}
