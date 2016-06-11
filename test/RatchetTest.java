/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tp2.algoformers.Algoformer;
import tp2.algoformers.FueraDeRangoException;
import tp2.algoformers.Megatron;
import tp2.algoformers.Ratchet;
import tp2.algoformers.Posicion;
import tp2.algoformers.Tablero;


/**
 *
 * @author LuuPesado
 */
public class RatchetTest {
    
    private static Algoformer ratchet;
    private static Algoformer enemigo1;
    private static Tablero tablero;

    @Before
    public void setUp() {
        tablero = Tablero.getTablero();
        ratchet = new Ratchet();
        enemigo1 = new Megatron();
    }
    
    @Test
    public void test01RatchetIniciaCon150PuntosDeVida(){
        Assert.assertTrue(ratchet.puntosDeVida()==150);
    }
    
    @Test
    public void test02CuandoRatchetAtacaEnModoHumanoideQuita5puntos(){
        tablero.ubicarAlgoformerEnUnaPosicion(5, 3, ratchet);
        tablero.ubicarAlgoformerEnUnaPosicion(10, 3, enemigo1);
        ratchet.atacadoPor(enemigo1);
        Assert.assertTrue(enemigo1.puntosDeVida()== 545);
    }
    
    @Test
    public void test03CuandoRatchetAtacaEnModoAlternaivoQuita15puntos(){
        tablero.ubicarAlgoformerEnUnaPosicion(50, 20, ratchet);
        tablero.ubicarAlgoformerEnUnaPosicion(52,21, enemigo1);
        ratchet.transformar();
        ratchet.atacadoPor(enemigo1);
        Assert.assertTrue(enemigo1.puntosDeVida()==515);
    }
    
    @Test
    public void test04EnModoHumanideRatchetPuedeAtacarEnSuMaximaDistanciaDeAtaque(){
        tablero.ubicarAlgoformerEnUnaPosicion(51, 20, ratchet);
        tablero.ubicarAlgoformerEnUnaPosicion(56,20, enemigo1);
        ratchet.atacadoPor(enemigo1);
        Assert.assertTrue(enemigo1.puntosDeVida()== 545);
    }
    
    @Test (expected=FueraDeRangoException.class)
    public void test05EnModoHumanoideRatchetNoPuedeAtacarMasAllaDeSuMaximaDistanciaDeAtaque(){
        tablero.ubicarAlgoformerEnUnaPosicion(41, 20, ratchet);
        tablero.ubicarAlgoformerEnUnaPosicion(47,20, enemigo1);
        ratchet.atacadoPor(enemigo1);
    }
    @Test
    public void test06EnModoAlternativoRatchetPuedeAtacarEnSuMaximaDistanciaDeAtaque(){
        tablero.ubicarAlgoformerEnUnaPosicion(52, 20, ratchet);
        tablero.ubicarAlgoformerEnUnaPosicion(54,20, enemigo1);
        ratchet.transformar();
        ratchet.atacadoPor(enemigo1);
        Assert.assertTrue(enemigo1.puntosDeVida()== 515);
    }
    
    @Test (expected=FueraDeRangoException.class)
    public void test07EnModoAlternativoRatchetNoPuedeAtacarMasAllaDeSuMaximaDistanciaDeAtaque(){
        tablero.ubicarAlgoformerEnUnaPosicion(32, 20, ratchet);
        tablero.ubicarAlgoformerEnUnaPosicion(37,20, enemigo1);
        ratchet.transformar();
        ratchet.atacadoPor(enemigo1);
    }

    @Test
    public void test08RatchetConservaSuVidaLuegoDeSerTransformado(){
        tablero.ubicarAlgoformerEnUnaPosicion(12, 20, ratchet);
        tablero.ubicarAlgoformerEnUnaPosicion(11,20, enemigo1);
        enemigo1.atacadoPor(ratchet);
        ratchet.transformar();
        Assert.assertTrue(ratchet.puntosDeVida() == 140);
    }
    
    @Test
    public void test09RatchetSeDesplazaHasta1CasilleroEnModoHumanoide(){
        tablero.ubicarAlgoformerEnUnaPosicion(15, 20, ratchet);
        ratchet.moverAlgoformer(16, 21);
        Posicion posicionDeDestino = new Posicion(16,21);
        Assert.assertTrue(ratchet.getPosicion().equals(posicionDeDestino));
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test10RatchetSeNoSeDesplazaMasDe2CasillerosEnModoHumanoide(){
        tablero.ubicarAlgoformerEnUnaPosicion(16, 20, ratchet);
        ratchet.moverAlgoformer(16, 22);
    }
}
