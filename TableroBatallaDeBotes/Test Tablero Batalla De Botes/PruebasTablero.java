/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import batalladebotes.*;
/**
 *
 * @author LuuPesado
 */
public class PruebasTablero {
  
       
        @Test
        public void alCrearUnTableroTodasLasCeldasDebenEstarVacias(){
            Tablero tablero = new Tablero();
            boolean ocupado = tablero.fila(2).columna(4).estaOcupada();
            Assert.assertEquals("La celda no esta vacia",false,ocupado);        
                    }
    
        @Test
        public void alAgregarUnBoteLaCeldaEstaOcupada(){
            Tablero tablero = new Tablero();
            BoteARemo unBote = new BoteARemo();
            tablero.agregarBoteEnUnaPosicion(2, 4, unBote);
            boolean ocupado = tablero.fila(2).columna(4).estaOcupada();
            Assert.assertEquals("La celda esta vacia",true,ocupado);
            
        }
        
        
        @Test
        public void cuandoReinicioElTableroElBoteQueAgregreAntesYaNoEsta(){
            Tablero tablero = new Tablero();
            BoteARemo unBote = new BoteARemo();
            tablero.agregarBoteEnUnaPosicion(2, 4, unBote);
            tablero.reiniciarTablero();
            boolean ocupado = tablero.fila(2).columna(4).estaOcupada();
            Assert.assertEquals("La celda no esta vacia",false,ocupado);
        }
        
        @Test
        public void despuesDeAgregarOchoBotesAlAzarTengoQueEncontrarOchoBotes(){
            Tablero tablero = new Tablero();
            tablero.colocarOchoBotesAlAzar();
            int contador = 0;
            for (int f = 1; f<=8; f++){
                for (int c = 1; c<=8; c++){
                    if (tablero.fila(f).columna(c).estaOcupada()){
                        contador++;
                    }
                }
            }
            Assert.assertEquals("No agrego ocho botes",8,contador);
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

