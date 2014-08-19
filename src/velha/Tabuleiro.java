package velha;

public class Tabuleiro {
	private int[][] tabuleiro = new int[3][3];
	
	public Tabuleiro () {
		// Inicializa tabuleiro
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = -1;
			}
		}
	}

	public void mostrarTabuleiro() {
		int posicao = 0;
		System.out.println("=======");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("|");

				if (tabuleiro[i][j] != -1) {
					if (tabuleiro[i][j] == 'O') {
						System.out.print('O');
					} else {
						System.out.print('X');
					}
					++posicao;
				} else {
					System.out.print(++posicao);
				}

			}

			System.out.println("|");
		}
		System.out.println("=======");
	}

	public boolean marcarPosicao(int posicao, char simb) {
		switch (posicao) {
		case 1: {
			if (tabuleiro[0][0] == -1) {
				tabuleiro[0][0] = simb;
				return true;
			}
			break;
		}
		case 2: {
			if (tabuleiro[0][1] == -1) {
				tabuleiro[0][1] = simb;
				return true;
			}
			break;
		}
		case 3: {
			if (tabuleiro[0][2] == -1) {
				tabuleiro[0][2] = simb;
				return true;
			}
			break;
		}
		case 4: {
			if (tabuleiro[1][0] == -1) {
				tabuleiro[1][0] = simb;
				return true;
			}
			break;
		}
		case 5: {
			if (tabuleiro[1][1] == -1) {
				tabuleiro[1][1] = simb;
				return true;
			}
			break;
		}
		case 6: {
			if (tabuleiro[1][2] == -1) {
				tabuleiro[1][2] = simb;
				return true;
			}
			break;
		}
		case 7: {
			if (tabuleiro[2][0] == -1) {
				tabuleiro[2][0] = simb;
				return true;
			}
			break;
		}
		case 8: {
			if (tabuleiro[2][1] == -1) {
				tabuleiro[2][1] = simb;
				return true;
			}
			break;
		}
		case 9: {
			if (tabuleiro[2][2] == -1) {
				tabuleiro[2][2] = simb;
				return true;
			}
			break;
		}
		default: {
			System.out.println("Posição inválida");
			return false;
		}

		}
		mostrarTabuleiro();
		return false;
	}
	
	public int getTabuleiro(int i, int j) {
		return tabuleiro[i][j];
	}
	
	public void setTabuleiro(int i, int j, int valor) {
		tabuleiro[i][j] = valor;
	}

}
