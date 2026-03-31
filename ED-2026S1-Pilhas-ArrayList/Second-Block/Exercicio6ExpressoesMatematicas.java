import java.util.Scanner;
import java.util.Stack;

/**
 * Exercício 6 - Expressões matemáticas, pilhas e recursão
 * -------------------------------------------------------
 * Este exercício, no material original, propõe reflexão e pesquisa sobre:
 * - resolução de expressões matemáticas
 * - notação infixa
 * - notação prefixa
 * - notação posfixa
 * - uso de pilhas
 * - possibilidade de uso de recursão
 *
 * Como solicitado, aqui transformamos essa ideia em um programa Java didático.
 *
 * O programa faz:
 * 1) Lê uma expressão infixa simples do usuário
 * 2) Converte de infixa para posfixa
 * 3) Avalia a expressão posfixa utilizando pilha
 * 4) Mostra um exemplo de uso de recursão com soma dos dígitos da expressão
 *
 * IMPORTANTE:
 * Para manter o foco didático, esta versão trabalha melhor com:
 * - números inteiros de um dígito
 * - operadores +, -, *, /
 * - parênteses ()
 *
 * Exemplo de entrada:
 * (2+3)*4
 *
 * Saída esperada:
 * Infixa : (2+3)*4
 * Posfixa: 23+4*
 * Resultado: 20
 */
public class Exercicio6ExpressoesMatematicas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n====================================================");
            System.out.println(" EXERCÍCIO 6 - EXPRESSÕES, PILHAS E RECURSÃO ");
            System.out.println("====================================================");
            System.out.println("1 - Converter expressão infixa para posfixa");
            System.out.println("2 - Avaliar expressão infixa");
            System.out.println("3 - Mostrar exemplo conceitual de notações");
            System.out.println("4 - Exemplo recursivo com soma dos dígitos da expressão");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa ENTER

            switch (opcao) {
                case 1:
                    System.out.print("Digite uma expressão infixa (ex.: (2+3)*4 ): ");
                    String infixa1 = scanner.nextLine().replace(" ", "");
                    String posfixa1 = infixaParaPosfixa(infixa1);
                    System.out.println("Expressão infixa : " + infixa1);
                    System.out.println("Expressão posfixa: " + posfixa1);
                    break;

                case 2:
                    System.out.print("Digite uma expressão infixa (ex.: (2+3)*4 ): ");
                    String infixa2 = scanner.nextLine().replace(" ", "");
                    String posfixa2 = infixaParaPosfixa(infixa2);
                    int resultado = avaliarPosfixa(posfixa2);

                    System.out.println("Expressão infixa : " + infixa2);
                    System.out.println("Expressão posfixa: " + posfixa2);
                    System.out.println("Resultado final  : " + resultado);
                    break;

                case 3:
                    mostrarExemploNotacoes();
                    break;

                case 4:
                    System.out.print("Digite uma expressão contendo dígitos (ex.: (2+3)*4 ): ");
                    String texto = scanner.nextLine();
                    int soma = somarDigitosRecursivamente(texto, 0);

                    System.out.println("Texto analisado          : " + texto);
                    System.out.println("Soma recursiva dos dígitos: " + soma);
                    break;

                case 0:
                    System.out.println("Encerrando o Exercício 6...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    /**
     * Método que converte uma expressão infixa para posfixa.
     *
     * Exemplo:
     * Infixa : (2+3)*4
     * Posfixa: 23+4*
     *
     * Estratégia:
     * - números vão direto para a saída
     * - '(' entra na pilha
     * - ')' desempilha até encontrar '('
     * - operadores respeitam precedência
     *
     * @param infixa expressão infixa
     * @return expressão convertida para posfixa
     */
    public static String infixaParaPosfixa(String infixa) {
        Stack<Character> pilha = new Stack<>();
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < infixa.length(); i++) {
            char c = infixa.charAt(i);

            // Se for dígito, vai direto para a saída
            if (Character.isDigit(c)) {
                saida.append(c);
            }

            // Se for abertura de parênteses, empilha
            else if (c == '(') {
                pilha.push(c);
            }

            // Se for fechamento, desempilha até encontrar '('
            else if (c == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(') {
                    saida.append(pilha.pop());
                }

                // Remove o '(' da pilha
                if (!pilha.isEmpty() && pilha.peek() == '(') {
                    pilha.pop();
                }
            }

            // Se for operador
            else if (ehOperador(c)) {
                while (!pilha.isEmpty()
                        && pilha.peek() != '('
                        && precedencia(pilha.peek()) >= precedencia(c)) {
                    saida.append(pilha.pop());
                }
                pilha.push(c);
            }
        }

        // Desempilha o restante
        while (!pilha.isEmpty()) {
            saida.append(pilha.pop());
        }

        return saida.toString();
    }

    /**
     * Avalia uma expressão posfixa utilizando pilha.
     *
     * Exemplo:
     * Posfixa: 23+4*
     * Leitura:
     * 2  -> empilha
     * 3  -> empilha
     * +  -> desempilha 3 e 2, calcula 2+3, empilha 5
     * 4  -> empilha
     * *  -> desempilha 4 e 5, calcula 5*4, empilha 20
     *
     * @param posfixa expressão posfixa
     * @return resultado inteiro da expressão
     */
    public static int avaliarPosfixa(String posfixa) {
        Stack<Integer> pilha = new Stack<>();

        for (int i = 0; i < posfixa.length(); i++) {
            char c = posfixa.charAt(i);

            // Se for número, converte e empilha
            if (Character.isDigit(c)) {
                pilha.push(Character.getNumericValue(c));
            }

            // Se for operador, desempilha dois operandos
            else if (ehOperador(c)) {
                int b = pilha.pop(); // segundo operando
                int a = pilha.pop(); // primeiro operando

                int resultado = aplicarOperacao(a, b, c);
                pilha.push(resultado);
            }
        }

        // No final, sobra apenas o resultado
        return pilha.pop();
    }

    /**
     * Verifica se o caractere é um operador matemático básico.
     */
    public static boolean ehOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Retorna a precedência do operador.
     * Quanto maior o valor, maior a prioridade.
     */
    public static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            default:
                return 0;
        }
    }

    /**
     * Aplica a operação matemática.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @param operador operador matemático
     * @return resultado da operação
     */
    public static int aplicarOperacao(int a, int b, char operador) {
        switch (operador) {
            case '+':
                return a + b;

            case '-':
                return a - b;

            case '*':
                return a * b;

            case '/':
                return a / b;

            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }

    /**
     * Mostra um exemplo conceitual das notações.
     *
     * Expressão escolhida:
     * (A+B)*C
     */
    public static void mostrarExemploNotacoes() {
        System.out.println("\n================ EXEMPLO DE NOTAÇÕES ================");
        System.out.println("Expressão original (INFIXA) : (A+B)*C");
        System.out.println("Notação PREFIXA             : *+ABC");
        System.out.println("Notação POSFIXA             : AB+C*");
        System.out.println("\nResumo:");
        System.out.println("- Infixa : operador fica no meio dos operandos");
        System.out.println("- Prefixa: operador fica antes dos operandos");
        System.out.println("- Posfixa: operador fica depois dos operandos");
        System.out.println("=====================================================");
    }

    /**
     * Exemplo recursivo:
     * Soma todos os dígitos presentes em um texto.
     *
     * Exemplo:
     * texto = "(2+3)*4"
     * soma = 2 + 3 + 4 = 9
     *
     * Esse método não avalia a expressão matemática.
     * Ele existe para demonstrar recursão em paralelo ao tema do exercício.
     *
     * @param texto texto a ser analisado
     * @param indice posição atual da leitura
     * @return soma dos dígitos encontrados
     */
    public static int somarDigitosRecursivamente(String texto, int indice) {

        // Caso base da recursão:
        // se chegamos ao final da string, encerramos
        if (indice >= texto.length()) {
            return 0;
        }

        char c = texto.charAt(indice);

        // Se o caractere atual for dígito, soma seu valor
        if (Character.isDigit(c)) {
            return Character.getNumericValue(c) + somarDigitosRecursivamente(texto, indice + 1);
        }

        // Se não for dígito, apenas segue para o próximo
        return somarDigitosRecursivamente(texto, indice + 1);
    }
}