import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class GrafoMutavel extends Grafo {

	public GrafoMutavel(String nome) {
        super(nome);
    }
	
	 /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se já existir
     * um vértice com este id
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com este id
     */
    public Vertice addVertice(int id){
        Vertice novo = new Vertice(id);
        this.vertices.add(id, novo);
        return novo;
    }


     /**
     * Remove um vértice com o id especificado. Ignora a ação e retorna false se não existir um vértice com este id
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a remoção do vértice, FALSE se não existir o vértice com este id
     */
    public Vertice removeVertice(int id){
    	 return vertices.remove(id);	
    }
    
    

    
    /**
     * Remove uma aresta do grafo em questão
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @return A aresta e que foi removida caso tudo ocorra com sucesso, FALSE caso contrário
     */
    public Aresta removeAresta(int origem, int destino){
        return this.existeVertice(origem).removeAresta(destino);
    }
    
    
    /**
     * Carrega o grafo a partir de um arquivo txt
     * @param nomeArquivo O indentificador do arquivo que deve ser carrecado
     */
    public void carregar(String nomeArquivo){
    	 try {
    	        BufferedReader ler = new BufferedReader(new FileReader(nomeArquivo));
    	        String linha;
    	        int origem, destino,peso;
    	        String[] dados;
    	        

    	        while ((linha = ler.readLine()) != null) {
    	            dados = linha.split(";");
    	            origem = Integer.parseInt(dados[0]);
    	            destino = Integer.parseInt(dados[1]);
    	            peso = Integer.parseInt(dados[2]);

    	            this.addVertice(origem);
    	            this.addVertice(destino);
    	            this.addAresta(origem, destino, peso);
    	        }

    	        ler.close();

    	    } catch (FileNotFoundException e) {
    	        System.err.println("Arquivo não encontrado");
    	    } catch (IOException e) {
    	        System.err.println("Erro ao ler arquivo");
    	    } catch (NumberFormatException e) {
    	        System.err.println("Dados inválidos no arquivo");
    	    }
    }
    
    
    /**
     * Salva um grafo em um arquivo txt
     * @param nomeArquivo O indentificador do arquivo que deve ser carrecado
     */
    public void salvar(String nomeArquivo){
    	try {
			FileWriter fw = new FileWriter(nomeArquivo+".txt");
			
			Vertice[] todosVertices = todosVertices();
			for (Vertice v : todosVertices) {
				for(Aresta a : v.todasArestas()) {
					fw.write(v.getId() + ";" + a.destino() + ";" + a.peso() + "\n");
				}
			}
            
        fw.close();
		}catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }

    }

    public abstract boolean addAresta(int origem, int destino, int peso); 
    
}
