package Pilha;

import java.util.ArrayList;
import java.util.Scanner;


public class PilhaArrayList<T> {
	
	// Atributo que armazena os elementos da pilha utilizando ArrayList
	private ArrayList<T> elementos;
	
	// Construtor> inicializa a pilha com uma lista vazia
	public PilhaArrayList() {
		elementos = new ArrayList<>(); // Criando uma lista dinâmica para armazenar os elementos da pilha		
	}
	
	// Método que verifica se a pilha está vazia
	public boolean estaVazia() {
		return elementos.isEmpty(); // Retorna True se a lis não contiver elementos
	}
	
	// Método para empilhar (adicionar) um elemento no topo da pilha
	public void empilhar(T item) {
		elementos.add(item); // Adiciona o item no final da lista (equivalente ao topo da pilha)
	}
	
	// Método para desempilhar (Remover) o elemento do topo da pilha
	public T desempilhar() {
		if (estaVazia()) {
			System.err.println("⚠️ Erro: A pilha está vazia! Não há elementos para remover.");
			return null;
		}
		return elementos.remove(elementos.size() - 1); // Remove e retorna o último elemento da lista (topo da pilha)
	}
	
	// Método para visualizar o elemento do topo sem removê-lo
	public T topo() {
		if (estaVazia()) {
			System.err.println("⚠️ Erro: A pilha está vazia! Não há elementos no topo.");
			return null;
		}
		return elementos.get(elementos.size() - 1); // Remove e retorna o último elemento da lista (topo da pilha)
	}
	
	// Método que retorno o tamanho da pilha
	public int tamanho() {
		return elementos.size(); // Retorna a quantidade de elementos dentro da pilha
	}
	
	// Método que exibe todos os elementos da pilha (de cima para baixo)
	public void exibirPilha() {
		if (estaVazia()) {
			System.out.println("A pilha esta vazia!");
			return;
		}
		System.out.println("\n📌 Elementos da pilha (do topo para a base):");
		for (int i = elementos.size() -1; i >= 0; i--) {
			System.out.println("| " + elementos.get(i) + " |");
		}
		System.out.println("=====");
	}
	
	// Método interativo para testar o funcionamento da pilha
	public static void main(String[] args) {
		PilhaArrayList<String> pilha = new PilhaArrayList<>(); // Cria a pilha de Strings
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		
		do {
			// Menu Interativo
			System.out.println("\n====== MENU PILHA ======");
			System.out.println("1 - Empilhar Elemento");
			System.out.println("2 - Desempilhar Elemento");
			System.out.println("3 - Visualizar Topo");
			System.out.println("4 - Ver Tamanho da Pilha");
			System.out.println("5 - Exibir Pilha");
			System.out.println("0 - Sair");
			System.out.println("Escolha uma Opção: ");
			
			if (!scanner.hasNextInt()) {
				System.out.println("⚠️ Entrada inváçlida! Digite um número.");
				scanner.next(); // Descarta entrada inválida
				continue;
			}
			// 18/03/2025
			opcao = scanner.nextInt();
			scanner.nextLine(); // Consome a quebra linha
			
			// SWITCH: Avalia a opção escolhida e direciona para a ação correspondente
			switch(opcao) {
				// CASE: Opção para empilhar cada elemento
			case 1:
				System.out.println("Digite o elemento a ser empilhado: ");
				String elemento = scanner.nextLine();
				pilha.empilhar(elemento);
				System.out.println("Elemeto " + elemento + " empilhado com sucesso!");
				break; // BREAK: Encerra o case atual e evita execução subsequente	
				
				// CASE 2:  Opção para desempilhar o elemento
			case 2:
				String desempilhado = pilha.desempilhar();
				if (desempilhado != null) {
					System.out.println("Elemento removido: " + desempilhado);
				}
				break;
				
				// CASE 3:  Visualizar o elemento do topo da pilha
			case 3:
				String topo = pilha.topo();
				if (topo != null) {
					System.out.println("Topo da pilha: " + topo);
				}
				break;
				
				// CASE 4: Exibir o tamanho da pilha
			case 4:
				System.out.println("Tamanho da pilha: " + pilha.tamanho());
				break;
				
				//CASE 5: Exibir todos os elementos da pilha
			case 5:
				pilha.exibirPilha();
				break;
				
				// CASE DEFAULT: Caso nenhuma opção seja válida
			default:
				if (opcao != 0)
					System.err.println("Opção inválida! Tente novamente.");
				break;				
			}
			
		} while (opcao != 0);
		
		scanner.close(); // Fecha o scanner para evitar consumo de recursos		

	}

}
