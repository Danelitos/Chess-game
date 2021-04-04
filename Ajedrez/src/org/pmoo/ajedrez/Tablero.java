package org.pmoo.ajedrez;

public class Tablero {
	//Atributos 
	private static Tablero miTablero;
	private Casilla[][] tablero;
	
	//Constructora
	private Tablero() {
		this.tablero= new Casilla[8][8];
		this.inicializarTablero();
	}
	
	//Metodos
	public static Tablero getMiTablero() {
		if(Tablero.miTablero==null) {
			Tablero.miTablero= new Tablero();
			}
		return Tablero.miTablero;
	}
	
	private void inicializarTablero() {
		//Casillas vacias
		for(int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero[i].length;j++) {
				tablero[i][j]= new Casilla();
			}
		}
		//Piezas Negras
		tablero[0][0].setPieza(new Torre(Color.NEGRA));
		tablero[0][1].setPieza(new Caballo(Color.NEGRA));
		tablero[0][2].setPieza(new Alfil(Color.NEGRA));
		tablero[0][3].setPieza(new Rey(Color.NEGRA));
		tablero[0][4].setPieza(new Dama(Color.NEGRA));
		tablero[0][5].setPieza(new Alfil(Color.NEGRA));
		tablero[0][6].setPieza(new Caballo(Color.NEGRA));
		tablero[0][7].setPieza(new Torre(Color.NEGRA));
		
		for(int j=0;j<tablero[1].length;j++){
			tablero[1][j].setPieza(new Peon(Color.NEGRA));
		}
		
		//Piezas Negras
		tablero[7][0].setPieza(new Torre(Color.BLANCA));
		tablero[7][1].setPieza(new Caballo(Color.BLANCA));
		tablero[7][2].setPieza(new Alfil(Color.BLANCA));
		tablero[7][3].setPieza(new Rey(Color.BLANCA));
		tablero[7][4].setPieza(new Dama(Color.BLANCA));
		tablero[7][5].setPieza(new Alfil(Color.BLANCA));
		tablero[7][6].setPieza(new Caballo(Color.BLANCA));
		tablero[7][7].setPieza(new Torre(Color.BLANCA));
		
		for(int j=0;j<tablero[6].length;j++){
			tablero[6][j].setPieza(new Peon(Color.BLANCA));
		}
		
		
		
	
		
		
	}
	
	public boolean jaqueMate() {
		return false;
	}
	
	public void jaque() {
		
	}
	
	public boolean reyAhogado() {
		return false;
	}
	
	public Dama coronacion(Peon peon) {
		return null;
	}
	
	public void imprimirTablero() {
		System.out.println("\n\n ————————————————————————————————————");
		for(int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero[i].length;j++) {
				
				System.out.print(" | ");
				tablero[i][j].imprimirPieza();
			}
			System.out.println(" | ");
			System.out.println(" ————————————————————————————————————");
		}
//		System.out.println("   a    b    c    d    e    f    g    h");
	}
	
	public Pieza seleccionarPieza() {
//		Jugador j;
//		this.imprimirTableroConNumeros(j);
//		System.out.println("Que pieza quieres mover?");
//		String seleccionDePieza= Teclado.getTeclado().pedirEntrada();
		return null;
	}
	
	public void imprimirTableroConNumeros(Jugador pJugador) {
		int cont=1;
		for(int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero[i].length;j++) {
				Pieza p=tablero[i][j].getPieza();
				if (!(p instanceof NoPieza) && p.getColor()==pJugador.getColor()) {
					tablero[i][j].imprimirPieza();
					System.out.print(cont);
					cont++;
				}
			}
		}
	}
	
	public void seleccionarMovimiento() {
//		Pieza piezaMover=this.seleccionarPieza();
//		System.out.println("A donde quieres mover la pieza?");
//		String posicion=Teclado.getTeclado().pedirEntrada();
//		while(!piezaMover.puedeMover(posicion)) {
//			if (piezaMover.puedeMover(posicion)) {
//				piezaMover.mover();
//			}
//			else {
//			System.err.println("No puedes mvoer la pieza a esa posicion, por favor eliga otra posicion");
//			posicion=Teclado.getTeclado().pedirEntrada();
//			}
//		}
		
	}
}
