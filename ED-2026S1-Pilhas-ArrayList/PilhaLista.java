import java.util.ArrayList;
import java.util.List;

/**
 * Classe PilhaLista
 * -----------------
 * Esta classe implementa uma pilha utilizando ArrayList.
 * 
 * Diferença em relação à PilhaArray:
 * - Aqui não usamos vetor fixo.
 * - A lista cresce dinamicamente.
 * - Não precisamos controlar "topo" manualmente com variável separada,
 *   pois o topo sempre será o último elemento da lista.
 * 
 * Mesmo assim, o comportamento da pilha continua o mesmo:
 * LIFO (Last In, First Out).
 */
public class PilhaLista {

    // Lista que armazenará os elementos da pilha
    private List<Object> itens;

    /**
     * Construtor da pilha com lista.
     * Inicializa a lista vazia.
     */
    public PilhaLista() {
        itens = new ArrayList<>();
    }

    /**
     * Empilha um item no final da lista.
     * Em uma pilha, o final da lista representa o topo.
     * 
     * @param item elemento a ser empilhado
     */
    public void empilhar(Object item) {
        itens.add(item);
        System.out.println("Item empilhado com sucesso: " + item);
    }

    /**
     * Remove o item do topo da pilha.
     * Como o topo é o último elemento da lista,
     * removemos o item da posição size() - 1.
     * 
     * @return item removido, ou null se a pilha estiver vazia
     */
    public Object desempilhar() {
        if (pilhaVazia()) {
            System.out.println("Não foi possível desempilhar. A pilha está vazia.");
            return null;
        } else {
            int indiceTopo = itens.size() - 1;
            return itens.remove(indiceTopo);
        }
    }

    /**
     * Verifica se a pilha está vazia.
     * 
     * @return true se a lista estiver vazia, senão false
     */
    public boolean pilhaVazia() {
        return itens.isEmpty();
    }

    /**
     * Verifica se a pilha está cheia.
     * 
     * Como ArrayList é dinâmica, normalmente consideramos
     * que ela não fica "cheia" no contexto didático.
     * 
     * @return false
     */
    public boolean pilhaCheia() {
        return false;
    }

    /**
     * Retorna o tamanho atual da pilha.
     * 
     * @return quantidade de elementos armazenados
     */
    public int tamanho() {
        return itens.size();
    }

    /**
     * Exibe os elementos da pilha do topo para a base.
     */
    public void exibirPilha() {
        if (pilhaVazia()) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.println("Elementos da pilha (do topo para a base):");
            for (int i = itens.size() - 1; i >= 0; i--) {
                System.out.println("[" + i + "] = " + itens.get(i));
            }
        }
    }
}