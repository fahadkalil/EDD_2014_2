package vetores;

public class Vetor {
	private int vet[];
	private int quantidade = 0;
	
	public Vetor() {
		vet = new int[5];
	}
	
	public Vetor(int tamInicial) {
		vet = new int[tamInicial];
	}	

	public void adicionar(int valor) {
		// Caso o vetor esteja cheio
		if (quantidade == vet.length) {
			// Cria novo vetor com dobro do tamanho
			int novo[] = new int[2 * vet.length];
			
			// Copia os valores do vetor antigo para o novo
			for (int i=0; i<vet.length;i++) {
				novo[i] = vet[i];
			}
			
			novo[quantidade++] = valor;			
			vet = novo;			
		} 
		// Se ainda temos espaço
		else {
			vet[quantidade++] = valor;			
		}
	}
	
	public void substitui(int indice, int novoValor) {
		
	}
	
	public void imprimir() {
		for (int i = 0; i < quantidade; i++) {
			System.out.println(vet[i]);
		}
	}
	
	public static void main(String[] args) {
		Vetor v = new Vetor();
		v.adicionar(546);
		v.adicionar(333);
		v.adicionar(42423);
		v.adicionar(432432);
		v.adicionar(42342);
		v.adicionar(1111111);
				
		v.imprimir();		
	}
}