import java.util.Scanner;
import java.util.Stack;

/**
 * Exercício 5 - Validação de balanceamento
 * ----------------------------------------
 * Objetivo:
 * Criar um método chamado validaBalanceamento que recebe uma String
 * e verifica se ela possui símbolos balanceados.
 *
 * Símbolos considerados:
 * - Parênteses: ()
 * - Colchetes: []
 * - Chaves: {}
 *
 * Estratégia pedida no exercício:
 * Quando encontramos um símbolo de abertura:
 * - '(' empilha ')'
 * - '[' empilha ']'
 * - '{' empilha '}'
 *
 * Quando encontramos um símbolo de fechamento:
 * - verificamos se ele é igual ao topo da pilha
 * - se não for, a expressão está desbalanceada
 *
 * Ao final:
 * - se a pilha estiver vazia, a expressão está balanceada
 * - se a pilha ainda tiver elementos, está desbalanceada
 */
public class Exercicio5Balanceamento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================================");
        System.out.println(" EXERCÍCIO 5 - VALIDAÇÃO DE SÍMBOLOS BALANCEADOS ");
        System.out.println("====================================================");

        System.out.print("Digite uma expressão contendo (), [] e {}: ");
        String expressao = scanner.nextLine();

        boolean resultado = validaBalanceamento(expressao);

        System.out.println("\nExpressão digitada: " + expressao);

        if (resultado) {
            System.out.println("Resultado: Expressão BALANCEADA.");
        } else {
            System.out.println("Resultado: Expressão DESBALANCEADA.");
        }

        scanner.close();
    }

    /**
     * Método que valida o balanceamento dos símbolos.
     *
     * @param texto expressão a ser analisada
     * @return true se estiver balanceada, false caso contrário
     */
    public static boolean validaBalanceamento(String texto) {

        // Pilha que armazenará os fechamentos esperados
        Stack<Character> pilha = new Stack<>();

        // Percorre a String caractere por caractere
        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            /**
             * Se o caractere for um símbolo de abertura,
             * empilhamos o símbolo de fechamento correspondente.
             */
            if (caractere == '(') {
                pilha.push(')');
                System.out.println("Encontrou '('. Empilhando ')' ");
            } else if (caractere == '[') {
                pilha.push(']');
                System.out.println("Encontrou '['. Empilhando ']' ");
            } else if (caractere == '{') {
                pilha.push('}');
                System.out.println("Encontrou '{'. Empilhando '}' ");
            }

            /**
             * Se o caractere for um símbolo de fechamento,
             * precisamos conferir se ele bate com o topo da pilha.
             */
            else if (caractere == ')' || caractere == ']' || caractere == '}') {

                // Se a pilha estiver vazia, já deu ruim
                if (pilha.isEmpty()) {
                    System.out.println("Erro: encontrou '" + caractere + "' mas a pilha está vazia.");
                    return false;
                }

                // Consulta o topo da pilha
                char esperado = pilha.peek();

                // Se o símbolo não for o esperado, retorna false
                if (caractere != esperado) {
                    System.out.println("Erro: encontrou '" + caractere + "', mas o esperado era '" + esperado + "'.");
                    return false;
                }

                // Se for igual, remove da pilha
                pilha.pop();
                System.out.println("Encontrou '" + caractere + "' corretamente. Desempilhando.");
            }

            /**
             * Outros caracteres são ignorados.
             * Isso é útil para permitir expressões com letras, números e operadores.
             */
        }

        /**
         * Ao final:
         * - se a pilha estiver vazia, tudo fechou corretamente
         * - caso contrário, faltaram fechamentos
         */
        if (pilha.isEmpty()) {
            return true;
        } else {
            System.out.println("Ao final da leitura, ainda restaram símbolos esperados na pilha: " + pilha);
            return false;
        }
    }
}