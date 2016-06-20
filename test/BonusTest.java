import org.junit.Assert;
import org.junit.BeforeClass;
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
	
	@BeforeClass
	public static void setUpBeforeClass(){
		burbujaInmaculada = new BurbujaInmaculada(0,0);
		dobleCanion = new DobleCanion(0,0);
		flash = new Flash(0,0);
		megatron = new Megatron();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(46, 49, megatron);
	}
	
	@Test 
	public void test00laCeldaTieneElBonus(){
		Tablero.getTablero().ubicarBuff(dobleCanion,46,46);
		Contenido contenido = Tablero.getTablero().fila(46).columna(46).getContenido();
		Assert.assertTrue(dobleCanion.equals(contenido));
	}
	
	@Test
	public void test01optimusObtieneElDobleCanion(){
		Tablero.getTablero().ubicarBuff(dobleCanion,46,46);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(46, 45, optimus);
		optimus.moverAlgoformer(46, 46);
		Tablero.getTablero().fila(46).columna(46).darBuff(optimus);
		Assert.assertTrue(optimus.afectadoPorBuff(dobleCanion));
	}
	
	@Test 
	public void test02elDobleCanionDuplicaElDanioDeUnAlgoformer(){
		Tablero.getTablero().ubicarBuff(dobleCanion,46,48);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(46, 47, optimus);
		megatron.atacadoPor(optimus);
		Assert.assertTrue(megatron.puntosDeVida() == 500);
		optimus.moverAlgoformer(46,48);
		optimus.afectadoPorBuff(new DobleCanion(0,0));
		megatron.atacadoPor(optimus);
		Assert.assertTrue(megatron.puntosDeVida() == 400);
	}
	
	@Test
	public void test03laBurbujaEvitaTodoElDaño(){
		Tablero.getTablero().ubicarBuff(burbujaInmaculada, 47, 46);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(47, 45, optimus);
		optimus.moverAlgoformer(47, 46);
		optimus.atacadoPor(megatron);
		Assert.assertTrue(optimus.puntosDeVida() == 500);
	}
	
	@Test
	public void test04FlashPermiteAOptimusMoverseElTripleDeRapido(){
		Tablero.getTablero().ubicarBuff(flash, 48, 46);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(48, 45, optimus);
		optimus.moverAlgoformer(48,46);
		optimus.moverAlgoformer(48,52);
		Assert.assertTrue(optimus.getPosicion().getFila() == 48);
		Assert.assertTrue(optimus.getPosicion().getColumna() == 52);
	}

	@Test
	public void test05FlashPermiteAOptimusMoverseMasRapidoEnModoVehiculo(){
		Tablero.getTablero().ubicarBuff(flash, 49, 46);
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(49, 45, optimus);
		optimus.moverAlgoformer(49,46);
		optimus.transformar();
		optimus.moverAlgoformer(49,61);
		Assert.assertTrue(optimus.getPosicion().getFila() == 49);
		Assert.assertTrue(optimus.getPosicion().getColumna() == 61);
	}
}
