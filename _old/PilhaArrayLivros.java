package Pilha;

import java.util.Scanner;

public class PilhaArrayLivros {

    private String[] livros; // Armazena os livros em um array fixo
    private int topo; // Índice do livro que está no topo da pilha

    // Construtor que define a capacidade da pilha de livros
    public PilhaArrayLivros(int capacidade) {
        livros = new String[capacidade];
        topo = -1; // -1 indica que a pilha está vazia e significa que o próximo livro a ser adicionado estará na posição 0
    }

    // Verifica se a pilha está vazia
    public boolean estaVazia() {
        return topo == -1;
    }

    // Verifica se a pilha está cheia
    public boolean estaCheia() {
        return topo == livros.length - 1;
    }

    // Retorna quantos livros há na pilha
    public int tamanho() {
        return topo + 1;
    }

    // Adiciona um novo livro no topo da pilha
    public void empilharLivro(String tituloLivro) {
        if (estaCheia()) {
            System.out.println("⚠ A pilha de livros está cheia. Será preciso terminar uma leitura antes de adicionar outra.");
            return;
        }

        livros[++topo] = tituloLivro;
        System.out.println("✅ Livro '" + tituloLivro + "' adicionado ao topo da pilha de estudos.");
    }

    // Remove o livro do topo da pilha
    public String desempilharLivro() { // string de retorno para mostrar qual livro foi removido, ou null se a pilha estiver vazia
        if (estaVazia()) {
            System.out.println("⚠ A pilha de livros está vazia. Nenhum livro para remover.");
            return null; // null indica que não há livro para remover, o que é diferente de uma string vazia "" que poderia ser um título válido.
        }

        String livroRemovido = livros[topo]; // Armazena o título do livro que está sendo removido para exibir a mensagem
        livros[topo--] = null; // Remove a referência ao livro do array e move o topo para baixo
        System.out.println("✅ Livro '" + livroRemovido + "' removido da pilha de estudos.");
        return livroRemovido;
    }

    // Consulta o livro que está no topo, sem remover
    public String consultarTopo() {
        if (estaVazia()) {
            System.out.println("⚠ A pilha está vazia. Não existe livro no topo.");
            return null;
        }

        return livros[topo];
    }

    // Exibe os livros do topo para a base
    public void exibirPilhaLivros() {
        if (estaVazia()) {
            System.out.println("⚠ Nenhum livro cadastrado na pilha de estudos.");
            return; // Se a pilha estiver vazia, não há livros para exibir, então retornamos imediatamente após mostrar a mensagem de aviso.
        }

        System.out.println("\n📚 Pilha de livros técnicos (topo -> base):");
        for (int i = topo; i >= 0; i--) {
            System.out.println("| " + livros[i] + " |");
        }
        System.out.println("Capacidade total: " + livros.length + " | Livros na pilha: " + tamanho());
    }

    private static int lerCapacidadeValida(Scanner scanner) {
        while (true) { // Loop infinito até o usuário fornecer uma entrada válida
            System.out.print("Quantos livros técnicos você deseja organizar nessa pilha? ");
            if (scanner.hasNextInt()) {
                int capacidade = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner após ler o inteiro

                if (capacidade > 0) { // Verifica se a capacidade é um número inteiro positivo
                    return capacidade;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("⚠ Entrada inválida. Digite um número inteiro maior que zero.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacidade = lerCapacidadeValida(scanner);
        PilhaArrayLivros pilhaLivros = new PilhaArrayLivros(capacidade);
        int opcao = -1;

        do {
            System.out.println("\n======= PILHA ARRAY LIVROS =======");
            System.out.println("Contexto: um programador organiza seus livros técnicos para estudar.");
            System.out.println("1 - Adicionar livro na pilha");
            System.out.println("2 - Remover livro do topo");
            System.out.println("3 - Consultar livro do topo");
            System.out.println("4 - Exibir pilha de livros");
            System.out.println("5 - Mostrar quantidade de livros");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("⚠ Opção inválida. Digite um número do menu.");
                scanner.nextLine();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (pilhaLivros.estaCheia()) {
                        System.out.println("⚠ Sua pilha de estudos atingiu o limite do array. Considere terminar um livro antes de adicionar outro.");
                    } else {
                        System.out.print("Digite o título do livro técnico: ");
                        String tituloLivro = scanner.nextLine();
                        pilhaLivros.empilharLivro(tituloLivro);
                    }
                    break;

                case 2:
                    pilhaLivros.desempilharLivro();
                    break;

                case 3:
                    String topo = pilhaLivros.consultarTopo();
                    if (topo != null) {
                        System.out.println("📌 Próximo livro a ser estudado: " + topo);
                    }
                    break;

                case 4:
                    pilhaLivros.exibirPilhaLivros();
                    break;

                case 5:
                    System.out.println("📏 Quantidade atual de livros na pilha: " + pilhaLivros.tamanho());
                    break;

                case 0:
                    System.out.println("Encerrando a organização da pilha de estudos. Bons códigos e boas leituras!");
                    break;

                default:
                    System.out.println("⚠ Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}