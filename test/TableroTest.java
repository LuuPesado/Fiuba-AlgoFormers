import tp2.algoformers.modelo.Tablero;
import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.algoformers.Megatron;
import tp2.algoformers.modelo.algoformers.OptimusPrime;
import tp2.algoformers.modelo.algoformers.Ratchet;
import tp2.algoformers.modelo.excepciones.FueraDeRangoException;

import org.junit.Assert;
import org.junit.Test;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.modelo.Posicion;


public class TableroTest {
    
   
    @Test
    public void test01alAgregarUnAlgoformerLaCeldaEstaOcupada(){
       Algoformer unAlgoformer = new OptimusPrime();
       Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(2, 4, unAlgoformer);
       boolean ocupado = Tablero.getTablero().fila(2).columna(4).estaOcupada();
       Assert.assertEquals("La celda esta vacia",true,ocupado);
       Tablero.getTablero().reiniciarTablero();
    }
        
    @Test 
    public void test02alUbicarUnAlgoformerEsteSabeSuPosicion(){
        Algoformer unAlgoformer = new OptimusPrime();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(5, 12, unAlgoformer);
        Assert.assertTrue(unAlgoformer.getPosicion().getFila() == 5);
        Assert.assertTrue(unAlgoformer.getPosicion().getColumna() == 12);
        Tablero.getTablero().reiniciarTablero();
    }
        
    @Test
    public void test03muevoUnAlgoformerEnModoHumanoide(){
        Algoformer unAlgoformer = new Megatron();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(3, 3, unAlgoformer);
        unAlgoformer.moverAlgoformer(3, 4);
        Assert.assertTrue(unAlgoformer.getPosicion().getFila() == 3);
        Assert.assertTrue(unAlgoformer.getPosicion().getColumna() == 4);
        Tablero.getTablero().reiniciarTablero();
    }
      
    @Test
    public void test04transformoUnAlgoformerYLoMuevo(){
        Algoformer unAlgoformer = new Megatron();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(4, 4, unAlgoformer);
        unAlgoformer.transformar();
        unAlgoformer.moverAlgoformer(6,6);
        Assert.assertTrue(unAlgoformer.getPosicion().getFila() == 6);
        Assert.assertTrue(unAlgoformer.getPosicion().getColumna() == 6);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test05NoPuedoMoverAlgoformerMasAllaDeSuVelocidadDeDesplazamiento(){
        Algoformer unAlgoformer = new Ratchet();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(8, 8, unAlgoformer);
        unAlgoformer.moverAlgoformer(8, 10);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test  
    public void test06LuegoDeSacarUnAlgoformerDeUnaPosicionEstaSeEncuentraVacia(){
        Algoformer unAlgoformer = new Ratchet();
        Posicion posicionAlgoformer = new Posicion(3, 5);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(3, 5, unAlgoformer);
        Tablero.getTablero().sacarAlgoformer(posicionAlgoformer);
        Assert.assertFalse(Tablero.getTablero().fila(3).columna(5).estaOcupada());
        Tablero.getTablero().reiniciarTablero();
    } 
    
    @Test
    public void test04UnVacioSabeSuPosicion(){
        Contenido contenido;
        contenido = Tablero.getTablero().fila(6).columna(5).getContenido();
        Assert.assertTrue(contenido.getPosicion().getFila() == 6);
        Assert.assertTrue(contenido.getPosicion().getColumna() == 5);
        Tablero.getTablero().reiniciarTablero();
    }
       
}