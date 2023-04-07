public class GrafoCompleto extends Grafo {
  
    private int ordem;
    
//    public GrafoCompleto(String nome, int ordem) {
//        super(nome);
//        this.setOrdem(ordem);
//
//        this.vertices = new ABB<>();
//        Vertice[] arrayVertices = new Vertice[ordem];
//
//        int i = 0;
//        for (Vertice vertice : arrayVertices) {
//            vertice = this.addVertice(i++);
//
//            for (int j = 0; j < (i - 1); j++) {
//                this.addAresta(j, vertice.getId(), 0);
//                this.addAresta(vertice.getId(), j, 0); 
//            }
//        }
//    }
//    
    
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
    

    
    public void setOrdem(int ordem) {
        if (ordem > 0)
            this.ordem = ordem;
    }
    
    public int getOrdem() {
    	return ordem;
    }

}
