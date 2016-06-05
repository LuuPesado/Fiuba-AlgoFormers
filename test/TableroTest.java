import tp2.algoformers.Algoformer;
import tp2.algoformers.Tablero;
import org.junit.Assert;
import org.junit.Test;
import tp2.algoformers.ChispaSuprema;
import tp2.algoformers.FueraDeRangoException;
import tp2.algoformers.Megatron;
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Posicion;
import tp2.algoformers.Ratchet;

public class TableroTest {
    
   
    @Test
    public void test01alAgregarUnAlgoformerLaCeldaEstaOcupada(){
        Tablero tablero = Tablero.getTablero();
       Algoformer unAlgoformer = new OptimusPrime();
       tablero.ubicarAlgoformerEnUnaPosicion(2, 4, unAlgoformer);
       boolean ocupado = tablero.fila(2).columna(4).estaOcupada();
       Assert.assertEquals("La celda esta vacia",true,ocupado);
       
    }
        
    @Test 
    public void test02alUbicarUnAlgoformerEsteSabeSuPosicion(){
        Tablero tablero = Tablero.getTablero();
        Algoformer unAlgoformer = new OptimusPrime();
        tablero.ubicarAlgoformerEnUnaPosicion(5, 12, unAlgoformer);
        Assert.assertTrue(unAlgoformer.posicion().getFila() == 5);
        Assert.assertTrue(unAlgoformer.posicion().getColumna() == 12);
    }
        
    @Test
    public void test03muevoUnAlgoformerEnModoHumanoide(){
         Tablero tablero = Tablero.getTablero();
        Algoformer unAlgoformer = new Megatron();
        tablero.ubicarAlgoformerEnUnaPosicion(3, 3, unAlgoformer);
        unAlgoformer.moverAlgoformer(3, 4);
        Assert.assertTrue(unAlgoformer.posicion().getFila() == 3);
        Assert.assertTrue(unAlgoformer.posicion().getColumna() == 4);
    }
      
    @Test
    public void test04transformoUnAlgoformerYLoMuevo(){
        Tablero tablero = Tablero.getTablero();
        Algoformer unAlgoformer = new Megatron();
        tablero.ubicarAlgoformerEnUnaPosicion(10, 12, unAlgoformer);
        unAlgoformer.transformar();
        unAlgoformer.moverAlgoformer(5, 4);
        Assert.assertTrue(unAlgoformer.posicion().getFila() == 5);
        Assert.assertTrue(unAlgoformer.posicion().getColumna() == 4);
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test05NoPuedoMoverAlgoformerMasAllaDeSuVelocidadDeDesplazamiento(){
        Tablero tablero = Tablero.getTablero();
        Algoformer unAlgoformer = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(8, 8, unAlgoformer);
        unAlgoformer.moverAlgoformer(8, 10);
    }
    
    @Test  
    public void test06LuegoDeSacarUnAlgoformerDeUnaPosicionEstaSeEncuentraVacia(){
        Tablero tablero = Tablero.getTablero();
        Algoformer unAlgoformer = new Ratchet();
        Posicion posicionAlgoformer = new Posicion(3, 5);
        tablero.ubicarAlgoformerEnUnaPosicion(3, 5, unAlgoformer);
        tablero.sacarAlgoformer(posicionAlgoformer);
        Assert.assertFalse(tablero.fila(3).columna(5).estaOcupada());
    } 
       
}