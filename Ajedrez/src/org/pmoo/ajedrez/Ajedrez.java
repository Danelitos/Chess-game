package org.pmoo.ajedrez;

import java.util.Random;



public class Ajedrez {
	//Atributos
	private static Ajedrez miAjedrez;
	private Jugador jugadorBlanca;
	private Jugador jugadorNegra;
	private Color turno;
	private Tablero miTablero;
	
	//Constructora
	private Ajedrez() {	
		turno=Color.BLANCA;
		miTablero=Tablero.getMiTablero();
	}
	
	//Metodos
	public static Ajedrez getMiAjedrez() {
		if(Ajedrez.miAjedrez==null) {
			Ajedrez.miAjedrez = new Ajedrez();
		}
		return Ajedrez.miAjedrez;
	}
	
	public void jugarPartida() {
		System.out.println("\n █████╗      ██╗███████╗██████╗ ██████╗ ███████╗███████╗");
		System.out.println("██╔══██╗     ██║██╔════╝██╔══██╗██╔══██╗██╔════╝╚══███╔╝");
		System.out.println("███████║     ██║█████╗  ██║  ██║██████╔╝█████╗    ███╔╝ ");
		System.out.println("██╔══██║██   ██║██╔══╝  ██║  ██║██╔══██╗██╔══╝   ███╔╝ ");
		System.out.println("██║  ██║╚█████╔╝███████╗██████╔╝██║  ██║███████╗███████╗");
		System.out.println("╚═╝  ╚═╝ ╚════╝ ╚══════╝╚═════╝ ╚═╝  ╚═╝╚══════╝╚══════╝\n");
		this.crearJugadores();
		do {
			this.turno();
			if (turno==Color.BLANCA) {
				turno=Color.NEGRA;
			}
			else {
				turno=Color.BLANCA;
			}
			Tablero.getMiTablero().coronacion();
		}
		while(!miTablero.jaqueMate() && !miTablero.reyAhogado());
	}
	
	private void crearJugadores() {
		System.out.println("Introduce el nombre del jugador 1:");
		String nombreJugador1=Teclado.getTeclado().pedirEntrada();
		System.out.println("\nIntroduce el nombre del jugador 2:");
		String nombreJugador2=Teclado.getTeclado().pedirEntrada();
		Random r= new Random(2);
		int queficha=r.nextInt();
		if (queficha==0) {
			jugadorNegra= new Jugador(nombreJugador1, Color.NEGRA);
			jugadorBlanca= new Jugador(nombreJugador2, Color.BLANCA);
		}
		else {
			jugadorNegra= new Jugador(nombreJugador2, Color.NEGRA);
			jugadorBlanca= new Jugador(nombreJugador1, Color.BLANCA);
		}
		System.out.println("\nA " + jugadorBlanca.getNombre() + " le ha tocado la ficha " + jugadorBlanca.imprimirColor());
		System.out.println("A " + jugadorNegra.getNombre() + " le ha tocado la ficha " + jugadorNegra.imprimirColor());
		
	}
	
	
	public void turno() {
		Jugador jugadorTurno;
		if(turno==Color.BLANCA){
			jugadorTurno=jugadorBlanca;
		}
		else {
			jugadorTurno=jugadorNegra;
		}
		System.out.println(jugadorTurno.getNombre() + " te toca mover");
		boolean haMovido=false;
		while(!haMovido) {
			miTablero.imprimirTableroConNumeros(jugadorTurno);
			haMovido=miTablero.seleccionarMovimiento();	
		}
		
		
	}
}
