import org.junit.Test;

import junit.framework.Assert;
import tp2.algoformers.modelo.ChispaSuprema;
import tp2.algoformers.modelo.OptimusPrime;
import tp2.algoformers.modelo.Tablero;

@SuppressWarnings("deprecation")
public class ChispaTest {

	@Test
	public void test01LaChispaEsAtrapada() {
		ChispaSuprema chispaSuprema = new ChispaSuprema();
		Tablero.getTablero().ubicarChispaSuprema(chispaSuprema);
		OptimusPrime optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(8,8,optimus);
		optimus.moverAlgoformer(9, 9);
		Assert.assertTrue(chispaSuprema.hayGanador());
		Tablero.getTablero().reiniciarTablero();
	}

}
