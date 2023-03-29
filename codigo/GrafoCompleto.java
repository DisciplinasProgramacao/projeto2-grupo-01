public class GrafoCompleto extends Grafo {
    public String nome;
    private ABB<Vertice> vertices;

    public GrafoCompleto (String nome, int numVertices) {
        super(nome, numVertices);
        if(nome.length()==0)
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();

        for (int i = 0; i < numVertices; i++) {
            addVertice(i);
        }
    }
}