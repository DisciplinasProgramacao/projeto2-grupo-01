public class GrafoCompleto extends Grafo {
  
    private int ordem;
    
    public GrafoCompleto(String nome, int ordem) {
        super(nome);
        this.setOrdem(ordem);

        this.vertices = new ABB<>();
        Vertice[] arrayVertices = new Vertice[ordem];

        int i = 0;
        for (Vertice vertice : arrayVertices) {
            vertice = this.addVertice(i++);

            for (int j = 0; j < (i - 1); j++) {
                this.addAresta(j, vertice.getId(), 0);
                this.addAresta(vertice.getId(), j, 0); 
            }
        }
    }
    

    
    public void setOrdem(int ordem) {
        if (ordem > 0)
            this.ordem = ordem;
    }
    
    public int getOrdem() {
    	return ordem;
    }



	@Override
	public Grafo subGrafo(Lista<Vertice> vertices) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
