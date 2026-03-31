package Pilha;

/**
 * Classe que implementa uma estrutura de dados do tipo Pilha utilizando um vetor de objetos (Object[]).
 * A pilha segue o conceito LIFO (Last In, First Out - último a entrar, primeiro a sair).
 */
public class pilhaArray {
	private Object[] pilha; // Vetor que armazena os elementos da pilha
	private int topo;       // Índice do topo da pilha
	
	/**
	 * Construtor que define o tamanho da pilha.
	 * @param tamanho Tamanho desejado para a pilha.
	 */
	public pilhaArray(int tamanho) {
		pilha = new Object[tamanho];
		topo = -1; // Inicialmente, a pilha está vazia.
	}
	
	/**
	 * Verifica se a pilha está vazia.
	 * @return true se estiver vazia, false caso contrário.
	 */
	public boolean estaVazia() {
		return topo == -1;
	}
	
	/**
	 * Verifica se a pilha está cheia.
	 * @return true se estiver cheia, false caso contrário.
	 */
	public boolean estaCheia() {
		return topo == pilha.length - 1;
	}
	
	/**
	 * Empilha (adiciona) um elemento na pilha.
	 * @param elemento Elemento a ser empilhado.
	 */
	public void empilhar(Object elemento) {
		if (estaCheia()) {
			System.err.println("Erro: A pilha está cheia! Não é possível adicionar mais elementos.");
		} else {
			pilha[++topo] = elemento; // Incrementa o topo e adiciona o elemento.
			System.out.println("Elemento " + elemento + " empilhado com sucesso.");
		}
	}
	
	/**
	 * Desempilha (remove) o elemento do topo da pilha.
	 * @return Elemento removido ou null caso a pilha esteja vazia.
	 */
	public Object desempilhar() {
		if (estaVazia()) {
			System.err.println("Erro: A pilha está vazia! Não há elementos para remover.");
			return null;
		} else {
			Object elementoRemovido = pilha[topo];
			pilha[topo--] = null; // Remove o elemento e decrementa o índice do topo.
			System.out.println("Elemento " + elementoRemovido + " desempilhado com sucesso.");
			return elementoRemovido;
		}
	}
	
	/**
	 * Obtém o elemento que está no topo da pilha sem removê-lo.
	 * @return Elemento do topo.
	 */
	public Object topo() {
		if (estaVazia()) {
			System.err.println("Erro: A pilha está vazia! Não há topo!");
			return null;
		}
		return pilha[topo];
	}
	
	/**
	 * Método principal que testa o funcionamento da pilha.
	 * @param args Argumentos da linha de comando (não utilizados).
	 * @throws InterruptedException Exceção lançada caso a execução da thread seja interrompida durante a pausa.
	 */
	public static void main(String[] args) throws InterruptedException {
		// "throws InterruptedException" indica que o método pode lançar uma exceção
		// caso a thread (fluxo de execução) seja interrompida durante métodos bloqueantes
		// como Thread.sleep().
		
		// Criando uma pilha com tamanho 5
		pilhaArray pilha = new pilhaArray(5);
		
		// Empilhando elementos na pilha
		pilha.empilhar(1);
		pilha.empilhar(2);
		pilha.empilhar(3);
		pilha.empilhar(4);
		pilha.empilhar(5);
		//pilha.empilhar(6); // Geraria mensagem de erro (pilha cheia)
		
		// Pausa a execução por 2 segundos
		Thread.sleep(2000);
		
		// Desempilhando elementos da pilha
		pilha.desempilhar();
		pilha.desempilhar();
		pilha.desempilhar();
		pilha.desempilhar();
		//pilha.desempilhar(); // Descomentado geraria erro (pilha vazia)
	}
}
