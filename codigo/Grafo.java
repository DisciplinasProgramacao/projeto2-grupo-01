import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
/** 
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import java.util.List;
import java.util.Stack;

/** 
 * Classe básica para um Grafo simples não direcionado.
 */
public abstract class Grafo {
    private final String nome;
    protected ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado 
     * (string vazia), recebe o nome genérico "Grafo"
     */
    public Grafo(String nome){
        if(nome.length()==0) 
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();
    }

    /**
     * Chama o método construtor da classe GrafoCompleto
     * @return o método construtor de GrafoCompleto
     */
    public static Grafo grafoCompleto(int ordem) {
        return new GrafoCompleto("Grafo completo de ordem" + ordem, ordem);
    }
    
    /**
     * Retorna o nome do grafo (string), caso seja necessário em outras classes/sistemas
     * @return O nome do grafo (uma string)
     */
    public String nome(){
        return this.nome;
    }

    /**
     * Método para verificar a existência de um vértice do grafo
     * @param idVertice representa o id do Vertice verificado
     */
    public Vertice existeVertice(int idVertice){
    	return this.vertices.find(idVertice);
    }
    
    /**
     * Método para verificar a existência de uma aresta do grafo
     * @param retorna a aresta caso ela exista e null caso contrário
     */
    public Aresta existeAresta(int verticeA, int verticeB){
  	  Vertice saida = this.existeVertice(verticeA);
        return saida.existeAresta(verticeB);
  }
    
    
    /**
     * Método que verifica se o grafo é completo
     * 
     * @return true Caso seja completo
     * @return false Caso seja incompleto
     */
    public boolean completo() {
        Vertice[] vertices = todosVertices();
        int numVertices = vertices.length;

        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (vertices[i].existeAresta(vertices[j].getId()) == null) {
                    return false;
                }
            }
        }

        return true;
    }
    
    
    /**
     * Gera um subgrafo a partir das indicações dos vértices do grafo original
     * 
     * @param vertices Lista de vértices do grafo original
     * @return Um subgrafo com os vértices da lista
     */
    public Grafo subGrafo(Lista<Integer> vertices) {
        GrafoDirecionado subgrafo = new GrafoDirecionado("Subgrafo de " + this.nome);
        //perguntar sobre como posso fazer esse subgrafo
    }


    
    
    
    public int tamanho() {
        return this.ordem() + (this.todasArestas().size() / 2);
    }

    
    /**
     * Método que retorna a ordem do grafo, ou seja, número de vértices que o compoem
     * 
     * @return Ordem do grafo
     */
    public int ordem() {
        return this.vertices.size();
    }
    
   
    public void bfs(int idVerticeInicio) {
    	Lista <Vertice> fila = new Lista();
   
    	Vertice aux;
    	
    	Vertice[] todosVertices = todosVertices();
    	
    	if (this.vertices.find(idVerticeInicio) != null) {
    	
    	fila.add(this.vertices.find(idVerticeInicio));
    	this.vertices.find(idVerticeInicio).visitar();
    	
    	}
    	
    	while (fila.size() != 0) {
    		
    		aux = fila.remove(0);
    		System.out.print(aux.getId() + " ");
    		

    		
			for (Vertice v : todosVertices) {
				for(Aresta a : v.todasArestas()) {
					if(!v.visitado()) {
						v.visitar();
						fila.add(v);
					}
				}
			}
			
    	}
    	
  
    }
    
    
    public void dfs(int idVerticeInicio) {
    	Stack<Vertice> pilha = new Stack<>();
        pilha.push(vertices.find(idVerticeInicio));
        while(!pilha.empty()) {
        	Vertice verticeAtual = pilha.pop();
        	if(!verticeAtual.visitado()) {
        		verticeAtual.visitar();
        		System.out.print(verticeAtual.getId() + " ");
        		List<Integer> vizinhos = verticeAtual.vizinhos();
        		for(Integer vizinho : vizinhos ) {
        			Vertice verticeVizinho = vertices.find(vizinho);
                    if (!verticeVizinho.visitado()) {
                        pilha.push(verticeVizinho);
                    }
                
        		}
        	}
        }
    }


   
 

	/**
     * Busca saber todos os vértices de um grafo
     * @return todosVertices representa todos os vértices de um grafo
     */
    public Vertice[] todosVertices() {
    	Vertice[] todosVertices = new Vertice[vertices.size()];
		todosVertices = vertices.allElements(todosVertices);
		return todosVertices;
    }
    
    /**
     * Busca saber todos as arestas um grafo
     * @return arestas representa todos as arestass de um grafo
     */
    public Lista<Aresta> todasArestas() {
        Lista<Aresta> arestas = new Lista<>();

        for (Vertice vertice : this.todosVertices()) {
            for (Aresta aresta : vertice.todasArestas()) {
                arestas.add(aresta);
            }
        }

        return arestas;
    }

}
