public class GrafoCompleto extends Grafo {
  
    private int ordem;   
 
     /**
     * Construtor da classe GrafoCompleto.
     * 
     * @param nome O nome do grafo.
     * @param ordem A ordem do grafo completo, ou seja, o número de vértices.
     */
    public GrafoCompleto(String nome, int ordem) {
        super(nome);
        this.setOrdem(ordem);
       
        for (int i = 0; i < ordem; i++) {
        	this.vertices.add(i, new Vertice(i));

            for (int j = 0; j < this.vertices.size(); j++) {
                this.vertices.find(i).addAresta(j,0);
                this.vertices.find(j).addAresta(i,0);
            }
        }
    }
    

     /**
     * Método para definir a ordem do grafo completo.
     * 
     * @param ordem A ordem do grafo completo.
     */
    public void setOrdem(int ordem) {
        if (ordem > 0)
            this.ordem = ordem;
    }
  
  
     /**
     * Método para obter a ordem do grafo completo.
     * 
     * @return A ordem do grafo completo.
     */
    public int getOrdem() {
    	return ordem;
    }

  public Vertice addVertice(int id){
        Vertice novo = new Vertice(id);
        this.vertices.add(id, novo);
        return novo;
    }

    public boolean addAresta(int origem, int destino, int peso){
        if(this.existeVertice(origem)!=null &&  this.existeVertice(destino) !=null){
            return (this.existeVertice(origem).addAresta(destino, peso)&&this.existeVertice(destino).addAresta(origem, peso));
        }
        return false;
    }
}
