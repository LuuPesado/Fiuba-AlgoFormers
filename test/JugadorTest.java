/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tp2.algoformers.Algoformer;
import tp2.algoformers.Bonecrusher;
import tp2.algoformers.Bumblebee;
import tp2.algoformers.Frenzy;
import tp2.algoformers.Jugador;
import tp2.algoformers.Megatron;
import tp2.algoformers.Menasor;
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Posicion;
import tp2.algoformers.Ratchet;
import tp2.algoformers.Superion;
import tp2.algoformers.Tablero;

/**
 *
 * @author LuuPesado
 */
public class JugadorTest {
    
	private static Jugador jugador2;
    private static Jugador jugador1;
    private static ArrayList<Algoformer> decepticons; 
    private static ArrayList<Algoformer> autobots;
    @Before
    public void setUp() {
        
        autobots = new ArrayList<Algoformer>();
        autobots.add(new OptimusPrime());
        autobots.add(new Bumblebee());
        autobots.add(new Ratchet());
        jugador2 = new Jugador("Martin",new Superion());
        jugador2.agregarAlgoformers(autobots);
        decepticons = new ArrayList<Algoformer>();
        decepticons.add(new Megatron());
        decepticons.add(new Bonecrusher());
        decepticons.add(new Frenzy());
        jugador1 = new Jugador("Santiago", new Menasor());
        jugador1.agregarAlgoformers(decepticons);
    }  
    @Test
    public void test01CuandoUnJugadorJuegaUnoDeSusAlgoformersEnUnaPosicionVaciaElAlgoformerSeMueveAlli(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(15, 15, decepticons.get(0));
        Posicion posicionDeDestino = new Posicion(16,16);
        jugador1.jugar(0, posicionDeDestino);
        Assert.assertTrue(jugador1.elegirAlgoformer(0).getPosicion().equals(posicionDeDestino));
    }
    
    @Test
    public void test02CuandoUnJugadorJuegaUnoDeSusAlgoformersASuPropiaPosicionSeTranforma(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(17, 13, decepticons.get(0));
        Posicion posicionDeDestino = new Posicion(17,13);
        jugador1.jugar(0, posicionDeDestino);
        Assert.assertTrue(jugador1.elegirAlgoformer(0).getVelocidad()==8);//La velocidad que tiene cuando es vehiculo.
    }
    
    @Test
    public void test03CuandoUnJugadorMueveAUnoDeSusAlgoformersALaPosicionDeUnoDeSusRivalesLoAtaca(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(67, 13, decepticons.get(0));
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(68, 13, autobots.get(0));
        Posicion posicionDeDestino = new Posicion(67,13);
        jugador2.jugar(0, posicionDeDestino);
        Assert.assertEquals(jugador1.elegirAlgoformer(0).puntosDeVida(), 500);
        //Megatron arranca con 550 puntos de vita y si Optimus lo atacadoPor le quita 50.
    }
}
