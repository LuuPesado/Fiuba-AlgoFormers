import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tp2.algoformers.modelo.Algoformer;
import tp2.algoformers.modelo.Buff;
import tp2.algoformers.modelo.BurbujaInmaculada;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.modelo.DobleCanion;
import tp2.algoformers.modelo.Flash;
import tp2.algoformers.modelo.Megatron;
import tp2.algoformers.modelo.OptimusPrime;
import tp2.algoformers.modelo.Tablero;

public class BonusTest {
	
	public static Buff burbujaInmaculada;
	public static Buff dobleCanion;
	public static Buff flash;
	public static Algoformer megatron;
	
	@Before
	public void setUp(){
		burbujaInmaculada = new BurbujaInmaculada(0,0);
		dobleCanion = new DobleCanion(0,0);
		flash = new Flash(0,0);
		megatron = new Megatron();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(10, 10, megatron);
	}
	
	@Test 
	public void test00laCeldaTieneElBonus(){
		Tablero.getTablero().ubicarBuff(dobleCanion,8,8);
		Contenido contenido = Tablero.getTablero().fila(8).columna(8).getContenido();
		Assert.assertTrue(dobleCanion.equals(contenido));
		Tablero.getTablero().reiniciarTablero();
	}
	
	@Test
	public void test01optimusObtieneElDobleCanion(){
		Tablero.getTablero().ubicarBuff(dobleCanion,8,8);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(7, 7, optimus);
		optimus.moverAlgoformer(8, 8);
		Assert.assertTrue(optimus.afectadoPorBuff(dobleCanion));
		Tablero.getTablero().reiniciarTablero();
	}
	
	@Test 
	public void test02elDobleCanionDuplicaElDanioDeUnAlgoformer(){
		Tablero.getTablero().ubicarBuff(dobleCanion,9,9);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(8, 8, optimus);
		megatron.atacadoPor(optimus);
		Assert.assertTrue(megatron.puntosDeVida() == 500);
		optimus.moverAlgoformer(9,9);
		megatron.atacadoPor(optimus);
		Assert.assertTrue(megatron.puntosDeVida() == 400);
		Tablero.getTablero().reiniciarTablero();
	}
	
	@Test
	public void test03laBurbujaEvitaTodoElDaño(){
		Tablero.getTablero().ubicarBuff(burbujaInmaculada, 8, 8);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(7, 7, optimus);
		optimus.moverAlgoformer(8, 8);
		optimus.atacadoPor(megatron);
		Assert.assertTrue(optimus.puntosDeVida() == 500);
		Tablero.getTablero().reiniciarTablero();
	}
	
	@Test
	public void test04FlashPermiteAOptimusMoverseElTripleDeRapido(){
		Tablero.getTablero().ubicarBuff(flash, 8, 8);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(7, 7, optimus);
		optimus.moverAlgoformer(8,8);
		optimus.moverAlgoformer(2,2);
		Assert.assertTrue(optimus.getPosicion().getFila() == 2);
		Assert.assertTrue(optimus.getPosicion().getColumna() == 2);
		Tablero.getTablero().reiniciarTablero();
	}

	@Test
	public void test05FlashPermiteAOptimusMoverseMasRapidoEnModoVehiculo(){
		Tablero.getTablero().ubicarBuff(flash, 8, 8);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(7, 7, optimus);
		optimus.moverAlgoformer(8,8);
		optimus.transformar();
		optimus.moverAlgoformer(1, 1);
		Assert.assertTrue(optimus.getPosicion().getFila() == 1);
		Assert.assertTrue(optimus.getPosicion().getColumna() == 1);
		Tablero.getTablero().reiniciarTablero();
	}
}
