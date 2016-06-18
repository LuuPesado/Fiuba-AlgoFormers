/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tp2.algoformers.Algoformer;
import tp2.algoformers.FueraDeRangoException;
import tp2.algoformers.Megatron;
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Posicion;
import tp2.algoformers.Tablero;


/**
 *
 * @author LuuPesado
 */
public class OptimusTest {
    
    private static Algoformer optimusPrime;
    private static Algoformer enemigo1;
    private static Tablero tablero;

    @Before
    public void setUp() {
        tablero = Tablero.getTablero();
        optimusPrime = new OptimusPrime();
        enemigo1 = new Megatron();
    }
    
    @Test
    public void test01OptimusIniciaCon500PuntosDeVida(){
        Assert.assertTrue(optimusPrime.puntosDeVida()==500);
    }
    
    @Test
    public void test02CuandoOptimusAtacaEnModoHumanoideQuita50puntos(){
        tablero.ubicarAlgoformerEnUnaPosicion(5, 5, optimusPrime);
        tablero.ubicarAlgoformerEnUnaPosicion(7, 7, enemigo1);
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()== 500);
    }
    
    @Test
    public void test03CuandoOptimusAtacaEnModoAlternaivoQuita15puntos(){
        tablero.ubicarAlgoformerEnUnaPosicion(50, 50, optimusPrime);
        tablero.ubicarAlgoformerEnUnaPosicion(51,51, enemigo1);
        optimusPrime.transformar();
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()==535);
    }
    
    @Test
    public void test04EnModoHumanideOptimusPuedeAtacarEnSuMaximaDistanciaDeAtaque(){
        tablero.ubicarAlgoformerEnUnaPosicion(51, 50, optimusPrime);
        tablero.ubicarAlgoformerEnUnaPosicion(53,50, enemigo1);
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()== 500);
    }
    
    @Test (expected=FueraDeRangoException.class)
    public void test05EnModoHumanoideOptimusNoPuedeAtacarMasAllaDeSuMaximaDistanciaDeAtaque(){
        tablero.ubicarAlgoformerEnUnaPosicion(41, 50, optimusPrime);
        tablero.ubicarAlgoformerEnUnaPosicion(44,50, enemigo1);
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()== 500);
    }
    
    @Test
    public void test06EnModoAlternativoOptimusPuedeAtacarEnSuMaximaDistanciaDeAtaque(){
        tablero.ubicarAlgoformerEnUnaPosicion(52, 50, optimusPrime);
        tablero.ubicarAlgoformerEnUnaPosicion(56,50, enemigo1);
        optimusPrime.transformar();
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()== 535);
    }
    
    @Test (expected=FueraDeRangoException.class)
    public void test07EnModoAlternativoOptimusNoPuedeAtacarMasAllaDeSuMaximaDistanciaDeAtaque(){
        tablero.ubicarAlgoformerEnUnaPosicion(32, 50, optimusPrime);
        tablero.ubicarAlgoformerEnUnaPosicion(37,50, enemigo1);
        optimusPrime.transformar();
        enemigo1.atacadoPor(optimusPrime);
        Assert.assertTrue(enemigo1.puntosDeVida()== 535);
    }

    @Test
    public void test08OptimusConservaSuVidaLuegoDeSerTransformado(){
        tablero.ubicarAlgoformerEnUnaPosicion(12, 50, optimusPrime);
        tablero.ubicarAlgoformerEnUnaPosicion(11,50, enemigo1);
        optimusPrime.atacadoPor(enemigo1);
        optimusPrime.transformar();
        Assert.assertTrue(optimusPrime.puntosDeVida() == 490);
    }
    
    @Test
    public void test09OptimusSeDesplazaHasta2CasillerosEnModoHumanoide(){
        tablero.ubicarAlgoformerEnUnaPosicion(15, 50, optimusPrime);
        optimusPrime.moverAlgoformer(16, 52);
        Posicion posicionDeDestino = new Posicion(16,52);
        Assert.assertTrue(optimusPrime.getPosicion().equals(posicionDeDestino));
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test10OptimusSeNoSeDesplazaHastaMasDe2CasillerosEnModoHumanoide(){
        tablero.ubicarAlgoformerEnUnaPosicion(16, 50, optimusPrime);
        optimusPrime.moverAlgoformer(19, 52);
    }
}
