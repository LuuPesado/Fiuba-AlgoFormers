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
import tp2.algoformers.modelo.Ratchet;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.Tablero;


/**
 *
 * @author LuuPesado
 */
public class RatchetTest {
    
    private static Algoformer ratchet;
    private static Algoformer enemigo1;

    @Before
    public void setUp() {
        ratchet = new Ratchet();
        enemigo1 = new Megatron();
    }
    
    @Test
    public void test01RatchetIniciaCon150PuntosDeVida(){
        Assert.assertTrue(ratchet.puntosDeVida()==150);
    }
    
    @Test
    public void test02CuandoRatchetAtacaEnModoHumanoideQuita5puntos(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(5, 3, ratchet);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(10, 3, enemigo1);
        enemigo1.atacadoPor(ratchet);
        Assert.assertTrue(enemigo1.puntosDeVida()== 545);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test03CuandoRatchetAtacaEnModoAlternaivoQuita15puntos(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(10, 10, ratchet);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(11,11, enemigo1);
        ratchet.transformar();
        enemigo1.atacadoPor(ratchet);
        Assert.assertTrue(enemigo1.puntosDeVida()==515);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test04EnModoHumanideRatchetPuedeAtacarEnSuMaximaDistanciaDeAtaque(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(2, 2, ratchet);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(7,7, enemigo1);
        enemigo1.atacadoPor(ratchet);
        Assert.assertTrue(enemigo1.puntosDeVida()== 545);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test (expected=FueraDeRangoException.class)
    public void test05EnModoHumanoideRatchetNoPuedeAtacarMasAllaDeSuMaximaDistanciaDeAtaque(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(2, 2, ratchet);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(10,10, enemigo1);
        enemigo1.atacadoPor(ratchet);
        Tablero.getTablero().reiniciarTablero();
    }
    @Test
    public void test06EnModoAlternativoRatchetPuedeAtacarEnSuMaximaDistanciaDeAtaque(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(2, 2, ratchet);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(4,4, enemigo1);
        ratchet.transformar();
        enemigo1.atacadoPor(ratchet);
        Assert.assertTrue(enemigo1.puntosDeVida()== 515);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test (expected=FueraDeRangoException.class)
    public void test07EnModoAlternativoRatchetNoPuedeAtacarMasAllaDeSuMaximaDistanciaDeAtaque(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(15,16, ratchet);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(5,5, enemigo1);
        ratchet.transformar();
        enemigo1.atacadoPor(ratchet);
        Tablero.getTablero().reiniciarTablero();
    }

    @Test
    public void test08RatchetConservaSuVidaLuegoDeSerTransformado(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(12, 18, ratchet);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(11,18, enemigo1);
        ratchet.atacadoPor(enemigo1);
        ratchet.transformar();
        Assert.assertTrue(ratchet.puntosDeVida() == 140);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test09RatchetSeDesplazaHasta1CasilleroEnModoHumanoide(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(16, 17, ratchet);
        ratchet.moverAlgoformer(16, 17);
        Posicion posicionDeDestino = new Posicion(16,17);
        Assert.assertTrue(ratchet.getPosicion().equals(posicionDeDestino));
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test10RatchetSeNoSeDesplazaMasDe2CasillerosEnModoHumanoide(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(4, 6, ratchet);
        ratchet.moverAlgoformer(1, 1);
        Tablero.getTablero().reiniciarTablero();
    }
}
