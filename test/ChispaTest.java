import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import tp2.algoformers.modelo.ChispaSuprema;
import tp2.algoformers.modelo.OptimusPrime;
import tp2.algoformers.modelo.Tablero;

public class ChispaTest {

	@Test
	public void test01LaChispaEsAtrapada() {
		ChispaSuprema chispaSuprema = new ChispaSuprema();
		Tablero.getTablero().ubicarChispaSuprema(chispaSuprema);
		OptimusPrime optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(49,49,optimus);
		optimus.moverAlgoformer(50, 50);
		Assert.assertTrue(chispaSuprema.hayGanador());
	}

}
