import tp2.algoformers.Columna;
import org.junit.Test;
import org.junit.Assert;

public class PruebasColumna {
    
    @Test 
    public void test01laColumnaDeberiaTenerCeldasVacias(){
        Columna columna = new Columna(8);
        boolean ocupada = columna.celda(3).estaOcupada();
        Assert.assertEquals("La celda estaba ocupada",false,ocupada);
    }
    
}
