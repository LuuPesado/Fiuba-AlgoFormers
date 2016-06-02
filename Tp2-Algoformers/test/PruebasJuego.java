/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tp2.algoformers.Algoformer;
import tp2.algoformers.Juego;
import tp2.algoformers.Jugador;

/**
 *
 * @author LuuPesado
 */
public class PruebasJuego {
    
    
    @Test
    public void creoUnJuegoYLosAlgoformersEstanBienUbicados(){
        Jugador jugador1 = new Jugador("Martin");
        Jugador jugador2 = new Jugador("Lucia");
        Juego juego = new Juego(jugador1,jugador2);
        juego.crearTablero(30,30);
        Algoformer Optimus = juego.devolverOptimus();
        Assert.assertTrue(Optimus.posicion().getFila() == 1);
    }   
    
    
    public PruebasJuego() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
