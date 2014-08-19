package velha;

import java.util.Scanner;

public class JogoDaVelha {
	
	private Scanner scanner = new Scanner(System.in);
	private Jogador[] jogadores = new Jogador[]{new Jogador(), new Jogador()};	

	public JogoDaVelha() {
		// Inicializa o jogo no próprio construtor
		System.out.println("Bem-vindo ao jogo da velha!");
		
		Jogada jogada = new Jogada(scanner, new Tabuleiro(), getJogadores());
		jogada.aguardaJogada();
	}
	
	private Jogador[] getJogadores() {
		System.out.println("Jogador 1 inicia o jogo!");		
		System.out.println("Informe o símbolo [X ou O]:");
		if (scanner.hasNext()) {			
			char escolha = scanner.next().charAt(0);
			switch (escolha) {
			case 'X': {
				jogadores[0].setSimbolo('X');
				jogadores[1].setSimbolo('O');
				break;
			}
			case 'O': {
				jogadores[0].setSimbolo('O');
				jogadores[1].setSimbolo('X');
				break;
			}
			default: {
				System.err.println("Opção Inválida");
				}
			}
		}
		System.out.println("O Jogador 1 escolheu o símbolo: " + jogadores[0].getSimbolo());
		
		return jogadores;
	}
		
	public static void main(String[] args) {
		// Cria um objeto da classe JogoDaVelha, assim o jogo é inicializado
		JogoDaVelha jogo = new JogoDaVelha();		
	}
}
