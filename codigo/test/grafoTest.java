import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Before;

class grafoTest {

	@Test
    public void testCarregar() {
        // cria um novo grafo
		GrafoDirecionado grafo = new GrafoDirecionado("Grafo de Teste");

        // carrega o grafo a partir do arquivo
        grafo.carregar("E:\\Programação Modular\\Trabalho2\\trabalho2\\ExGrafoSimples.txt");

 
        assertEquals(true, grafo.existeAresta(1, 2)); 
        assertEquals(true, grafo.existeAresta(1, 3)); 
        assertEquals(true, grafo.existeAresta(2, 3)); 
        assertEquals(true, grafo.existeAresta(3, 4)); 
    }
	
//	@Test
//	public void testSalvar() {
//
//		
//		GrafoDirecionado g = new GrafoDirecionado("grafo");
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
//		 assertEquals(true, g.existeAresta(1, 2)); 
//	     assertEquals(true, g.existeAresta(2, 3)); 
//	     assertEquals(true, g.existeAresta(3, 1)); 
//	       
//		
//	}


}
