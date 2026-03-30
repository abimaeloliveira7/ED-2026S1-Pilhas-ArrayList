import java.util.Scanner;
import java.util.Stack;

/**
 * Exercício 3 - Verificação de Palíndromo
 * ---------------------------------------
 * Este programa testa se uma palavra é palíndromo utilizando:
 * 
 * 1) PilhaArray
 * 2) PilhaLista
 * 3) Stack da API Java
 * 
 * O objetivo é mostrar que, embora a implementação interna seja diferente,
 * o comportamento lógico da pilha é o mesmo.
 */
public class Exercicio3Palindromo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n==========================================");
            System.out.println(" EXERCÍCIO 3 - TESTE DE PALÍNDROMO ");
            System.out.println("==========================================");
            System.out.println("1 - Testar palíndromo com PilhaArray");
            System.out.println("2 - Testar palíndromo com PilhaLista");
            System.out.println("3 - Testar palíndromo com Stack da API Java");
            System.out.println("4 - Testar nas três implementações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa ENTER

            switch (opcao) {
                case 1:
                    System.out.print("Digite uma palavra: ");
                    String palavra1 = scanner.nextLine();
                    testarResultado("PilhaArray", palavra1, ehPalindromoComPilhaArray(palavra1));
                    break;

                case 2:
                    System.out.print("Digite uma palavra: ");
                    String palavra2 = scanner.nextLine();
                    testarResultado("PilhaLista", palavra2, ehPalindromoComPilhaLista(palavra2));
                    break;

                case 3:
                    System.out.print("Digite uma palavra: ");
                    String palavra3 = scanner.nextLine();
                    testarResultado("Stack API Java", palavra3, ehPalindromoComStack(palavra3));
                    break;

                case 4:
                    System.out.print("Digite uma palavra: ");
                    String palavra4 = scanner.nextLine();

                    boolean r1 = ehPalindromoComPilhaArray(palavra4);
                    boolean r2 = ehPalindromoComPilhaLista(palavra4);
                    boolean r3 = ehPalindromoComStack(palavra4);

                    testarResultado("PilhaArray", palavra4, r1);
                    testarResultado("PilhaLista", palavra4, r2);
                    testarResultado("Stack API Java", palavra4, r3);

                    if (r1 == r2 && r2 == r3) {
                        System.out.println("As três implementações apresentaram o mesmo comportamento.");
                    } else {
                        System.out.println("As implementações apresentaram resultados diferentes. Revisar lógica.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa do Exercício 3...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    /**
     * Testa se uma palavra é palíndromo utilizando a classe PilhaArray.
     * 
     * Estratégia:
     * 1) Empilhar cada caractere da palavra
     * 2) Desempilhar tudo para formar a palavra invertida
     * 3) Comparar original com invertida
     * 
     * @param palavra string digitada pelo usuário
     * @return true se for palíndromo, false se não for
     */
    public static boolean ehPalindromoComPilhaArray(String palavra) {
        String texto = palavra.toLowerCase(); // padroniza para evitar diferença entre maiúscula/minúscula

        PilhaArray pilha = new PilhaArray(texto.length());

        // Empilha cada caractere
        for (int i = 0; i < texto.length(); i++) {
            pilha.empilhar(texto.charAt(i));
        }

        // Monta a string invertida desempilhando
        String invertida = "";
        while (!pilha.pilhaVazia()) {
            invertida += pilha.desempilhar();
        }

        System.out.println("Original : " + texto);
        System.out.println("Invertida: " + invertida);

        return texto.equals(invertida);
    }

    /**
     * Testa se uma palavra é palíndromo utilizando a classe PilhaLista.
     * 
     * @param palavra string digitada pelo usuário
     * @return true se for palíndromo
     */
    public static boolean ehPalindromoComPilhaLista(String palavra) {
        String texto = palavra.toLowerCase();

        PilhaLista pilha = new PilhaLista();

        for (int i = 0; i < texto.length(); i++) {
            pilha.empilhar(texto.charAt(i));
        }

        String invertida = "";
        while (!pilha.pilhaVazia()) {
            invertida += pilha.desempilhar();
        }

        System.out.println("Original : " + texto);
        System.out.println("Invertida: " + invertida);

        return texto.equals(invertida);
    }

    /**
     * Testa se uma palavra é palíndromo utilizando a classe Stack da API Java.
     * 
     * @param palavra string digitada pelo usuário
     * @return true se for palíndromo
     */
    public static boolean ehPalindromoComStack(String palavra) {
        String texto = palavra.toLowerCase();

        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < texto.length(); i++) {
            pilha.push(texto.charAt(i));
        }

        String invertida = "";
        while (!pilha.isEmpty()) {
            invertida += pilha.pop();
        }

        System.out.println("Original : " + texto);
        System.out.println("Invertida: " + invertida);

        return texto.equals(invertida);
    }

    /**
     * Método auxiliar apenas para exibir o resultado de forma organizada.
     * 
     * @param implementacao nome da implementação usada
     * @param palavra palavra analisada
     * @param resultado true ou false
     */
    public static void testarResultado(String implementacao, String palavra, boolean resultado) {
        System.out.println("\nImplementação utilizada: " + implementacao);
        System.out.println("Palavra analisada: " + palavra);

        if (resultado) {
            System.out.println("Resultado: É palíndromo.");
        } else {
            System.out.println("Resultado: NÃO é palíndromo.");
        }
    }
}