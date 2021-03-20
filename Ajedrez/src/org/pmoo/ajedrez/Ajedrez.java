package org.pmoo.ajedrez;

import java.util.Random;



public class Ajedrez {
	//Atributos
	private static Ajedrez miAjedrez;
	private Jugador jugador1;
	private Jugador jugador2;
	
	//Constructora
	private Ajedrez() {	
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
		Tablero.getMiTablero().imprimirTablero();
	}
	
	private void crearJugadores() {
		System.out.println("Introduce el nombre del jugador 1:");
		String nombreJugador1=Teclado.getTeclado().pedirEntrada();
		System.out.println("\nIntroduce el nombre del jugador 2:");
		String nombreJugador2=Teclado.getTeclado().pedirEntrada();
		Random r= new Random(2);
		int queficha=r.nextInt();
		if (queficha==0) {
			jugador1= new Jugador(nombreJugador1, Color.NEGRA);
			jugador2= new Jugador(nombreJugador2, Color.BLANCA);
		}
		else {
			jugador2= new Jugador(nombreJugador1, Color.NEGRA);
			jugador1= new Jugador(nombreJugador2, Color.BLANCA);
		}
		System.out.println("\nA " + jugador1.getNombre() + " le ha tocado la ficha " + jugador1.imprimirColor());
		System.out.println("A " + jugador2.getNombre() + " le ha tocado la ficha " + jugador2.imprimirColor());
		
	}
	
	
	public void turno() {
		Tablero.getMiTablero().turno();
	}
}
