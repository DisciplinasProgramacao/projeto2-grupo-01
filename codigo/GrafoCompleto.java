public static class GrafoCompleto extends Grafo {
    public final String nome;
    private ABB<Vertice> vertices;

    public GrafoCompleto (String nome) {
        if(nome.length()==0) 
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();
    }
    super(nome);

    // chamar esse metodo no construtor, terminar hoje
    // for each dentro do for com o numero (id) de vertices passado por paramentro
    @Override
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);

        if (vertices.size() != 0) {
            for (novo : vertices) {
                
                
             }
        }
    }
}
