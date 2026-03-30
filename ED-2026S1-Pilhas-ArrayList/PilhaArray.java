/**
 * Classe PilhaArray
 * -----------------
 * Esta classe implementa uma pilha utilizando um vetor de Object.
 * 
 * Ideia principal:
 * - A pilha armazena elementos em sequência.
 * - O último elemento inserido será o primeiro a ser removido (LIFO).
 * - Um vetor possui tamanho fixo, então precisamos controlar:
 *      1) se ainda há espaço para empilhar
 *      2) se existem elementos para desempilhar
 * 
 * A variável "topo" indica a posição do último elemento inserido.
 * Quando a pilha está vazia, topo = -1.
 */
public class PilhaArray {

    // Vetor que armazenará os itens da pilha
    private Object[] elementos;

    // Variável que controla a posição do topo da pilha
    private int topo;

    /**
     * Construtor da pilha.
     * Recebe como parâmetro o tamanho máximo da pilha.
     * 
     * @param capacidade quantidade máxima de elementos que o vetor poderá armazenar
     */
    public PilhaArray(int capacidade) {
        elementos = new Object[capacidade];
        topo = -1; // Quando não há elementos, topo começa em -1
    }

    /**
     * Método para empilhar um novo item.
     * 
     * Lógica:
     * - Primeiro verifica se a pilha está cheia.
     * - Se não estiver, incrementa o topo e guarda o item nessa posição.
     * 
     * @param item elemento a ser inserido na pilha
     */
    public void empilhar(Object item) {
        if (pilhaCheia()) {
            System.out.println("Não foi possível empilhar. A pilha está cheia.");
        } else {
            topo++; // avança o topo para a próxima posição disponível
            elementos[topo] = item; // armazena o item no topo
            System.out.println("Item empilhado com sucesso: " + item);
        }
    }

    /**
     * Método para desempilhar o item do topo.
     * 
     * Lógica:
     * - Primeiro verifica se a pilha está vazia.
     * - Se não estiver, captura o elemento do topo,
     *   limpa a posição opcionalmente e decrementa o topo.
     * 
     * @return o item removido do topo, ou null se a pilha estiver vazia
     */
    public Object desempilhar() {
        if (pilhaVazia()) {
            System.out.println("Não foi possível desempilhar. A pilha está vazia.");
            return null;
        } else {
            Object itemRemovido = elementos[topo]; // guarda o item do topo
            elementos[topo] = null; // limpa a posição do vetor (boa prática)
            topo--; // recua o topo
            return itemRemovido;
        }
    }

    /**
     * Verifica se a pilha está vazia.
     * 
     * @return true se topo == -1, senão false
     */
    public boolean pilhaVazia() {
        return topo == -1;
    }

    /**
     * Verifica se a pilha está cheia.
     * 
     * Como o vetor vai de 0 até length - 1,
     * a pilha estará cheia quando topo estiver na última posição.
     * 
     * @return true se a pilha estiver cheia, senão false
     */
    public boolean pilhaCheia() {
        return topo == elementos.length - 1;
    }

    /**
     * Retorna a quantidade de elementos atualmente armazenados na pilha.
     * 
     * Exemplo:
     * topo = -1 => tamanho 0
     * topo = 0  => tamanho 1
     * topo = 1  => tamanho 2
     * 
     * @return quantidade de elementos na pilha
     */
    public int tamanho() {
        return topo + 1;
    }

    /**
     * Exibe os elementos atuais da pilha.
     * 
     * Mostra do topo até a base para facilitar a visualização
     * do comportamento LIFO.
     */
    public void exibirPilha() {
        if (pilhaVazia()) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.println("Elementos da pilha (do topo para a base):");
            for (int i = topo; i >= 0; i--) {
                System.out.println("[" + i + "] = " + elementos[i]);
            }
        }
    }
}