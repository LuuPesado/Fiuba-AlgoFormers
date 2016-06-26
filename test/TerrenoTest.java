import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import tp2.algoformers.modelo.Jugador;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.Tablero;
import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.algoformers.Megatron;
import tp2.algoformers.modelo.algoformers.OptimusPrime;
import tp2.algoformers.modelo.excepciones.AtrapadoEnNebulosaException;
import tp2.algoformers.modelo.excepciones.UnHumanoideNoPuedeCruzarUnPantano;
import tp2.algoformers.modelo.terrenos.Espinas;
import tp2.algoformers.modelo.terrenos.NebulosaDeAndromeda;
import tp2.algoformers.modelo.terrenos.Nube;
import tp2.algoformers.modelo.terrenos.Pantano;
import tp2.algoformers.modelo.terrenos.Rocosa;
import tp2.algoformers.modelo.terrenos.TerrenoAereo;
import tp2.algoformers.modelo.terrenos.TerrenoTerrestre;
import tp2.algoformers.modelo.terrenos.TormentaPsionica;

public class TerrenoTest {

	@Test
	public void test01AtraviesanZonaRocosaSinProblemas(){
		Algoformer optimus = new OptimusPrime();
		Posicion inicio = new Posicion(1,1);
		Posicion fin = new Posicion(6,6);
		TerrenoTerrestre rocoso = new Rocosa();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(4, 2, optimus);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,rocoso);
		optimus.moverAlgoformer(4, 4);
		Assert.assertTrue(optimus.getPosicion().getFila() == 4);
        Assert.assertTrue(optimus.getPosicion().getColumna() == 4);
        Tablero.getTablero().reiniciarTablero();
	}
	
	@Test (expected = UnHumanoideNoPuedeCruzarUnPantano.class)
	public void test02UnAlgoformerEnModoHumanoideNoPuedeAtravesarUnPantano(){
		Algoformer optimus = new OptimusPrime();
		Posicion inicio = new Posicion(3,3);
		Posicion fin = new Posicion(4,4);
		TerrenoTerrestre pantano = new Pantano();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(2, 2, optimus);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,pantano);
		optimus.moverAlgoformer(3, 3);
		Tablero.getTablero().reiniciarTablero();
	}
	
	@Test
	public void test04PantanoNoAfectaAlgoformerEnModoAereo(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(10,10);
		Posicion fin = new Posicion (19,19);
		TerrenoTerrestre pantano = new Pantano();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(14, 14 , megatron);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,pantano);		
		megatron.transformar();
		megatron.moverAlgoformer(17, 17);
		Assert.assertTrue(megatron.getPosicion().getFila() == 17);
        Assert.assertTrue(megatron.getPosicion().getColumna() == 17);
        Tablero.getTablero().reiniciarTablero();
	}
	
	@Test 
	public void test05AlAtravesarUnaZonaConEspinasElAlgoformerSufreDanio(){
		Algoformer optimus = new OptimusPrime();
		Posicion inicio = new Posicion(3,3);
		Posicion fin = new Posicion(15,15);
		TerrenoTerrestre espinas = new Espinas();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(2, 2, optimus);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,espinas);
		optimus.moverAlgoformer(3, 3);
		Assert.assertTrue(optimus.puntosDeVida() == 475);
		Tablero.getTablero().reiniciarTablero();
	}
	
	@Test
	public void test06EspinasNoAfectanAlgoformerEnModoAereo(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(4,5);
		Posicion fin = new Posicion (4,10);
		TerrenoTerrestre espinas = new Espinas();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(4,5 , megatron);
		Tablero.getTablero().generarZonaTerrestre(inicio,fin,espinas);		
		megatron.transformar();
		megatron.moverAlgoformer(4, 10);
		Assert.assertTrue(megatron.puntosDeVida() == 550);
		Tablero.getTablero().reiniciarTablero();
	}
	
	@Test
	public void test07NubesNoAfectanAlgoformerEnModoAereo(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(5,5);
		Posicion fin = new Posicion (10,10);
		TerrenoAereo nube = new Nube();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(6, 6 , megatron);
		Tablero.getTablero().generarZonaAereo(inicio,fin,nube);		
		megatron.transformar();
		megatron.moverAlgoformer(10, 10);
		Assert.assertTrue(megatron.getPosicion().getFila() == 10);
        Assert.assertTrue(megatron.getPosicion().getColumna() == 10);
        Tablero.getTablero().reiniciarTablero();
	}
	
	@Test (expected = AtrapadoEnNebulosaException.class)
	public void test08UnidadAereaQuedaAtrapadaAlPasarPorNebulosaDeAndromeda(){
		Algoformer megatron = new Megatron();
		Jugador jugador = new Jugador("Santiago");
		ArrayList<Algoformer> listaAlgoformer = new ArrayList<Algoformer>();
		listaAlgoformer.add(megatron);
		jugador.agregarAlgoformers(listaAlgoformer);
		Posicion inicio = new Posicion(15,15);
		Posicion fin = new Posicion (17,17);
		TerrenoAereo nebulosa = new NebulosaDeAndromeda();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(14,14  , megatron);
		Tablero.getTablero().generarZonaAereo(inicio,fin,nebulosa);	
		megatron.transformar();
		megatron.moverAlgoformer(15, 15);
		jugador.jugar(0, fin);
		Tablero.getTablero().reiniciarTablero();
	}
      
	@Test
	public void test09LaTormentaPsionicaBajaElAtaqueDeUnAlgoformer(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(4,4);
		Posicion fin = new Posicion (15,15);
		TerrenoAereo tormenta = new TormentaPsionica();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(3, 3 , megatron);
		Tablero.getTablero().generarZonaAereo(inicio,fin,tormenta);		
		Algoformer optimus = new OptimusPrime();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(5,5 , optimus);
		megatron.transformar();
		optimus.atacadoPor(megatron);
		Assert.assertTrue(optimus.puntosDeVida() == 445);
		megatron.moverAlgoformer(4, 4);
		optimus.atacadoPor(megatron);
		Assert.assertTrue(optimus.puntosDeVida() == 412);
		Tablero.getTablero().reiniciarTablero();
	}
	
	@Test
	public void test10LaTormentaPsionicaNoBajaElAtaqueAlPasarPorSegundaVez(){
		Algoformer megatron = new Megatron();
		Posicion inicio = new Posicion(8,8);
		Posicion fin = new Posicion (9,9);
		TerrenoAereo tormenta = new TormentaPsionica();
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(7, 7 , megatron);
		Tablero.getTablero().generarZonaAereo(inicio,fin,tormenta);		
		megatron.transformar();
		megatron.moverAlgoformer(8, 8);
		Assert.assertTrue(megatron.getAtaque() == 33);
		megatron.moverAlgoformer(9,9);
		Assert.assertTrue(megatron.getAtaque() == 33);
		Tablero.getTablero().reiniciarTablero();
	}
}
