import tp2.algoformers.Algoformer;
import tp2.algoformers.Tablero;
import org.junit.Assert;
import org.junit.Test;
import tp2.algoformers.FueraDeRangoException;
import tp2.algoformers.Megatron;
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Ratchet;

public class PruebasTablero {
    
    @Test
    public void test01alCrearUnTableroTodasLasCeldasDebenEstarVacias(){
        Tablero tablero = new Tablero(8,8);
        boolean ocupado = tablero.fila(2).columna(4).estaOcupada();
        Assert.assertEquals("La celda no esta vacia",false,ocupado);        
    }
    
    @Test
    public void test02alAgregarUnAlgoformerLaCeldaEstaOcupada(){
       Tablero tablero = new Tablero(8,8);
       Algoformer unAlgoformer = new OptimusPrime();
       tablero.ubicarAlgoformerEnUnaPosicion(2, 4, unAlgoformer);
       boolean ocupado = tablero.fila(2).columna(4).estaOcupada();
       Assert.assertEquals("La celda esta vacia",true,ocupado);
       
    }
        
    @Test 
    public void test03alUbicarUnAlgoformerEsteSabeSuPosicion(){
        Tablero tablero = new Tablero(8,8);
        Algoformer unAlgoformer = new OptimusPrime();
        tablero.ubicarAlgoformerEnUnaPosicion(2, 4, unAlgoformer);
        Assert.assertTrue(unAlgoformer.posicion().getFila() == 2);
        Assert.assertTrue(unAlgoformer.posicion().getColumna() == 4);
    }
        
    @Test
    public void test04muevoUnAlgoformerEnModoHumanoide(){
        Tablero tablero = new Tablero(8,8);
        Algoformer unAlgoformer = new Megatron();
        tablero.ubicarAlgoformerEnUnaPosicion(2, 4, unAlgoformer);
        tablero.moverAlgoformer(3, 5, unAlgoformer);
        Assert.assertTrue(unAlgoformer.posicion().getFila() == 3);
        Assert.assertTrue(unAlgoformer.posicion().getColumna() == 5);
    }
      
    @Test
    public void test05transformoUnAlgoformerYLoMuevo(){
        Tablero tablero = new Tablero(20,20);
        Algoformer unAlgoformer = new Megatron();
        tablero.ubicarAlgoformerEnUnaPosicion(10, 12, unAlgoformer);
        unAlgoformer.transformar();
        tablero.moverAlgoformer(2, 4, unAlgoformer);
        Assert.assertTrue(unAlgoformer.posicion().getFila() == 2);
        Assert.assertTrue(unAlgoformer.posicion().getColumna() == 4);
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test06NoPuedoMoverAlgoformerMasAllaDeSuVelocidadDeDesplazamiento(){
        Tablero tablero = new Tablero(20,20);
        Algoformer unAlgoformer = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(8, 8, unAlgoformer);
        tablero.moverAlgoformer(8, 10, unAlgoformer);
    }
    
}