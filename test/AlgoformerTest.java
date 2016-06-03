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

public class AlgoformerTest {
    
   
    @Test
    public void test01cuandoCreoUnAlgoformerEsHumanoide(){
        Algoformer algoformer = new Megatron();
        Humanoide humanoide = Humanoide.getInstance();
        Assert.assertTrue(algoformer.estado().equals(Humanoide.getInstance()));
    }
    
    @Test
    public void test02puedoTransformarUnAlgoformerEnAmbasDirecciones(){
        Algoformer algoformer = new OptimusPrime();
        algoformer.transformar();
        Assert.assertTrue(algoformer.estado().equals(Vehiculo.getInstance()));
        algoformer.transformar();
        Assert.assertTrue(algoformer.estado().equals(Humanoide.getInstance()));
    }
    
    @Test
    public void test03siUnAutobotAtacaUnDecepticonEstePierdeVida(){
        Tablero tablero = Tablero.getTablero();
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(10,10, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(13, 12, decepticon);
        autobot.atacar(decepticon);
        org.junit.Assert.assertTrue(decepticon.puntosDeVida() == 195);
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test04AutobotNoPuedeAtacarMasLejosQueSuDistanciaDeAtaque(){
        Tablero tablero = Tablero.getTablero();
        Algoformer autobot = new Ratchet();
        tablero.ubicarAlgoformerEnUnaPosicion(14,4, autobot);
        Algoformer decepticon = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(20, 4, decepticon);
        autobot.atacar(decepticon);
    }
    
    @Test(expected=NoPuedoAtacarUnCompanieroException.class)
    public void test05AlgoformersDeMismoBandoNoSePuedenAtacar(){
        Tablero tablero = Tablero.getTablero();
        Algoformer decepticon1 = new Megatron();
        tablero.ubicarAlgoformerEnUnaPosicion(13,13, decepticon1);
        Algoformer decepticon2 = new Bonecrusher();
        tablero.ubicarAlgoformerEnUnaPosicion(13, 15, decepticon2);
        decepticon1.atacar(decepticon2);
    }
    
}
