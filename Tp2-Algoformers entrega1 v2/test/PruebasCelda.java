import tp2.algoformers.Algoformer;
import tp2.algoformers.Celda;
import org.junit.Test;
import org.junit.Assert;
import tp2.algoformers.LaCeldaYaTieneUnAlgoformer;
import tp2.algoformers.Megatron;
import tp2.algoformers.OptimusPrime;

public class PruebasCelda {
    
    @Test
    public void test01alCrearLaCeldaEstaLibre(){
        Celda celda = new Celda();
        Assert.assertEquals("La celda no estaba libre",false,celda.estaOcupada());
    }
    
    @Test 
    public void test02laCeldaDeberiaTenerUnAlgoformer(){
        Celda celda = new Celda();
        Algoformer algoformer = new OptimusPrime();
        celda.agregarAlgoformer(algoformer);
        Assert.assertTrue(celda.estaOcupada());
    }
    
    @Test ( expected = LaCeldaYaTieneUnAlgoformer.class )
    public void test03siLaCeldaYaTeniaUnAlgoformerYQuieroPonerOtroMeDaError(){
        Algoformer algoformer1 = new OptimusPrime();
        Algoformer algoformer2 = new Megatron();
        Celda celda = new Celda();
        celda.agregarAlgoformer(algoformer1);
        celda.agregarAlgoformer(algoformer2);
    }

}
