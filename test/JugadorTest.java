/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tp2.algoformers.modelo.Jugador;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.Tablero;
import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.algoformers.Bonecrusher;
import tp2.algoformers.modelo.algoformers.Bumblebee;
import tp2.algoformers.modelo.algoformers.Frenzy;
import tp2.algoformers.modelo.algoformers.Megatron;
import tp2.algoformers.modelo.algoformers.OptimusPrime;
import tp2.algoformers.modelo.algoformers.Ratchet;

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
        jugador2 = new Jugador("Martin");
        jugador2.agregarAlgoformers(autobots);
        decepticons = new ArrayList<Algoformer>();
        decepticons.add(new Megatron());
        decepticons.add(new Bonecrusher());
        decepticons.add(new Frenzy());
        jugador1 = new Jugador("Santiago");
        jugador1.agregarAlgoformers(decepticons);
    }  
    @Test
    public void test01CuandoUnJugadorJuegaUnoDeSusAlgoformersEnUnaPosicionVaciaElAlgoformerSeMueveAlli(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(15, 15, decepticons.get(0));
        Posicion posicionDeDestino = new Posicion(16,16);
        jugador1.jugar(0, posicionDeDestino);
        Assert.assertTrue(jugador1.elegirAlgoformer(0).getPosicion().equals(posicionDeDestino));
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test02CuandoUnJugadorJuegaUnoDeSusAlgoformersASuPropiaPosicionSeTranforma(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(17, 13, decepticons.get(0));
        Posicion posicionDeDestino = new Posicion(17,13);
        jugador1.jugar(0, posicionDeDestino);
        Assert.assertTrue(jugador1.elegirAlgoformer(0).getVelocidad()==8);//La velocidad que tiene cuando es vehiculo.
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test03CuandoUnJugadorMueveAUnoDeSusAlgoformersALaPosicionDeUnoDeSusRivalesLoAtaca(){
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(5, 6, decepticons.get(0));
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(6, 6, autobots.get(0));
        Posicion posicionDeDestino = new Posicion(5,6);
        jugador2.jugar(0, posicionDeDestino);
        Assert.assertEquals(jugador1.elegirAlgoformer(0).puntosDeVida(), 500);
        //Megatron arranca con 550 puntos de vita y si Optimus lo atacadoPor le quita 50.
        Tablero.getTablero().reiniciarTablero();
    }
}
