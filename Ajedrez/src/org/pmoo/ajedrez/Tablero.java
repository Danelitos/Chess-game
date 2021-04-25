package org.pmoo.ajedrez;

public class Tablero {
	// Atributos
	private static Tablero miTablero;
	private Casilla[][] tablero;

	// Constructora
	private Tablero() {
		this.tablero = new Casilla[8][8];
		this.inicializarTablero();
	}

	// Metodos
	public static Tablero getMiTablero() {
		if (Tablero.miTablero == null) {
			Tablero.miTablero = new Tablero();
		}
		return Tablero.miTablero;
	}

	private void inicializarTablero() {
		// Casillas vacias
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla();
			}
		}
		// Piezas Negras
		tablero[0][0].setPieza(new Torre(Color.NEGRA));
		tablero[0][1].setPieza(new Caballo(Color.NEGRA));
		tablero[0][2].setPieza(new Alfil(Color.NEGRA));
		tablero[0][4].setPieza(new Rey(Color.NEGRA));
		tablero[0][3].setPieza(new Dama(Color.NEGRA));
		tablero[0][5].setPieza(new Alfil(Color.NEGRA));
		tablero[0][6].setPieza(new Caballo(Color.NEGRA));
		tablero[0][7].setPieza(new Torre(Color.NEGRA));

		for (int j = 0; j < tablero[1].length; j++) {
			tablero[1][j].setPieza(new Peon(Color.NEGRA));
		}

		// Piezas Blancas
		tablero[7][0].setPieza(new Torre(Color.BLANCA));
		tablero[7][1].setPieza(new Caballo(Color.BLANCA));
		tablero[7][2].setPieza(new Alfil(Color.BLANCA));
		tablero[7][4].setPieza(new Rey(Color.BLANCA));
		tablero[7][3].setPieza(new Dama(Color.BLANCA));
		tablero[7][5].setPieza(new Alfil(Color.BLANCA));
		tablero[7][6].setPieza(new Caballo(Color.BLANCA));
		tablero[7][7].setPieza(new Torre(Color.BLANCA));

		for (int j = 0; j < tablero[6].length; j++) {
			tablero[6][j].setPieza(new Peon(Color.BLANCA));
		}

	}

	public boolean jaqueMate() {
//		boolean[] puedeMover=new boolean[8];
//		boolean[] puedeComer=new boolean[8];
//		boolean jaqueMateBlanca=false;
//		boolean jaqueMateNegra=false;
//		for(int i=0;i<tablero.length;i++) {
//			for(int j=0;j<tablero[i].length;j++) {
//				if (tablero[i][j].getPieza() instanceof Rey && tablero[i][j].getPieza().getColor()==Color.BLANCA){
//					try {
//						puedeMover[0]=tablero[i][j].getPieza().puedeMover(i, j, i+1 ,j, tablero[i+1][j]);
//						puedeMover[1]=tablero[i][j].getPieza().puedeMover(i, j, i-1 ,j, tablero[i-1][j]);
//						puedeMover[2]=tablero[i][j].getPieza().puedeMover(i, j, i ,j+1, tablero[i][j+1]);
//						puedeMover[3]=tablero[i][j].getPieza().puedeMover(i, j, i ,j-1, tablero[i][j-1]);
//						puedeMover[4]=tablero[i][j].getPieza().puedeMover(i, j, i+1 ,j-1, tablero[i+1][j-1]);
//						puedeMover[5]=tablero[i][j].getPieza().puedeMover(i, j, i+1 ,j+1, tablero[i+1][j+1]);
//						puedeMover[6]=tablero[i][j].getPieza().puedeMover(i, j, i-1 ,j+1, tablero[i-1][j+1]);
//						puedeMover[7]=tablero[i][j].getPieza().puedeMover(i, j, i-1 ,j-1, tablero[i-1][j-1]);
//						puedeComer[0]=tablero[i][j].getPieza().puedeComer(i, j, i+1 ,j, tablero[i+1][j]);
//						puedeComer[1]=tablero[i][j].getPieza().puedeComer(i, j, i-1 ,j, tablero[i-1][j]);
//						puedeComer[2]=tablero[i][j].getPieza().puedeComer(i, j, i ,j+1, tablero[i][j+1]);
//						puedeComer[3]=tablero[i][j].getPieza().puedeComer(i, j, i ,j-1, tablero[i][j-1]);
//						puedeComer[4]=tablero[i][j].getPieza().puedeComer(i, j, i+1 ,j-1, tablero[i+1][j-1]);
//						puedeComer[5]=tablero[i][j].getPieza().puedeComer(i, j, i+1 ,j+1, tablero[i+1][j+1]);
//						puedeComer[6]=tablero[i][j].getPieza().puedeComer(i, j, i-1 ,j+1, tablero[i-1][j+1]);
//						puedeComer[7]=tablero[i][j].getPieza().puedeComer(i, j, i-1 ,j-1, tablero[i-1][j-1]);
//					}
//					//FIXME Arreglar lo mas rapido posible
//					catch(ArrayIndexOutOfBoundsException e){
//						
//					}
//					for(int n=0;n<8;n++) {
//						jaqueMateBlanca=jaqueMateBlanca || !puedeMover[n] || !puedeComer[n];
//					}
//					if(jaqueMateBlanca) {
//						System.out.println("Han perdido las blancas, enhorabuena a las negras, habeis GANADO!!!");
//						return true;
//					}
//						
//
//				}
//				else if (tablero[i][j].getPieza() instanceof Rey && tablero[i][j].getPieza().getColor()==Color.NEGRA) {
//					try {
//						puedeMover[0]=tablero[i][j].getPieza().puedeMover(i, j, i+1 ,j, tablero[i+1][j]);
//						puedeMover[1]=tablero[i][j].getPieza().puedeMover(i, j, i-1 ,j, tablero[i-1][j]);
//						puedeMover[2]=tablero[i][j].getPieza().puedeMover(i, j, i ,j+1, tablero[i][j+1]);
//						puedeMover[3]=tablero[i][j].getPieza().puedeMover(i, j, i ,j-1, tablero[i][j-1]);
//						puedeMover[4]=tablero[i][j].getPieza().puedeMover(i, j, i+1 ,j-1, tablero[i+1][j-1]);
//						puedeMover[5]=tablero[i][j].getPieza().puedeMover(i, j, i+1 ,j+1, tablero[i+1][j+1]);
//						puedeMover[6]=tablero[i][j].getPieza().puedeMover(i, j, i-1 ,j+1, tablero[i-1][j+1]);
//						puedeMover[7]=tablero[i][j].getPieza().puedeMover(i, j, i-1 ,j-1, tablero[i-1][j-1]);
//						puedeComer[0]=tablero[i][j].getPieza().puedeComer(i, j, i+1 ,j, tablero[i+1][j]);
//						puedeComer[1]=tablero[i][j].getPieza().puedeComer(i, j, i-1 ,j, tablero[i-1][j]);
//						puedeComer[2]=tablero[i][j].getPieza().puedeComer(i, j, i ,j+1, tablero[i][j+1]);
//						puedeComer[3]=tablero[i][j].getPieza().puedeComer(i, j, i ,j-1, tablero[i][j-1]);
//						puedeComer[4]=tablero[i][j].getPieza().puedeComer(i, j, i+1 ,j-1, tablero[i+1][j-1]);
//						puedeComer[5]=tablero[i][j].getPieza().puedeComer(i, j, i+1 ,j+1, tablero[i+1][j+1]);
//						puedeComer[6]=tablero[i][j].getPieza().puedeComer(i, j, i-1 ,j+1, tablero[i-1][j+1]);
//						puedeComer[7]=tablero[i][j].getPieza().puedeComer(i, j, i-1 ,j-1, tablero[i-1][j-1]);
//					}
//					//FIXME Arreglar mas rapido posible
//					catch(ArrayIndexOutOfBoundsException e){
//						
//					}
//					for(int n=0;n<8;n++) {
//						jaqueMateNegra=jaqueMateNegra || !puedeMover[n] || !puedeComer[n];
//					}
//					if(jaqueMateNegra) {
//						System.out.println("Han perdido las negras, enhorabuena a las blancas, habeis GANADO!!!");
//						return true;
//					}
//				}
//			}
//		}
		return false;
	}

	public void jaque() {

	}

	public boolean reyAhogado() {
		return false;
	}

	public void coronacion() {
		for (int i = 0; i < tablero.length; i++) {
			if(tablero[0][i].getPieza() instanceof Peon && tablero[0][i].getPieza().getColor()==Color.BLANCA) {
				tablero[0][i].setPieza(new Dama(Color.BLANCA));
			}
		}
		for (int i = 0; i < tablero.length; i++) {
			if(tablero[7][i].getPieza() instanceof Peon && tablero[0][i].getPieza().getColor()==Color.NEGRA) {
				tablero[7][i].setPieza(new Dama(Color.NEGRA));
			}
		}
	}

	public Coordenada seleccionarPieza() {
		System.out.println("Que pieza quieres mover?");
		int seleccion = -1;
		while (seleccion < 0) {
			String seleccionDePieza = Teclado.getTeclado().pedirEntrada();
			try {
				seleccion = Integer.parseInt(seleccionDePieza);
			} catch (NumberFormatException e) {
				System.err.println("Por favor introduce un numero");
			}
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					if (tablero[i][j].getPieza().getNumeroPieza() == seleccion) {
						return new Coordenada ( i, j );
					}
				}
			}
			seleccion = -1;
			System.err.println("Esa pieza no se ha encontrado, por favor vuelva a seleccionar una pieza");
		}
		return null;
	}

	public void imprimirTableroConNumeros(Jugador pJugador) {
		int cont = 1;
		System.out.println("\n\n ————————————————————————————————————");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				Pieza p = tablero[i][j].getPieza();
				if (!(p instanceof NoPieza) && p.getColor() == pJugador.getColor()) {
					System.out.print(" | ");
					tablero[i][j].imprimirPieza();
					System.out.print(cont);
					p.setNumeroPieza(cont);
					cont++;
				} else {
					System.out.print("  | ");
					tablero[i][j].imprimirPieza();
				}
			}
			System.out.println(" | ");
			System.out.println(" ————————————————————————————————————");
		}
	}

	public boolean seleccionarMovimiento() {
		Coordenada posicionPiezaMover = this.seleccionarPieza();
		Pieza piezaMover = tablero[posicionPiezaMover.getFila()][posicionPiezaMover.getColumna()].getPieza();
		boolean[][] puedeMoverse = new boolean[8][8];
		System.out.println("Se va a mover esta pieza: " + piezaMover.visualizarPieza() + piezaMover.getNumeroPieza());
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				puedeMoverse[i][j] = piezaMover.puedeMover(new Coordenada(posicionPiezaMover.getFila(), posicionPiezaMover.getColumna()), new Coordenada(i, j),
						tablero[i][j]);
				if (!puedeMoverse[i][j]) {
					puedeMoverse[i][j] = piezaMover.puedeComer(new Coordenada(posicionPiezaMover.getFila(), posicionPiezaMover.getColumna()), new Coordenada( i, j),
							tablero[i][j]);
				}
			}
		}
		this.imprimirMovimientosConNumeros(puedeMoverse);
		System.out.println("A donde quieres mover la pieza?");
		System.out.println("Mete un caracter que no sea un numero para elegir otra pieza");
		int seleccion = -1;
		boolean movido = false;
		while (seleccion < 0) {
			String seleccionDePieza = Teclado.getTeclado().pedirEntrada();
			try {
				seleccion = Integer.parseInt(seleccionDePieza);
			} catch (NumberFormatException e) {
				System.out.println("Elige otra pieza");
				return false;
			}
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					if (tablero[i][j].getPieza().getNumeroPieza() == seleccion) {
						piezaMover.mover(tablero[i][j]);
						tablero[posicionPiezaMover.getFila()][posicionPiezaMover.getColumna()].setPieza(new NoPieza(Color.BLANCA));
						movido = true;
					}
				}
			}
			if (!movido) {
				seleccion = -1;
				System.err.println("Esa movimiento no es valido, por favor vuelva a seleccionar un movimiento");
			}

		}
		return true;
	}

	private void imprimirMovimientosConNumeros(boolean[][] pPuedeMoverse) {
		int cont = 1;
		System.out.println("\n\n ————————————————————————————————————");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				Pieza p = tablero[i][j].getPieza();
				p.resetearNumeroPieza();
				if (pPuedeMoverse[i][j]) {
					System.out.print(" | ");
					tablero[i][j].imprimirPieza();
					System.out.print(cont);
					p.setNumeroPieza(cont);
					cont++;
				} else {
					System.out.print("  | ");
					tablero[i][j].imprimirPieza();
				}
			}
			System.out.println(" | ");
			System.out.println(" ————————————————————————————————————");
		}
	}

	public boolean casillaVacia(Coordenada pCoordenada) {
		return tablero[pCoordenada.getFila()][pCoordenada.getColumna()].getPieza() instanceof NoPieza;
	}
}
