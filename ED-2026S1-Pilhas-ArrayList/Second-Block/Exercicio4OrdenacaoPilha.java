import java.util.Scanner;
import java.util.Stack;

/**
 * Exercício 4 - Ordenação de valores em uma pilha
 * ------------------------------------------------
 * Objetivo:
 * Ordenar os números armazenados em uma pilha em ordem crescente,
 * utilizando uma pilha auxiliar.
 *
 * Ideia do exercício:
 * - O usuário informa quantos números deseja inserir.
 * - Os números são empilhados na pilha principal.
 * - Utilizamos uma pilha auxiliar para reorganizar os elementos.
 * - No final, a pilha auxiliar fica ordenada.
 *
 * Conceito importante:
 * Stack em Java segue o modelo LIFO:
 * Last In, First Out (Último a entrar, primeiro a sair).
 *
 * Estratégia de ordenação:
 * 1. Retiramos um elemento da pilha principal.
 * 2. Enquanto o topo da pilha auxiliar for maior que esse elemento,
 *    devolvemos os elementos da pilha auxiliar para a pilha principal.
 * 3. Inserimos o elemento na pilha auxiliar.
 * 4. Repetimos até esvaziar a pilha principal.
 *
 * Assim, a pilha auxiliar vai sendo organizada em ordem crescente.
 */
public class Exercicio4OrdenacaoPilha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pilha principal, onde o usuário colocará os números
        Stack<Integer> pilhaPrincipal = new Stack<>();

        System.out.println("====================================================");
        System.out.println(" EXERCÍCIO 4 - ORDENAÇÃO DE PILHA COM PILHA AUXILIAR ");
        System.out.println("====================================================");

        // Solicita a quantidade de números que serão inseridos
        System.out.print("Quantos números você deseja empilhar? ");
        int quantidade = scanner.nextInt();

        // Lê os números informados pelo usuário e os empilha
        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Digite o " + i + "º número: ");
            int numero = scanner.nextInt();
            pilhaPrincipal.push(numero);
        }

        // Exibe a pilha original
        System.out.println("\nPilha original (topo à direita): " + pilhaPrincipal);

        // Chama o método que ordena a pilha
        Stack<Integer> pilhaOrdenada = ordenarPilhaCrescente(pilhaPrincipal);

        // Exibe o resultado final
        System.out.println("\nPilha ordenada em ordem crescente (base -> topo): " + pilhaOrdenada);

        // Exibe desempilhando para o aluno ver a ordem de saída
        System.out.println("\nDesempilhando os valores ordenados:");
        while (!pilhaOrdenada.isEmpty()) {
            System.out.println(pilhaOrdenada.pop());
        }

        scanner.close();
    }

    /**
     * Método responsável por ordenar a pilha em ordem crescente.
     *
     * @param pilha pilha original contendo números fora de ordem
     * @return pilha auxiliar contendo os elementos ordenados
     */
    public static Stack<Integer> ordenarPilhaCrescente(Stack<Integer> pilha) {

        // Pilha auxiliar que armazenará os elementos ordenados
        Stack<Integer> pilhaAuxiliar = new Stack<>();

        // Enquanto ainda houver elementos na pilha original...
        while (!pilha.isEmpty()) {

            // Remove o elemento do topo da pilha original
            int atual = pilha.pop();

            System.out.println("\nRetirando da pilha principal: " + atual);

            /**
             * Enquanto a pilha auxiliar não estiver vazia
             * E o topo da pilha auxiliar for maior que o valor atual,
             * devolvemos esses valores para a pilha principal.
             *
             * Isso "abre espaço" para colocar o número atual
             * na posição correta da pilha auxiliar.
             */
            while (!pilhaAuxiliar.isEmpty() && pilhaAuxiliar.peek() > atual) {
                int devolvido = pilhaAuxiliar.pop();
                pilha.push(devolvido);
                System.out.println("Devolvendo " + devolvido + " para a pilha principal");
            }

            // Agora sim colocamos o número atual na pilha auxiliar
            pilhaAuxiliar.push(atual);
            System.out.println("Empilhando " + atual + " na pilha auxiliar");

            // Exibição didática do estado atual das pilhas
            System.out.println("Pilha principal: " + pilha);
            System.out.println("Pilha auxiliar : " + pilhaAuxiliar);
        }

        return pilhaAuxiliar;
    }
}