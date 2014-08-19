package velha;

import java.util.Scanner;

public class Jogada {
	private Tabuleiro tabuleiro;
	private Jogador[] jogadores;
	private Scanner scanner;
	private int rodada = 0;
	private int atual = 0;
	
	public Jogada(Scanner scanner, Tabuleiro tabuleiro, Jogador[] jogadores) {
		this.scanner = scanner;
		this.tabuleiro = tabuleiro;
		this.jogadores = jogadores;		
	}
	
	
	public void aguardaJogada() {
		tabuleiro.mostrarTabuleiro();
				
		System.out.println("Jogador "+ (atual+1) + "("+jogadores[atual].getSimbolo()+") informe sua posição de jogada:");

		boolean validacao = false;
		if (scanner.hasNextInt()) {			
			validacao = tabuleiro.marcarPosicao(scanner.nextInt(),	jogadores[atual].getSimbolo());
			rodada++;
		}
		if (validacao) {
			if (atual == 0) {
				atual = 1;
			} else {
				atual = 0;
			}
			validaJogada();			
			aguardaJogada();
		} else {
			// inválido
		}		
	}
	
	/**
	 * Método que valida a jogada, testando as colunas, linhas e diagonais
	 * São feitas chamadas ao método testaJogada para que este defina quem foi o vencedor ou empate
	 */
	private void validaJogada() {
		int cont_x = 0;
		int cont_y = 0;
		
		// LINHAS		
		for (int i=0;i<3;i++) {
			cont_x=0; cont_y = 0;
			for (int j=0;j<3;j++) {								
				if (tabuleiro.getTabuleiro(i,j) == 'X') {
					cont_x++;
				} else if (tabuleiro.getTabuleiro(i,j) == 'O') {
					cont_y++;
				}
				testaJogada(cont_x,cont_y);				
			}
		}
		
		// COLUNAS		
		for (int i=0;i<3;i++) {
			cont_x=0; cont_y = 0;
			for (int j=0;j<3;j++) {
				if (tabuleiro.getTabuleiro(j,i) == 'X') {
					cont_x++;
				} else if (tabuleiro.getTabuleiro(j,i) == 'O') {
					cont_y++;
				}
				testaJogada(cont_x,cont_y);
			}
		}
		
		// DIAGONAL \
		cont_x=0; cont_y = 0;
		for (int i=0;i<3;i++) {
			if (tabuleiro.getTabuleiro(i,i) == 'X') {
				cont_x++;
			} else if (tabuleiro.getTabuleiro(i,i) == 'O') {
				cont_y++;
			}			
		}
		
		testaJogada(cont_x,cont_y);
		
		// DIAGONAL /
		cont_x=0; cont_y = 0;
		for (int i=2;i>=0;i--) {
			if (tabuleiro.getTabuleiro(i,i) == 'X') {
				cont_x++;
			} else if (tabuleiro.getTabuleiro(i,i) == 'O') {
				cont_y++;
			}			
		}
		
		testaJogada(cont_x,cont_y);
	}
	
	private void testaJogada(int cont_x, int cont_y) {
		if (cont_x == 3) {
			System.out.println("Jogador X ganhou");			
			System.exit(1);
		}
		
		if (cont_y == 3) {
			System.out.println("Jogador O ganhou");
			System.exit(1);
		}
		
		if (rodada == 9) {
			System.out.println("EMPATE!!");			
			System.exit(1);
		}
	}

}