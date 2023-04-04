import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class testGrafoCompleto {

	@Test
    public void testGrafoCompletoPositivo() {
        GrafoCompleto g = new GrafoCompleto("G", 5);
        assertTrue(g.completo());
    }

    @Test
    public void testGrafoCompletoNegativo() {
    	GrafoDirecionado g = new GrafoDirecionado("G");
        g.addVertice(1);
        g.addVertice(2);
        g.addVertice(3);
        g.addAresta(1, 2, 0);
        assertFalse(g.completo());
    }
}
