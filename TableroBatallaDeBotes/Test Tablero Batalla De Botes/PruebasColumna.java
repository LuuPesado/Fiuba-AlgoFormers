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
public class PruebasColumna {
    
    public PruebasColumna() {
    }
    
    @Test 
    public void laColumnaDeberiaTenerCeldasVacias(){
        Columna columna = new Columna();
        boolean ocupada = columna.celda(3).estaOcupada();
        Assert.assertEquals("La celda estaba ocupada",false,ocupada);
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
