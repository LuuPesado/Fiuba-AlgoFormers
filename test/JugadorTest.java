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
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Posicion;
import tp2.algoformers.Ratchet;
import tp2.algoformers.Tablero;

/**
 *
 * @author LuuPesado
 */
public class JugadorTest {
    
    private static Jugador jugador2;
    private static ArrayList<Algoformer> decepticons; 
    private static ArrayList<Algoformer> autobots;
    @Before
    public void setUp() {
        
        autobots = new ArrayList();
        autobots.add(new OptimusPrime());
        autobots.add(new Bumblebee());
        autobots.add(new Ratchet());

        jugador2 = new Jugador("Martin");
        decepticons = new ArrayList();
        decepticons.add(new Megatron());
        decepticons.add(new Bonecrusher());
        decepticons.add(new Frenzy());
        
    }  
    @Test
    public void test01CuandoUnJugadorJuegaUnoDeSusAlgoformersEnUnaPosicionVaciaElAlgoformerSeMueveAlli(){
        Jugador jugador1 = new Jugador("Santiago");
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(12, 13, decepticons.get(0));
        jugador1.agregarAlgoformers(decepticons);
        Posicion posicionDeDestino = new Posicion(13,13);
        jugador1.jugar(0, posicionDeDestino);
        Assert.assertTrue(jugador1.elegirAlgoformer(0).getPosicion().equals(posicionDeDestino));
    }
    
    @Test
    public void test02CuandoUnJugadorJuegaUnoDeSusAlgoformersASuPropiaPosicionSeTranforma(){
        Jugador jugador1 = new Jugador("Santiago");
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(17, 13, decepticons.get(0));
        jugador1.agregarAlgoformers(decepticons);
        Posicion posicionDeDestino = new Posicion(17,13);
        jugador1.jugar(0, posicionDeDestino);
        Assert.assertTrue(jugador1.elegirAlgoformer(0).velocidad()==8);//La velocidad que tiene cuando es vehiculo.
    }
    
    @Test
    public void test03CuandoUnJugadorJuagauUnoDeSusAlgoformersALaPosicionDeUnoDeSusRivalesLoAtaca(){
        Jugador jugador1 = new Jugador("Santiago");
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(67, 13, decepticons.get(0));
        jugador1.agregarAlgoformers(decepticons);
        
        Jugador jugador2 = new Jugador("Eunice");
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(68, 13, autobots.get(0));
        jugador2.agregarAlgoformers(autobots);

        Posicion posicionDeDestino = new Posicion(67,13);
        
        jugador2.jugar(0, posicionDeDestino);
        Assert.assertEquals(jugador1.elegirAlgoformer(0).puntosDeVida(), 500);
        //Megatron arranca con 550 puntos de vita y si Optimus lo atacadoPor le quita 50.
    }
}
