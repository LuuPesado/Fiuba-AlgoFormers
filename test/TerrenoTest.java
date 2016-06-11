import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import tp2.algoformers.Algoformer;
import tp2.algoformers.Espinas;
import tp2.algoformers.Megatron;
import tp2.algoformers.NebulosaDeAndromeda;
import tp2.algoformers.Nube;
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Pantano;
import tp2.algoformers.Posicion;
import tp2.algoformers.Rocosa;
import tp2.algoformers.Tablero;
import tp2.algoformers.TerrenoAereo;
import tp2.algoformers.TerrenoTerrestre;
import tp2.algoformers.TormentaPsionica;
import tp2.algoformers.UnHumanoideNoPuedeCruzarUnPantano;

public class TerrenoTest {

	@Test
	public void test01AtraviesanZonaRocosaSinProblemas(){
		Algoformer optimus = new OptimusPrime();
		Posicion inicio = new Posicion(1,1);
		Posicion fin = new Posicion(6,6);
		TerrenoTerrestre rocoso = new Rocosa();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(1, 1, optimus);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,rocoso);
		optimus.moverAlgoformer(3, 3);
		Assert.assertTrue(optimus.getPosicion().getFila() == 3);
        Assert.assertTrue(optimus.getPosicion().getColumna() == 3);
	}
	
	@Test (expected = UnHumanoideNoPuedeCruzarUnPantano.class)
	public void test02UnAlgoformerEnModoHumanoideNoPuedeAtravesarUnPantano(){
		Algoformer optimus = new OptimusPrime();
		Posicion inicio = new Posicion(7,7);
		Posicion fin = new Posicion(9,9);
		TerrenoTerrestre pantano = new Pantano();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(6, 6 , optimus);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,pantano);
		optimus.moverAlgoformer(7, 7);
	}
	
	@Test
	public void test04PantanoNoAfectaAlgoformerEnModoAereo(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(14,13);
		Posicion fin = new Posicion (20,13);
		TerrenoTerrestre pantano = new Pantano();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(13, 13 , megatron);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,pantano);		
		megatron.transformar();
		megatron.moverAlgoformer(21, 13);
		Assert.assertTrue(megatron.getPosicion().getFila() == 21);
        Assert.assertTrue(megatron.getPosicion().getColumna() == 13);
	}
	
	@Test 
	public void test05AlAtravesarUnaZonaConEspinasElAlgoformerSufreDanio(){
		Algoformer optimus = new OptimusPrime();
		Posicion inicio = new Posicion(40,40);
		Posicion fin = new Posicion(45,45);
		TerrenoTerrestre espinas = new Espinas();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(39, 39, optimus);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,espinas);
		optimus.moverAlgoformer(40, 40);
		Assert.assertTrue(optimus.puntosDeVida() == 475);
	}
	
	@Test
	public void test06EspinasNoAfectanAlgoformerEnModoAereo(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(45,45);
		Posicion fin = new Posicion (50,50);
		TerrenoTerrestre espinas = new Espinas();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(45,45 , megatron);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,espinas);		
		megatron.transformar();
		megatron.moverAlgoformer(46, 46);
		Assert.assertTrue(megatron.puntosDeVida() == 550);
	}
	
	@Test
	public void test07NubesNoAfectanAlgoformerEnModoAereo(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(50,50);
		Posicion fin = new Posicion (60,60);
		TerrenoAereo nube = new Nube();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(50, 50 , megatron);
		Tablero.getTablero().generarZonaAereo(inicio,fin,nube);		
		megatron.transformar();
		megatron.moverAlgoformer(58, 58);
		Assert.assertTrue(megatron.getPosicion().getFila() == 58);
        Assert.assertTrue(megatron.getPosicion().getColumna() == 58);
	}
	
	@Test
	public void test08UnidadAereaQuedaAtrapada3TurnosAlPasarPorNebulosaDeAndromeda(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(62,62);
		Posicion fin = new Posicion (65,65);
		TerrenoAereo nebulosa = new NebulosaDeAndromeda();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(61, 61 , megatron);
		Tablero.getTablero().generarZonaAereo(inicio,fin,nebulosa);	
		megatron.transformar();
		megatron.moverAlgoformer(65, 65);
		Assert.assertTrue(megatron.getPosicion().getFila() == 62); //como en 62 hay nebulosa se traba y no avanza mas
        Assert.assertTrue(megatron.getPosicion().getColumna() == 62);
		megatron.moverAlgoformer(61,61); //quiero volver, pero esta atrapado
		Assert.assertTrue(megatron.getPosicion().getFila() == 62);
        Assert.assertTrue(megatron.getPosicion().getColumna() == 62); //no pudo volver porque esta atrapado
		megatron.moverAlgoformer(61,61); //atrapado
		Assert.assertTrue(megatron.getPosicion().getFila() == 62);
        Assert.assertTrue(megatron.getPosicion().getColumna() == 62); //no pudo volver porque esta atrapado
		megatron.moverAlgoformer(61,61); //atrapado
		Assert.assertTrue(megatron.getPosicion().getFila() == 62);
        Assert.assertTrue(megatron.getPosicion().getColumna() == 62); //no pudo volver porque esta atrapado
		megatron.moverAlgoformer(61,61); //ya pasaron los 3 turnos
		Assert.assertTrue(megatron.getPosicion().getFila() == 61);
        Assert.assertTrue(megatron.getPosicion().getColumna() == 61); //el algoformer se pudo mover
	}
	
	@Test
	public void test09LaTormentaPsionicaBajaElAtaqueDeUnAlgoformer(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(70,70);
		Posicion fin = new Posicion (71,71);
		TerrenoAereo tormenta = new TormentaPsionica();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(69, 69 , megatron);
		Tablero.getTablero().generarZonaAereo(inicio,fin,tormenta);		
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(71, 71, optimus);
		megatron.transformar();
		optimus.atacadoPor(megatron);
		Assert.assertTrue(optimus.puntosDeVida() == 445);
		megatron.moverAlgoformer(70, 70);
		optimus.atacadoPor(megatron);
		Assert.assertTrue(optimus.puntosDeVida() == 412);
	}
	
	@Test
	public void test10LaTormentaPsionicaNoBajaElAtaqueAlPasarPorSegundaVez(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(80,80);
		Posicion fin = new Posicion (90,90);
		TerrenoAereo tormenta = new TormentaPsionica();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(79, 79 , megatron);
		Tablero.getTablero().generarZonaAereo(inicio,fin,tormenta);		
		megatron.transformar();
		megatron.moverAlgoformer(80, 80);
		Assert.assertTrue(megatron.getAtaque() == 33);
		megatron.moverAlgoformer(81,81);
		Assert.assertTrue(megatron.getAtaque() == 33);
	}
}
