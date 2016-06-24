import org.junit.Assert;
import org.junit.Test;
import tp2.algoformers.modelo.Algoformer;
import tp2.algoformers.modelo.Bonecrusher;
import tp2.algoformers.modelo.FueraDeRangoException;
import tp2.algoformers.modelo.Humanoide;
import tp2.algoformers.modelo.Megatron;
import tp2.algoformers.modelo.NoPuedoAtacarUnCompanieroException;
import tp2.algoformers.modelo.OptimusPrime;
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
        Algoformer autobot = new Ratchet();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(9,10, autobot);
        Algoformer decepticon = new Bonecrusher();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(12, 12, decepticon);
        decepticon.atacadoPor(autobot);
        Assert.assertTrue(decepticon.puntosDeVida() == 195);
        Tablero.getTablero().reiniciarTablero();        
    }
    
    @Test
    public void test04siUnDecepticonAtacaAUnAutobotEsteUltimoPierdeVida(){
        Algoformer autobot = new Ratchet();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(10,10, autobot);
        Algoformer decepticon = new Bonecrusher();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(11, 10, decepticon);
        autobot.atacadoPor(decepticon);
        Assert.assertTrue(autobot.puntosDeVida() == 120);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test05AutobotNoPuedeAtacarMasLejosQueSuDistanciaDeAtaque(){
        Algoformer autobot = new Ratchet();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(15,4, autobot);
        Algoformer decepticon = new Bonecrusher();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(16, 13, decepticon);
        decepticon.atacadoPor(autobot);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test06DecepticonNoPuedeAtacarMasLejosQueSuDistanciaDeAtaque(){
        Algoformer autobot = new Ratchet();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(1,4, autobot);
        Algoformer decepticon = new Bonecrusher();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(17, 18, decepticon);
        autobot.atacadoPor(decepticon);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test(expected=NoPuedoAtacarUnCompanieroException.class)
    public void test07AlgoformersDeMismoBandoNoSePuedenAtacar(){
        Algoformer decepticon1 = new Megatron();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(13,13, decepticon1);
        Algoformer decepticon2 = new Bonecrusher();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(13, 15, decepticon2);
        decepticon1.atacadoPor(decepticon2);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test
    public void test08CuandoUnAlgoformerSeAtacaASiMismoSeTransforma(){
        Algoformer unAlgoformer = new Ratchet();
        unAlgoformer.atacadoPor(unAlgoformer);
        Assert.assertTrue(unAlgoformer.getVelocidad()== 8);
    }
    
}
