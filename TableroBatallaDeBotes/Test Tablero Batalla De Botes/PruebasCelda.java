/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assert;
import batalladebotes.*;

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
    public void laCeldaDeberiaTenerUnBote(){
        Celda celda = new Celda();
        BoteARemo bote = new BoteARemo();
        celda.agregarBarco(bote);
        Assert.assertTrue(celda.estaOcupada());
    }
    
    @Test ( expected = LaCeldaYaTieneUnBote.class )
    public void siLaCeldaYaTeniaUnBoteYQuieroPonerOtroMeDaError(){
        BoteARemo bote1 = new BoteARemo();
        BoteARemo bote2 = new BoteARemo();
        Celda celda = new Celda();
        celda.agregarBarco(bote1);
        celda.agregarBarco(bote2);
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
