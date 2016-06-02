/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tp2.algoformers.Algoformer;
import tp2.algoformers.Tablero;
import org.junit.Assert;
import org.junit.Test;
import tp2.algoformers.Bonecrusher;
import tp2.algoformers.Megatron;
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Ratchet;
/**
 *
 * @author LuuPesado
 */
public class PruebasTablero {
  
       
        @Test
        public void alCrearUnTableroTodasLasCeldasDebenEstarVacias(){
            Tablero tablero = new Tablero(8,8);
            boolean ocupado = tablero.fila(2).columna(4).estaOcupada();
            Assert.assertEquals("La celda no esta vacia",false,ocupado);        
        }
    
        @Test
        public void alAgregarUnAlgoformerLaCeldaEstaOcupada(){
            Tablero tablero = new Tablero(8,8);
            Algoformer unAlgoformer = new OptimusPrime();
            tablero.ubicarAlgoformerEnUnaPosicion(2, 4, unAlgoformer);
            boolean ocupado = tablero.fila(2).columna(4).estaOcupada();
            Assert.assertEquals("La celda esta vacia",true,ocupado);
            
        }
        
        @Test 
        public void alUbicarUnAlgoformerEsteSabeSuPosicion(){
            Tablero tablero = new Tablero(8,8);
            Algoformer unAlgoformer = new OptimusPrime();
            tablero.ubicarAlgoformerEnUnaPosicion(2, 4, unAlgoformer);
            Assert.assertTrue(unAlgoformer.posicion().getFila() == 2);
            Assert.assertTrue(unAlgoformer.posicion().getColumna() == 4);
        }
        
        @Test
        public void muevoUnAlgoformerEnModoHumanoide(){
            Tablero tablero = new Tablero(8,8);
            Algoformer unAlgoformer = new Megatron();
            tablero.ubicarAlgoformerEnUnaPosicion(2, 4, unAlgoformer);
            tablero.moverAlgoformer(3, 5, unAlgoformer);
            Assert.assertTrue(unAlgoformer.posicion().getFila() == 3);
            Assert.assertTrue(unAlgoformer.posicion().getColumna() == 5);
        }
        
        @Test
        public void transformoUnAlgoformerYLoMuevo(){
            Tablero tablero = new Tablero(20,20);
            Algoformer unAlgoformer = new Megatron();
            tablero.ubicarAlgoformerEnUnaPosicion(10, 12, unAlgoformer);
            unAlgoformer.transformar();
            tablero.moverAlgoformer(2, 4, unAlgoformer);
            Assert.assertTrue(unAlgoformer.posicion().getFila() == 2);
            Assert.assertTrue(unAlgoformer.posicion().getColumna() == 4);
        }
        
        
        
}
                
        
  /*  @BeforeClass
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
*/

