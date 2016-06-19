import org.junit.Assert;
import org.junit.Test;
import tp2.algoformers.modelo.Algoformer;
import tp2.algoformers.modelo.Bonecrusher;
import tp2.algoformers.modelo.FueraDeRangoException;
import tp2.algoformers.modelo.Humanoide;
import tp2.algoformers.modelo.Megatron;
import tp2.algoformers.modelo.NoPuedoAtacarUnCompanieroException;
import tp2.algoformers.modelo.OptimusPrime;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.Ratchet;
import tp2.algoformers.modelo.Tablero;
import tp2.algoformers.modelo.Vehiculo;
import tp2.algoformers.modelo.VehiculoTerrestre;

public class AlgoformerTest {
    
   
    @Test
    public void test01cuandoCreoUnAlgoformerEsHumanoide(){
        Algoformer algoformer = new Megatron();
        Class estado = algoformer.estado().getClass();
        Humanoide humanoide = new Humanoide();
        Class estadoActual = humanoide.getClass();
        Assert.assertTrue(estado == estadoActual);
    }
    
    //Este test es medio asqueroso, hay que overridear el equals para hacerlo bien
    @Test
    public void test02puedoTransformarUnAlgoformerEnAmbasDirecciones(){
        Algoformer algoformer = new OptimusPrime();
        algoformer.transformar();
        Class estado = algoformer.estado().getClass();
        Vehiculo vehiculo = new VehiculoTerrestre();
        Class estadoActual = vehiculo.getClass();
        Assert.assertTrue(estado == estadoActual);
        algoformer.transformar();
        estado = algoformer.estado().getClass();
        Humanoide humanoide = new Humanoide();
        estadoActual = humanoide.getClass();
        Assert.assertTrue(estado == estadoActual);
    }
    
    @Test
    public void test03siUnAutobotAtacaUnDecepticonEstePierdeVida(){
        Tablero tablero = Tablero.getTablero();
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(9,10, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(12, 12, decepticon);
        decepticon.atacadoPor(autobot);
        Assert.assertTrue(decepticon.puntosDeVida() == 195);
    }
    
    @Test
    public void test04siUnDecepticonAtacaAUnAutobotEsteUltimoPierdeVida(){
        Tablero tablero = Tablero.getTablero();
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(10,10, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(11, 10, decepticon);
        autobot.atacadoPor(decepticon);
        Assert.assertTrue(autobot.puntosDeVida() == 120);
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test05AutobotNoPuedeAtacarMasLejosQueSuDistanciaDeAtaque(){
        Tablero tablero = Tablero.getTablero();
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(15,4, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(20, 13, decepticon);
        decepticon.atacadoPor(autobot);
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test06DecepticonNoPuedeAtacarMasLejosQueSuDistanciaDeAtaque(){
        Tablero tablero = Tablero.getTablero();
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(14,4, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(20, 40, decepticon);
        autobot.atacadoPor(decepticon);
    }
    
    @Test(expected=NoPuedoAtacarUnCompanieroException.class)
    public void test07AlgoformersDeMismoBandoNoSePuedenAtacar(){
        Tablero tablero = Tablero.getTablero();
        Algoformer decepticon1 = new Megatron();
        tablero.ubicarAlgoformerEnUnaPosicion(13,13, decepticon1);
        Algoformer decepticon2 = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(13, 15, decepticon2);
        decepticon1.atacadoPor(decepticon2);
    }
    
    @Test
    public void test08CuandoUnAlgoformerSeAtacaASiMismoSeTransforma(){
        Algoformer unAlgoformer = new Ratchet();
        unAlgoformer.atacadoPor(unAlgoformer);
        Assert.assertTrue(unAlgoformer.getVelocidad()== 8);
    }
    
}
