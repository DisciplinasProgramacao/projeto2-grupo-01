
public class GrafoNaoDireicionado extends GrafoMutavel {

    
	 /**
     * Construtor do grafo não direcionado
     * 
     * @param nome Representa o nome do grafo
     */
    public GrafoNaoDireicionado(String nome) {
        super(nome);
    }
	
	
	/**
     * Adiciona uma aresta entre dois vértices do grafo não direcionado, caso os dois vértices existam no grafo. 
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é ignorado e retorna FALSE.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @param peso Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    public boolean addAresta(int origem, int destino, int peso){
        if(this.existeVertice(origem)!=null &&  this.existeVertice(destino) !=null){
            return (this.existeVertice(origem).addAresta(destino, peso)&&this.existeVertice(destino).addAresta(origem, peso));
        }
        return false;
    }
    
    public Aresta removeAresta(int origem, int destino) {
        Vertice verticeOrigem = this.existeVertice(origem);
        Vertice verticeDestino = this.existeVertice(destino);
        if(verticeOrigem != null && verticeDestino != null) {
            Aresta removida = verticeOrigem.removeAresta(destino);
            if(removida  != null) {
                return removida ;
            }
        }
        return null;
    }

	
}
