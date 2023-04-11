import java.util.Scanner;

public class App {

      
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println("Sistema Inicializado...\n");

        int valid = 1;
        while(valid != -1){
            System.out.println("Digite -1 caso queira finalizar.\n\nSelecione uma das opções:\n");
            System.out.println("1 - Criar Grafo Direcionado\n2 - Criar Grafo Não Direcionado\n");
            valid = scan.nextInt();


            if(valid == 1){
                System.out.println("Informe o nome do grafo:");
                scan.nextLine();
                String nome = scan.nextLine();

                GrafoDirecionado grafo = new GrafoDirecionado(nome);

                System.out.println("Informe os vértices (apenas números inteiros) do grafo (digite -1 quando quiser parar):");
                int vertice = 0;
                for(int i = 1; vertice != -1; i++){

                    System.out.println("\nInforme o id (inteiro) do " + i + "° vertice");
                    vertice = scan.nextInt();


                    if(grafo.existeVertice(vertice) == null && vertice != -1){
                        grafo.addVertice(vertice);
                    }
                    
                }

                

                Vertice[] todosVertices = grafo.todosVertices();

                System.out.println("\nTodos " + todosVertices.length + " Vértices adicionados");

                for(Vertice v : todosVertices){
                    System.out.println("- Vertice " + v.getId());
                }

                System.out.println("\nInforme as Arestas (apenas números inteiros) do grafo:\nA ordem dos valores deve seguir: id do vertice de origem; id do vertice de destino; peso da aresta;");
                int verticeOrigem = 0;
                for(int i = 0; verticeOrigem != -1; i++){
                    System.out.println("\nDigite -1 se quiser parar");
                    verticeOrigem = scan.nextInt();
                    if(verticeOrigem == -1){
                        break;
                    }
                    int verticeDestino = scan.nextInt();
                    int peso = scan.nextInt();

                    if(grafo.existeAresta(verticeOrigem, verticeDestino) == null && verticeOrigem != -1){
                        grafo.addAresta(verticeOrigem, verticeDestino, peso);
                    }

                }

                System.out.println("\nTodas Arestas adicionados");

                for(Vertice v : todosVertices){
                    // System.out.println("\n- Vertice " + v.getId());
                    Aresta[] arestas = v.todasArestas();

                    for(Aresta a : arestas){
                        System.out.println(v.getId() + "---" + a.peso() + "--->" + a.destino());
                    }
                }

                System.out.println("Grafo" + grafo.nome() + " foi criado com sucesso");
                
                int saida = 0;
                vertice =0;
                System.out.println("\nDigite -1 se quiser parar");
            	System.out.println();
            	System.out.println("1- Fazer busca em profundidade com o grafo criado");
            	System.out.println("2- Fazer busca em largura com o grafo criado");
                saida = scan.nextInt();
                do {
                	if(saida == 1) {
                		System.out.println("Você escolheu busca em profundidade");
                		System.out.println("Digite em qual vertice já criado deseja começar");
                		vertice= scan.nextInt();
                		System.out.println();
                		System.out.println("Busca realizada com sucesso:");
                		grafo.dfs(vertice);
                		
                	}else if(saida == 2) {
                		System.out.println("Você escolheu busca em largura");
                		System.out.println("Digite em qual vertice já criado deseja começar");
                		vertice= scan.nextInt();
                		grafo.bfs(vertice);
                		
                	}else if(saida ==3) {
                		System.out.println("Você escolheu gerar um subgrafo");
                		grafo.subGrafo(null);
                	}
                	else {
                		System.out.println("Numero invalido");
                        saida = scan.nextInt();
                	}
                	System.out.println("\nDigite -1 se quiser parar");
                	saida = -1;
                }while(saida != -1);
                
            }
            else if(valid == 2){

                System.out.println("Informe o nome do grafo:");
                scan.nextLine();
                String nome = scan.nextLine();

                GrafoNaoDireicionado grafo = new GrafoNaoDireicionado(nome);

                System.out.println("Informe os vértices (apenas números inteiros) do grafo (digite -1 quando quiser parar):");
                int vertice = 0;
                for(int i = 1; vertice != -1; i++){

                    System.out.println("\nInforme o id (inteiro) do " + i + "° vertice");
                    vertice = scan.nextInt();

                    if(grafo.existeVertice(vertice) == null  && vertice != -1){
                        grafo.addVertice(vertice);
                    }
                    
                }

                Vertice[] todosVertices = grafo.todosVertices();
                System.out.println("\nTodos " + todosVertices.length + " Vértices adicionados");

                for(Vertice v : todosVertices){
                    System.out.println("- Vertice " + v.getId());
                }


                System.out.println("\nInforme as Arestas (apenas números inteiros) do grafo:\nA ordem dos valores deve seguir: id do vertice de origem; id do vertice de destino; peso da aresta;");
                int verticeOrigem = 0;
                for(int i = 0; verticeOrigem != -1; i++){
                    System.out.println("\nDigite -1 se quiser parar");
                    verticeOrigem = scan.nextInt();
                    if(verticeOrigem == -1){
                        break;
                    }
                    int verticeDestino = scan.nextInt();
                    int peso = scan.nextInt();

                    if(grafo.existeAresta(verticeOrigem, verticeDestino) == null && verticeOrigem != -1){
                        grafo.addAresta(verticeOrigem, verticeDestino, peso);
                    }

                }

                System.out.println("\nTodas Arestas adicionados");
                
                
                for(Vertice v : todosVertices){
                    // System.out.println("\n- Vertice " + v.getId());
                    Aresta[] arestas = v.todasArestas();

                    for(Aresta a : arestas){
                        System.out.println(v.getId() + "---" + a.peso() + "---" + a.destino());
                    }
                }
                
                System.out.println("Grafo " + grafo.nome() + " foi criado com sucesso");

                int saida = 0;
                vertice =0;
                System.out.println("\nDigite -1 se quiser parar");
            	System.out.println();
            	System.out.println("1- Fazer busca em profundidade com o grafo criado");
            	System.out.println("2- Fazer busca em largura com o grafo criado");
            	System.out.println("3- Gerar subgrafo");
                saida = scan.nextInt();
                do {
                	if(saida == 1) {
                		System.out.println("Você escolheu busca em profundidade");
                		System.out.println("Digite em qual vertice já criado deseja começar");
                		vertice= scan.nextInt();
                		System.out.println();
                		System.out.println("Busca realizada com sucesso:");
                		grafo.dfs(vertice);
                		
                	}else if(saida == 2) {
                		System.out.println("Você escolheu busca em largura");
                		System.out.println("Digite em qual vertice já criado deseja começar");
                		vertice= scan.nextInt();
                		grafo.bfs(vertice);
                		
                	}else if(saida ==3) {
                		System.out.println("Você escolheu gerar um subgrafo");
                		grafo.subGrafo(null);
                	}
                	else {
                		System.out.println("Numero invalido");
                        saida = scan.nextInt();
                	}
                	saida = -1;
                }while(saida != -1);
            }
            else{
                System.out.println("Opção Inválida");
            }
          
        }
        scan.close();	
    }
}
