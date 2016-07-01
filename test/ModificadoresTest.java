import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tp2.algoformers.modelo.AfectadoPorNebulosa;
import tp2.algoformers.modelo.AfectadoPorPantano;
import tp2.algoformers.modelo.AfectadoPorTormenta;
import tp2.algoformers.modelo.buffs.Buff;
import tp2.algoformers.modelo.buffs.BurbujaInmaculada;
import tp2.algoformers.modelo.buffs.Debuff;
import tp2.algoformers.modelo.buffs.DobleCanion;
import tp2.algoformers.modelo.buffs.Flash;
import tp2.algoformers.modelo.buffs.Modificadores;

public class ModificadoresTest {
	
	public static Buff dobleCanion;
	public static Buff burbuja;
	public static Buff flash;
	public static Modificadores modificadores;
	public static Debuff pantano;
	public static Debuff tormenta;
	public static Debuff nebulosa;
	
	@Before
	public void setUpBeforeClass(){
		modificadores = new Modificadores();
		dobleCanion = new DobleCanion(0,0);
		burbuja = new BurbujaInmaculada(0,0);
		flash = new Flash(0,0);
		pantano = new AfectadoPorPantano();
		tormenta = new AfectadoPorTormenta();
		nebulosa = new AfectadoPorNebulosa();
	}
	
	@Test
	public void test01agregoUnDobleCanionALosModificadores(){
		modificadores.agregarBuff(dobleCanion);
		Assert.assertTrue(modificadores.incluyeBuff(new DobleCanion(0,0)));
	}
	
	@Test
	public void test02agregoUnaBurbujaALosModificadores(){
		modificadores.agregarBuff(burbuja);
		Assert.assertTrue(modificadores.incluyeBuff(new BurbujaInmaculada(0,0)));
	}
	
	@Test
	public void test03agregoUnFlashALosModificadores(){
		modificadores.agregarBuff(flash);
		Assert.assertTrue(modificadores.incluyeBuff(new Flash(0,0)));
	}
	
	@Test
	public void test04agregoUnPantanoALosModificadores(){
		modificadores.agregarDebuff(pantano);
		Assert.assertTrue(modificadores.incluyeDebuff(new AfectadoPorPantano()));
	}
	
	@Test 
	public void test05agregoUnaNebulosaALosModificadores(){
		modificadores.agregarDebuff(nebulosa);
		Assert.assertTrue(modificadores.incluyeDebuff(new AfectadoPorNebulosa()));
	}

	@Test 
	public void test06agregoUnaTormentaALosModificadores(){
		modificadores.agregarDebuff(tormenta);
		Assert.assertTrue(modificadores.incluyeDebuff(new AfectadoPorTormenta()));
	}
	
	@Test
	public void test07seDisminuyeLaDuracionDeLosBuffs(){
		flash.bajarDuracion(); 
		Assert.assertTrue(flash.getDuracion() == 2);
		flash.bajarDuracion();
		Assert.assertTrue(flash.getDuracion() == 1);
	}
	
	@Test
	public void test08losModificadoresPuedenBajarLaDuracionDeTodosLosBuffsQueContienen(){
		modificadores.agregarBuff(burbuja);
		modificadores.agregarBuff(dobleCanion);
		modificadores.bajarTemporales();
		Assert.assertTrue(burbuja.getDuracion() == 1);
		Assert.assertTrue(dobleCanion.getDuracion() == 2);
	}
}

