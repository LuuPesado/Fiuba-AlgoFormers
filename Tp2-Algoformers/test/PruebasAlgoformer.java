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
import tp2.algoformers.Bonecrusher;
import tp2.algoformers.Humanoide;
import tp2.algoformers.Megatron;
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Ratchet;
import tp2.algoformers.Tablero;
import tp2.algoformers.Vehiculo;

/**
 *
 * @author LuuPesado
 */
public class PruebasAlgoformer {
    
    @Test
    public void cuandoCreoUnAlgoformerEsHumanoide(){
        Algoformer algoformer = new Megatron();
        Humanoide humanoide = Humanoide.getInstance();
        Assert.assertTrue(algoformer.estado().equals(Humanoide.getInstance()));
    }
    
    @Test
    public void puedoTransformarUnAlgoformerEnAmbasDirecciones(){
        Algoformer algoformer = new OptimusPrime();
        algoformer.transformar();
        Assert.assertTrue(algoformer.estado().equals(Vehiculo.getInstance()));
        algoformer.transformar();
        Assert.assertTrue(algoformer.estado().equals(Humanoide.getInstance()));
    }
    
    @Test
    public void siUnAutobotAtacaUnDecepticonEstePierdeVida(){
        Tablero tablero = new Tablero (30,30);
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(10,10, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(13, 12, decepticon);
        autobot.atacar(decepticon);
        org.junit.Assert.assertTrue(decepticon.puntosDeVida() == 195);
    }
    
    public PruebasAlgoformer() {
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
