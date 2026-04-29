import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	public void imprimir(){
		Celula<E> aux = topo;
			while(aux != fundo){
				System.out.println(aux.getItem());
				aux = aux.getProximo();
			}
	}

	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		Celula<E> aux = topo;

		// Verificando a exceção: numItens é negativo
		if (numItens < 0) {
            throw new IllegalArgumentException("O número de itens não pode ser negativo.");
        }

		// Verificando a exceção: pilha não contém numItens elementos
		for(int i = 0; i < numItens; i++){
			if(aux == fundo)
				throw new IllegalArgumentException("A pilha não contém " + numItens + " elementos.");
			aux = aux.getProximo();
		}
		
		Pilha<E> novaPilha = new Pilha<>();
		Pilha<E> subPilha = new Pilha<>();
		aux = topo;
		for(int i = 0; i < numItens; i++){
			novaPilha.empilhar(aux.getItem());
			aux = aux.getProximo();
		}
		
		while(!novaPilha.vazia())
			subPilha.empilhar(novaPilha.desempilhar());

		return subPilha;
	}
}