package org.pmoo.ajedrez;

import java.io.BufferedOutputStream;

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
		boolean seHanComidoReyNegro=true;
		boolean seHanComidoReyBlanco=true;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if(tablero[i][j].getPieza() instanceof Rey) {
					if(seHanComidoReyNegro && tablero[i][j].getPieza().getColor()==Color.NEGRA) {
						seHanComidoReyNegro=false;
					}
					if(seHanComidoReyBlanco && tablero[i][j].getPieza().getColor()==Color.BLANCA) {
						seHanComidoReyBlanco=false;
					}

				}
			}
		}
		if(seHanComidoReyNegro) {
			System.out.println("Las negras han perdido, ganan las blancas");
			System.out.println(" ___            __   __        __        ___             /  /");
			System.out.println("|__  |\\ | |__| /  \\ |__)  /\\  |__) |  | |__  |\\ |  /\\   /  / ");
			System.out.println("|___ | \\| |  | \\__/ |  \\ /~~\\ |__) \\__/ |___ | \\| /~~\\ .  .  ");
			System.out.println("                                                             ");
			return true;
		}
		if(seHanComidoReyBlanco) {
			System.out.println("Las blancas han perdido, ganan las negras");
			System.out.println(" ___            __   __        __        ___             /  /");
			System.out.println("|__  |\\ | |__| /  \\ |__)  /\\  |__) |  | |__  |\\ |  /\\   /  / ");
			System.out.println("|___ | \\| |  | \\__/ |  \\ /~~\\ |__) \\__/ |___ | \\| /~~\\ .  .  ");
			System.out.println("                                                             ");
			return true;
		}
		return false;
	}

	public void jaque(Jugador pJugadorQuePoneEnJaque) {
		// Jaque
		Color colorJugadorEnJaque=pJugadorQuePoneEnJaque.getColor()==Color.BLANCA?Color.NEGRA:Color.BLANCA;
		Coordenada posicionRey = null;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j].getPieza() instanceof Rey && tablero[i][j].getPieza().getColor() == colorJugadorEnJaque) {
					posicionRey = new Coordenada(i, j);
				}

			}
		}
		if(posicionRey==null) {
			return;
		}
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (!(tablero[i][j].getPieza() instanceof NoPieza)
						&& tablero[i][j].getPieza().getColor() == pJugadorQuePoneEnJaque.getColor()) {
					 if(tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
							new Coordenada(posicionRey.getFila(), posicionRey.getColumna()),
							tablero[posicionRey.getFila()][posicionRey.getColumna()])) {
						 System.err.println("Las piezas " + (colorJugadorEnJaque==Color.NEGRA?"negras":"blancas") + " estan en jaque");
						 System.err.println(" __          __        __   __    /  /");
						 System.err.println("/  ` |  | | |  \\  /\\  |  \\ /  \\  /  / ");
						 System.err.println("\\__, \\__/ | |__/ /~~\\ |__/ \\__/ .  .  ");
						 System.err.println("                                      ");
						 return;
					 }
				}
			}
		}

	}

	public boolean reyAhogado() {
		// Rey Ahogado Blancas
		boolean[] puedeComerReyBlanco = new boolean[8];
		Coordenada posicionReyBlanco = null;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j].getPieza() instanceof Rey && tablero[i][j].getPieza().getColor() == Color.BLANCA) {
					posicionReyBlanco = new Coordenada(i, j);
				}

			}
		}
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (!(tablero[i][j].getPieza() instanceof NoPieza)
						&& tablero[i][j].getPieza().getColor() == Color.NEGRA) {
					if (!puedeComerReyBlanco[0]) {
						if (posicionReyBlanco.getFila() + 1 > 7) {
							puedeComerReyBlanco[0] = true;
						} else {
							puedeComerReyBlanco[0] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyBlanco.getFila() + 1, posicionReyBlanco.getColumna()),
									tablero[posicionReyBlanco.getFila()][posicionReyBlanco.getColumna()]);
						}

					}

					if (!puedeComerReyBlanco[1]) {
						if (posicionReyBlanco.getFila() - 1 < 0) {
							puedeComerReyBlanco[1] = true;
						} else {
							puedeComerReyBlanco[1] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyBlanco.getFila() - 1, posicionReyBlanco.getColumna()),
									tablero[posicionReyBlanco.getFila()][posicionReyBlanco.getColumna()]);
						}

					}

					if (!puedeComerReyBlanco[2]) {
						if (posicionReyBlanco.getColumna() + 1 > 7) {
							puedeComerReyBlanco[2] = true;
						} else {
							puedeComerReyBlanco[2] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyBlanco.getFila(), posicionReyBlanco.getColumna() + 1),
									tablero[posicionReyBlanco.getFila()][posicionReyBlanco.getColumna()]);
						}
					}

					if (!puedeComerReyBlanco[3]) {
						if (posicionReyBlanco.getColumna() - 1 < 0) {
							puedeComerReyBlanco[3] = true;
						} else {
							puedeComerReyBlanco[3] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyBlanco.getFila(), posicionReyBlanco.getColumna() - 1),
									tablero[posicionReyBlanco.getFila()][posicionReyBlanco.getColumna()]);
						}
					}

					if (!puedeComerReyBlanco[4]) {
						if (posicionReyBlanco.getColumna() - 1 < 0 || posicionReyBlanco.getFila() + 1 > 7) {
							puedeComerReyBlanco[4] = true;
						} else {
							puedeComerReyBlanco[4] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyBlanco.getFila() + 1, posicionReyBlanco.getColumna() - 1),
									tablero[posicionReyBlanco.getFila()][posicionReyBlanco.getColumna()]);
						}
					}

					if (!puedeComerReyBlanco[5]) {
						if (posicionReyBlanco.getColumna() + 1 > 7 || posicionReyBlanco.getFila() + 1 > 7) {
							puedeComerReyBlanco[5] = true;
						} else {
							puedeComerReyBlanco[5] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyBlanco.getFila() + 1, posicionReyBlanco.getColumna() + 1),
									tablero[posicionReyBlanco.getFila()][posicionReyBlanco.getColumna()]);
						}
					}

					if (!puedeComerReyBlanco[6]) {
						if (posicionReyBlanco.getColumna() + 1 > 7 || posicionReyBlanco.getFila() - 1 < 0) {
							puedeComerReyBlanco[6] = true;
						} else {
							puedeComerReyBlanco[6] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyBlanco.getFila() - 1, posicionReyBlanco.getColumna() + 1),
									tablero[posicionReyBlanco.getFila()][posicionReyBlanco.getColumna()]);
						}
					}

					if (!puedeComerReyBlanco[7]) {
						if (posicionReyBlanco.getColumna() - 1 < 0 || posicionReyBlanco.getFila() - 1 < 0) {
							puedeComerReyBlanco[7] = true;
						} else {
							puedeComerReyBlanco[7] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyBlanco.getFila() - 1, posicionReyBlanco.getColumna() - 1),
									tablero[posicionReyBlanco.getFila()][posicionReyBlanco.getColumna()]);
						}
					}
				}
			}
		}
		boolean blancasAhogadas = true;
		for (boolean estaAhogado : puedeComerReyBlanco) {
			blancasAhogadas = blancasAhogadas && estaAhogado;
		}
		if (blancasAhogadas) {
			System.out.println("Las blancas tienen el rey ahogado, habeis quedado en tablas");
			return true;
		}

		// Rey Ahogado Negras
		boolean[] puedeComerReyNegro = new boolean[8];
		Coordenada posicionReyNegro = null;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j].getPieza() instanceof Rey && tablero[i][j].getPieza().getColor() == Color.NEGRA) {
					posicionReyNegro = new Coordenada(i, j);
				}

			}
		}
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (!(tablero[i][j].getPieza() instanceof NoPieza)
						&& tablero[i][j].getPieza().getColor() == Color.BLANCA) {
					if (!puedeComerReyNegro[0]) {
						if (posicionReyNegro.getFila() + 1 > 7) {
							puedeComerReyNegro[0] = true;
						} else {
							puedeComerReyNegro[0] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyNegro.getFila() + 1, posicionReyNegro.getColumna()),
									tablero[posicionReyNegro.getFila()][posicionReyNegro.getColumna()]);
						}

					}

					if (!puedeComerReyNegro[1]) {
						if (posicionReyNegro.getFila() - 1 < 0) {
							puedeComerReyNegro[1] = true;
						} else {
							puedeComerReyNegro[1] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyNegro.getFila() - 1, posicionReyNegro.getColumna()),
									tablero[posicionReyNegro.getFila()][posicionReyNegro.getColumna()]);
						}

					}

					if (!puedeComerReyNegro[2]) {
						if (posicionReyNegro.getColumna() + 1 > 7) {
							puedeComerReyNegro[2] = true;
						} else {
							puedeComerReyNegro[2] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyNegro.getFila(), posicionReyNegro.getColumna() + 1),
									tablero[posicionReyNegro.getFila()][posicionReyNegro.getColumna()]);
						}
					}

					if (!puedeComerReyNegro[3]) {
						if (posicionReyNegro.getColumna() - 1 < 0) {
							puedeComerReyNegro[3] = true;
						} else {
							puedeComerReyNegro[3] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyNegro.getFila(), posicionReyNegro.getColumna() - 1),
									tablero[posicionReyNegro.getFila()][posicionReyNegro.getColumna()]);
						}
					}

					if (!puedeComerReyNegro[4]) {
						if (posicionReyNegro.getColumna() - 1 < 0 || posicionReyNegro.getFila() + 1 > 7) {
							puedeComerReyNegro[4] = true;
						} else {
							puedeComerReyNegro[4] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyNegro.getFila() + 1, posicionReyNegro.getColumna() - 1),
									tablero[posicionReyNegro.getFila()][posicionReyNegro.getColumna()]);
						}
					}

					if (!puedeComerReyNegro[5]) {
						if (posicionReyNegro.getColumna() + 1 > 7 || posicionReyNegro.getFila() + 1 > 7) {
							puedeComerReyNegro[5] = true;
						} else {
							puedeComerReyNegro[5] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyNegro.getFila() + 1, posicionReyNegro.getColumna() + 1),
									tablero[posicionReyNegro.getFila()][posicionReyNegro.getColumna()]);
						}
					}

					if (!puedeComerReyNegro[6]) {
						if (posicionReyNegro.getColumna() + 1 > 7 || posicionReyNegro.getFila() - 1 < 0) {
							puedeComerReyNegro[6] = true;
						} else {
							puedeComerReyNegro[6] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyNegro.getFila() - 1, posicionReyNegro.getColumna() + 1),
									tablero[posicionReyNegro.getFila()][posicionReyNegro.getColumna()]);
						}
					}

					if (!puedeComerReyNegro[7]) {
						if (posicionReyNegro.getColumna() - 1 < 0 || posicionReyNegro.getFila() - 1 < 0) {
							puedeComerReyNegro[7] = true;
						} else {
							puedeComerReyNegro[7] = tablero[i][j].getPieza().puedeComer(new Coordenada(i, j),
									new Coordenada(posicionReyNegro.getFila() - 1, posicionReyNegro.getColumna() - 1),
									tablero[posicionReyNegro.getFila()][posicionReyNegro.getColumna()]);
						}
					}
				}
			}
		}
		boolean negrasAhogadas = true;
		for (boolean estaAhogado : puedeComerReyNegro) {
			negrasAhogadas = negrasAhogadas && estaAhogado;
		}
		if (negrasAhogadas) {
			System.out.println("Las negras tienen el rey ahogado, habeis quedado en tablas");
			return true;
		}
		return false;
	}

	public void coronacion() {
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[0][i].getPieza() instanceof Peon && tablero[0][i].getPieza().getColor() == Color.BLANCA) {
				tablero[0][i].setPieza(new Dama(Color.BLANCA));
				System.out.println("El peon blanco se ha coronado");
			}
		}
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[7][i].getPieza() instanceof Peon && tablero[7][i].getPieza().getColor() == Color.NEGRA) {
				tablero[7][i].setPieza(new Dama(Color.NEGRA));
				System.out.println("El peon negro se ha coronado");
			}
		}
	}

	public Coordenada seleccionarPieza() {
		System.out.println("Que pieza quieres mover?");
		while (true) {
			int seleccion=-1;
			String seleccionDePieza = Teclado.getTeclado().pedirEntrada();
			try {
				seleccion = Integer.parseInt(seleccionDePieza);
			} catch (NumberFormatException e) {
				System.err.println("Por favor introduce un numero");
			}
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					if (tablero[i][j].getPieza().getNumeroPieza() == seleccion) {
						return new Coordenada(i, j);
					}
				}
			}
			
			System.err.println("Esa pieza no se ha encontrado, por favor vuelva a seleccionar una pieza");
		}
		
	}

	public void imprimirTableroConNumeros(Jugador pJugador) {
		int cont = 1;
		System.out.println("\n\n ————————————————————————————————————————————————————————");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				Pieza p = tablero[i][j].getPieza();
				if(j==5 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				if(j==4 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				if(j==3 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				if(j==7 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				if(j==2 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				if (!(p instanceof NoPieza) && p.getColor() == pJugador.getColor()) {
					System.out.print("| ");
					tablero[i][j].imprimirPieza();
					System.out.print(cont);
					System.out.print(" ");
					if((int)cont/10==0) {
						System.out.print(" ");
					}
					
					p.setNumeroPieza(cont);
					cont++;
				} else {
					System.out.print("|  ");
					tablero[i][j].imprimirPieza();
					System.out.print("  ");
				}
			}
			System.out.println("|  ");
			System.out.println(" ————————————————————————————————————————————————————————");
		}
	}

	public boolean seleccionarMovimiento() {
		Coordenada posicionPiezaMover = this.seleccionarPieza();
		Pieza piezaMover = tablero[posicionPiezaMover.getFila()][posicionPiezaMover.getColumna()].getPieza();
		boolean[][] puedeMoverse = new boolean[8][8];
		System.out.println("Se va a mover esta pieza: " + piezaMover.visualizarPieza() + piezaMover.getNumeroPieza());
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				puedeMoverse[i][j] = piezaMover.puedeMover(
						new Coordenada(posicionPiezaMover.getFila(), posicionPiezaMover.getColumna()),
						new Coordenada(i, j), tablero[i][j]);
				if (!puedeMoverse[i][j]) {
					puedeMoverse[i][j] = piezaMover.puedeComer(
							new Coordenada(posicionPiezaMover.getFila(), posicionPiezaMover.getColumna()),
							new Coordenada(i, j), tablero[i][j]);
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
						tablero[posicionPiezaMover.getFila()][posicionPiezaMover.getColumna()]
								.setPieza(new NoPieza(Color.BLANCA));
						movido = true;
					}
				}
			}
			if (!movido) {
				seleccion = -1;
				System.err.println("Esa movimiento no es valido, por favor vuelva a seleccionar un movimiento");
			}
		}
		for(int i=0; i< tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j].getPieza().resetearNumeroPieza();
            }
        }
		return true;
	}

	private void imprimirMovimientosConNumeros(boolean[][] pPuedeMoverse) {
		int cont = 1;
		System.out.println("\n\n ————————————————————————————————————————————————————————");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				Pieza p = tablero[i][j].getPieza();
				if(j==5 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				if(j==4 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				if(j==3 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				if(j==7 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				if(j==2 && !(p instanceof NoPieza)) {
					System.out.print(" ");
				}
				p.resetearNumeroPieza();
				if (pPuedeMoverse[i][j]) {
					System.out.print(" | ");
					tablero[i][j].imprimirPieza();
					System.out.print(cont);
					System.out.print(" ");
					if((int)cont/10==0) {
						System.out.print(" ");
					}
					p.setNumeroPieza(cont);
					cont++;
				} else {
					System.out.print("|  ");
					tablero[i][j].imprimirPieza();
					System.out.print("  ");
				}
			}
			System.out.println("|  ");
			System.out.println(" ————————————————————————————————————————————————————————");
		}
	}

	public boolean casillaVacia(Coordenada pCoordenada) {
		return tablero[pCoordenada.getFila()][pCoordenada.getColumna()].getPieza() instanceof NoPieza;
	}
}
