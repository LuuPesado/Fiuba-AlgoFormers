import tp2.algoformers.modelo.Celda;
import org.junit.Test;
import org.junit.Assert;

import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.algoformers.Megatron;
import tp2.algoformers.modelo.algoformers.OptimusPrime;
import tp2.algoformers.modelo.excepciones.LaCeldaYaTieneUnAlgoformer;

public class CeldaTest {
    
    @Test
    public void test01alCrearLaCeldaEstaLibre(){
        Celda celda = new Celda(1,3);
        Assert.assertEquals("La celda no estaba libre",false,celda.estaOcupada());
    }
    
    @Test 
    public void test02laCeldaDeberiaTenerUnAlgoformer(){
        Celda celda = new Celda(1,3);
        Algoformer algoformer = new OptimusPrime();
        celda.agregarAlgoformer(algoformer);
        Assert.assertTrue(celda.estaOcupada());
    }
    
    @Test ( expected = LaCeldaYaTieneUnAlgoformer.class )
    public void test03siLaCeldaYaTeniaUnAlgoformerYQuieroPonerOtroMeDaError(){
        Algoformer algoformer1 = new OptimusPrime();
        Algoformer algoformer2 = new Megatron();
        Celda celda = new Celda(1,3);
        celda.agregarAlgoformer(algoformer1);
        celda.agregarAlgoformer(algoformer2);
    }
    


}
