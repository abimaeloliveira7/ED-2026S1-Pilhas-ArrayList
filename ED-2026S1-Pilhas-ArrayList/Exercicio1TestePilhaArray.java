import java.util.Scanner;

/**
 * Exercício 1 - Teste da PilhaArray
 * ---------------------------------
 * Este programa permite ao usuário interagir com a pilha implementada com vetor.
 * 
 * Funcionalidades do menu:
 * 1 - Empilhar item
 * 2 - Desempilhar item
 * 3 - Verificar se a pilha está vazia
 * 4 - Verificar se a pilha está cheia
 * 5 - Exibir pilha
 * 6 - Mostrar tamanho atual
 * 0 - Sair
 */
public class Exercicio1TestePilhaArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println(" EXERCÍCIO 1 - PILHA COM ARRAY (VETOR) ");
        System.out.println("==========================================");

        System.out.print("Informe a capacidade da pilha: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // limpa o ENTER pendente

        PilhaArray pilha = new PilhaArray(capacidade);

        int opcao;

        do {
            System.out.println("\n----------- MENU PILHA ARRAY -----------");
            System.out.println("1 - Empilhar item");
            System.out.println("2 - Desempilhar item");
            System.out.println("3 - Verificar se a pilha está vazia");
            System.out.println("4 - Verificar se a pilha está cheia");
            System.out.println("5 - Exibir pilha");
            System.out.println("6 - Mostrar tamanho atual");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consome ENTER

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para empilhar: ");
                    String valor = scanner.nextLine();
                    pilha.empilhar(valor);
                    break;

                case 2:
                    Object removido = pilha.desempilhar();
                    if (removido != null) {
                        System.out.println("Item removido do topo: " + removido);
                    }
                    break;

                case 3:
                    if (pilha.pilhaVazia()) {
                        System.out.println("A pilha está vazia.");
                    } else {
                        System.out.println("A pilha NÃO está vazia.");
                    }
                    break;

                case 4:
                    if (pilha.pilhaCheia()) {
                        System.out.println("A pilha está cheia.");
                    } else {
                        System.out.println("A pilha NÃO está cheia.");
                    }
                    break;

                case 5:
                    pilha.exibirPilha();
                    break;

                case 6:
                    System.out.println("Quantidade de elementos na pilha: " + pilha.tamanho());
                    break;

                case 0:
                    System.out.println("Encerrando o programa do Exercício 1...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}