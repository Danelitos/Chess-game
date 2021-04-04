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

	}
	
	public int[] seleccionarPieza() {
		System.out.println("Que pieza quieres mover?");
		int seleccion=-1;
		while(seleccion<0) {
			String seleccionDePieza= Teclado.getTeclado().pedirEntrada();
			try {
				seleccion=Integer.parseInt(seleccionDePieza);
			}
			catch(NumberFormatException e){
				System.err.println("Por favor introduce un numero");
			}
			for(int i=0;i<tablero.length;i++) {
				for(int j=0;j<tablero[i].length;j++) {
					if(tablero[i][j].getPieza().getNumeroPieza()==seleccion) {
						return new int[] {i,j};
					}
				}
			}
			seleccion=-1;
			System.err.println("Esa pieza no se ha encontrado, por favor vuelva a seleccionar una pieza");
		}
		return null;
	}
	
	public void imprimirTableroConNumeros(Jugador pJugador) {
		int cont=1;
		System.out.println("\n\n ————————————————————————————————————");
		for(int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero[i].length;j++) {
				Pieza p=tablero[i][j].getPieza();
				if (!(p instanceof NoPieza) && p.getColor()==pJugador.getColor()) {
					System.out.print(" | ");
					tablero[i][j].imprimirPieza();
					System.out.print(cont);
					p.setNumeroPieza(cont);
					cont++;
				}
				else{
					System.out.print("  | ");
					tablero[i][j].imprimirPieza();
				}
			}
			System.out.println(" | ");
			System.out.println(" ————————————————————————————————————");
		}
	}
	
	public boolean seleccionarMovimiento() {
		int[] posicionPiezaMover=this.seleccionarPieza();
		Pieza piezaMover=tablero[posicionPiezaMover[0]][posicionPiezaMover[1]].getPieza();
		boolean[][] puedeMoverse=new boolean[8][8];
		System.out.println("Se va a mover esta pieza: " + piezaMover.visualizarPieza() + piezaMover.getNumeroPieza());
		for(int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero[i].length;j++) {
//				if(i!=posicionPiezaMover[0] && j!=posicionPiezaMover[1]) {
					puedeMoverse[i][j]=piezaMover.puedeMover(posicionPiezaMover[0], posicionPiezaMover[1], i, j, tablero[i][j]);
					puedeMoverse[i][j]=piezaMover.puedeComer(posicionPiezaMover[0], posicionPiezaMover[1], i, j, tablero[i][j]);
//				}
			}
		}
		this.imprimirMovimientosConNumeros(puedeMoverse);
		System.out.println("A donde quieres mover la pieza?");
		System.out.println("Mete un caracter que no sea un numero para elegir otra pieza");
		int seleccion=-1;
		boolean movido=false;
		while(seleccion<0) {
			String seleccionDePieza= Teclado.getTeclado().pedirEntrada();
			try {
				seleccion=Integer.parseInt(seleccionDePieza);
			}
			catch(NumberFormatException e){
				System.out.println("Elige otra pieza");
				return false;
			}
			for(int i=0;i<tablero.length;i++) {
				for(int j=0;j<tablero[i].length;j++) {
					if(tablero[i][j].getPieza().getNumeroPieza()==seleccion) {
						piezaMover.mover(tablero[i][j]);
						tablero[posicionPiezaMover[0]][posicionPiezaMover[1]].setPieza(new NoPieza(Color.BLANCA));
						movido=true;
					}
				}
			}
			if(!movido) {
				seleccion=-1;
				System.err.println("Esa pieza no se ha encontrado, por favor vuelva a seleccionar una pieza");
			}
			
		}
		return true;	
	}
	
	private void imprimirMovimientosConNumeros(boolean[][] puedeMoverse) {
		int cont=1;
		System.out.println("\n\n ————————————————————————————————————");
		for(int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero[i].length;j++) {
				Pieza p=tablero[i][j].getPieza();
				p.resetearNumeroPieza();
				if (puedeMoverse[i][j]) {
					System.out.print(" | ");
					tablero[i][j].imprimirPieza();
					System.out.print(cont);
					p.setNumeroPieza(cont);
					cont++;
				}
				else{
					System.out.print("  | ");
					tablero[i][j].imprimirPieza();
				}
			}
			System.out.println(" | ");
			System.out.println(" ————————————————————————————————————");
		}
	}
}
