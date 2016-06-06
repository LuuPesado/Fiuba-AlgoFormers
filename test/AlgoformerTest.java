import org.junit.Assert;
import org.junit.Test;
import tp2.algoformers.Algoformer;
import tp2.algoformers.Bonecrusher;
import tp2.algoformers.FueraDeRangoException;
import tp2.algoformers.Humanoide;
import tp2.algoformers.Megatron;
import tp2.algoformers.NoPuedoAtacarUnCompanieroException;
import tp2.algoformers.OptimusPrime;
import tp2.algoformers.Ratchet;
import tp2.algoformers.Tablero;
import tp2.algoformers.Vehiculo;
import tp2.algoformers.VehiculoTerrestre;

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
        autobot.atacar(decepticon);
        org.junit.Assert.assertTrue(decepticon.puntosDeVida() == 195);
    }
    
    @Test
    public void test04siUnDecepticonAtacaAUnAutobotEsteUltimoPierdeVida(){
        Tablero tablero = Tablero.getTablero();
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(10,10, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(11, 10, decepticon);
        decepticon.atacar(autobot);
        org.junit.Assert.assertTrue(autobot.puntosDeVida() == 120);
    }
    @Test(expected=FueraDeRangoException.class)
    public void test05AutobotNoPuedeAtacarMasLejosQueSuDistanciaDeAtaque(){
        Tablero tablero = Tablero.getTablero();
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(15,4, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(20, 13, decepticon);
        autobot.atacar(decepticon);
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test06DecepticonNoPuedeAtacarMasLejosQueSuDistanciaDeAtaque(){
        Tablero tablero = Tablero.getTablero();
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(14,4, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(20, 40, decepticon);
        decepticon.atacar(autobot);
    }
    
    @Test(expected=NoPuedoAtacarUnCompanieroException.class)
    public void test07AlgoformersDeMismoBandoNoSePuedenAtacar(){
        Tablero tablero = Tablero.getTablero();
        Algoformer decepticon1 = new Megatron();
        tablero.ubicarAlgoformerEnUnaPosicion(13,13, decepticon1);
        Algoformer decepticon2 = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(13, 15, decepticon2);
        decepticon1.atacar(decepticon2);
    }
    
    @Test(expected=NoPuedoAtacarUnCompanieroException.class)
    public void test08UnAlgoformerNoSePuedeAtacarASiMismo(){
        Tablero tablero = Tablero.getTablero();
        Algoformer unAlgoformer = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(32,13, unAlgoformer);
        unAlgoformer.atacar(unAlgoformer);
    }
}
