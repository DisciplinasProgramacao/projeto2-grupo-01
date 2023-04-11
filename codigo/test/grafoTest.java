import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

class grafoTest {

//	@Test
//    public void testCarregar() {
//        // cria um novo grafo
//		GrafoNaoDireicionado grafo = new GrafoNaoDireicionado("Grafo de Teste");
//
//        // Lembre de alterar o endereço do arquivo para o referente ao da sua máquina para que ele funcione corretamente
//		
//        grafo.carregar("E:\\Programação Modular\\Trabalho2\\trabalho2\\ExGrafoSimples.txt");
//
// 
//        assertEquals(true, grafo.existeAresta(1, 2)); 
//        assertEquals(true, grafo.existeAresta(1, 3)); 
//        assertEquals(true, grafo.existeAresta(2, 3)); 
//        assertEquals(true, grafo.existeAresta(3, 4)); 
//    }
//	
//	@Test
//	public void testSalvar() {
//
//		
//		GrafoNaoDireicionado g = new GrafoNaoDireicionado("grafo");
//		g.addVertice(1);
//		g.addVertice(2);
//		g.addVertice(3);
//		
//		g.addAresta(1, 2, 3);
//		g.addAresta(2, 3, 2);
//		g.addAresta(3, 1, 1);
//
//		g.salvar(g.nome());
//				
//		
//		assertEquals(true, g.existeAresta(1, 2)); 
//	     assertEquals(true, g.existeAresta(2, 3)); 
//	     assertEquals(true, g.existeAresta(3, 1)); 
//	       
//		
//	}
//	
	@Test
	public void testBFS() {

		
		GrafoNaoDireicionado g = new GrafoNaoDireicionado("grafo");
		g.addVertice(0);
		g.addVertice(1);
		g.addVertice(2);
		g.addVertice(3);
		
		g.addAresta(0, 1, 1);
		g.addAresta(0, 2, 1);
		g.addAresta(1, 2, 1);
		g.addAresta(2, 0, 1);
		g.addAresta(2, 3, 1);
		g.addAresta(3, 3, 1);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    System.setOut(ps);
		
		
		g.bfs(2);
		
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		String outputEsperado = "2 0 1 3 ";
        String outputGerado = baos.toString();
        assertEquals(outputEsperado, outputGerado);
		
	
	}
	
	@Test
	public void testDFS() {
		
		    GrafoNaoDireicionado g = new GrafoNaoDireicionado("grafo");
		    g.addVertice(0);
		    g.addVertice(1);
		    g.addVertice(2);
		    g.addVertice(3);

		    g.addAresta(0, 1, 1);
		    g.addAresta(0, 2, 1);
		    g.addAresta(1, 2, 1);
		    g.addAresta(2, 0, 1);
		    g.addAresta(2, 3, 1);
		    g.addAresta(3, 3, 1);

		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    PrintStream ps = new PrintStream(baos);
		    System.setOut(ps);

		    g.dfs(2);

		    System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

		    String outputEsperado = "2 3 1 0 ";
		    String outputGerado = baos.toString();
		    assertEquals(outputEsperado, outputGerado);
	   
	    
	    for(Vertice v : g.todosVertices()) {
	    	assertEquals(true, v.visitado());
	    }
	}
	
	@Test
    	public void testSubGrafoListaVazia() {
        	Grafo g = new Grafo();
        	Lista<Integer> vertices = new Lista<>();
        	Grafo subgrafo = g.subGrafo(vertices);
        	assertTrue(subgrafo.getNumVertices() == 0);
    	}
	
	@Test
   	 public void testSubGrafo() {
        	Grafo g = new Grafo();
        	g.addVertice(1);
       	 	g.addVertice(2);
        	g.addVertice(3);
        	g.addAresta(1, 2, 0);
        	g.addAresta(2, 3, 0);
        	Lista<Integer> vertices = new Lista<>();
        	vertices.adiciona(1);
        	vertices.adiciona(3);
        	Grafo subgrafo = g.subGrafo(vertices);
        	assertTrue(subgrafo.getNumVertices() == 2);
        	assertTrue(subgrafo.existeVertice(1) != null);
        	assertTrue(subgrafo.existeVertice(3) != null);
        	assertTrue(subgrafo.existeAresta(1, 2) == null);
        	assertTrue(subgrafo.existeAresta(2, 3) == null);
    }
	
}
