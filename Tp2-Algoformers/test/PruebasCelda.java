/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tp2.algoformers.Algoformer;
import tp2.algoformers.Celda;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import tp2.algoformers.LaCeldaYaTieneUnAlgoformer;
import tp2.algoformers.Megatron;
import tp2.algoformers.OptimusPrime;
/**
 *
 * @author LuuPesado
 */
public class PruebasCelda {
    
    @Test
    public void alCrearLaCeldaEstaLibre(){
        Celda celda = new Celda();
        Assert.assertEquals("La celda no estaba libre",false,celda.estaOcupada());
    }
    
    @Test 
    public void laCeldaDeberiaTenerUnAlgoformer(){
        Celda celda = new Celda();
        Algoformer algoformer = new OptimusPrime();
        celda.agregarAlgoformer(algoformer);
        Assert.assertTrue(celda.estaOcupada());
    }
    
    @Test ( expected = LaCeldaYaTieneUnAlgoformer.class )
    public void siLaCeldaYaTeniaUnAlgoformerYQuieroPonerOtroMeDaError(){
        Algoformer algoformer1 = new OptimusPrime();
        Algoformer algoformer2 = new Megatron();
        Celda celda = new Celda();
        celda.agregarAlgoformer(algoformer1);
        celda.agregarAlgoformer(algoformer2);
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
