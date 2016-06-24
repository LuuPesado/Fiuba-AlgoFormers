/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tp2.algoformers.modelo.Algoformer;
import tp2.algoformers.modelo.FueraDeRangoException;
import tp2.algoformers.modelo.Megatron;
import tp2.algoformers.modelo.OptimusPrime;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.Tablero;


/**
 *
 * @author LuuPesado
 */
public class OptimusTest {
    
    private static Algoformer optimusPrime;
    private static Algoformer enemigo1;

    @Before
    public void setUp() {
        optimusPrime = new OptimusPrime();
        enemigo1 = new Megatron();
    }
    
    @Test
    public void test01OptimusIniciaCon500PuntosDeVida(){
        Assert.assertTrue(optimusPrime.puntosDeVida()==500);
    }
    
    @Test
    public void test02CuandoOptimusAtacaEnModoHumanoideQuita50puntos(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(5, 5, optimusPrime);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(7, 7, enemigo1);
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()== 500);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test03CuandoOptimusAtacaEnModoAlternaivoQuita15puntos(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(15, 15, optimusPrime);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(16,16, enemigo1);
        optimusPrime.transformar();
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()==535);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test04EnModoHumanideOptimusPuedeAtacarEnSuMaximaDistanciaDeAtaque(){
    	Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(8, 8, optimusPrime);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(10,10, enemigo1);
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()== 500);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test (expected=FueraDeRangoException.class)
    public void test05EnModoHumanoideOptimusNoPuedeAtacarMasAllaDeSuMaximaDistanciaDeAtaque(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(8, 8, optimusPrime);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(15,15, enemigo1);
        enemigo1.atacadoPor(optimusPrime);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test06EnModoAlternativoOptimusPuedeAtacarEnSuMaximaDistanciaDeAtaque(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(10, 10, optimusPrime);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(14,14, enemigo1);
        optimusPrime.transformar();
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()== 535);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test (expected=FueraDeRangoException.class)
    public void test07EnModoAlternativoOptimusNoPuedeAtacarMasAllaDeSuMaximaDistanciaDeAtaque(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(2, 2, optimusPrime);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(15,15, enemigo1);
        optimusPrime.transformar();
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()== 535);
        Tablero.getTablero().reiniciarTablero();
    }

    @Test
    public void test08OptimusConservaSuVidaLuegoDeSerTransformado(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(12, 10, optimusPrime);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(11,10, enemigo1);
        optimusPrime.atacadoPor(enemigo1);
        optimusPrime.transformar();
        Assert.assertTrue(optimusPrime.puntosDeVida() == 490);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test09OptimusSeDesplazaHasta2CasillerosEnModoHumanoide(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(15, 14, optimusPrime);
        optimusPrime.moverAlgoformer(16, 16);
        Posicion posicionDeDestino = new Posicion(16,16);
        Assert.assertTrue(optimusPrime.getPosicion().equals(posicionDeDestino));
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test10OptimusSeNoSeDesplazaHastaMasDe2CasillerosEnModoHumanoide(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(16, 10, optimusPrime);
        optimusPrime.moverAlgoformer(19, 4);
        Tablero.getTablero().reiniciarTablero();
    }
}
