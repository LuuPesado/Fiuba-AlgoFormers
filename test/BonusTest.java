import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import tp2.algoformers.Algoformer;
import tp2.algoformers.Buff;
import tp2.algoformers.BurbujaInmaculada;
import tp2.algoformers.Contenido;
import tp2.algoformers.DobleCanion;
import tp2.algoformers.Flash;
import tp2.algoformers.Megatron;
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Tablero;

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
		Tablero.getTablero().ubicarBuff(dobleCanion,46,46);
		Tablero.getTablero().ubicarBuff(burbujaInmaculada, 47, 46);
		Tablero.getTablero().ubicarBuff(flash, 48, 46);
		megatron = new Megatron();
	}
	
	@Test 
	public void test00laCeldaTieneElBonus(){
		Contenido contenido = Tablero.getTablero().fila(46).columna(46).getContenido();
		Assert.assertTrue(dobleCanion.equals(contenido));
	}
	
	@Test
	public void test01optimusObtieneElDobleCanion(){
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(46, 46, optimus);
		//optimus.moverAlgoformer(46, 46);
		Tablero.getTablero().fila(46).columna(46).darBuff(optimus);
		Assert.assertTrue(optimus.afectadoPorBuff(dobleCanion));
	}
	
	/*@Test 
	public void test01elDobleCanionDuplicaElDanioDeUnAlgoformer(){
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(46, 45, optimus);
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(46, 48, megatron);
		//megatron.atacadoPor(optimus);
		//Assert.assertTrue(megatron.puntosDeVida() == 500);
		optimus.moverAlgoformer(46,46);
		optimus.afectadoPorBuff(new DobleCanion(0,0));
		megatron.atacadoPor(optimus);
		Assert.assertTrue(megatron.puntosDeVida() == 450 );
	}*/
}
