import tp2.algoformers.modelo.Columna;
import org.junit.Test;
import org.junit.Assert;

public class ColumnaTest {
    
    @Test 
    public void test01laColumnaDeberiaTenerCeldasVacias(){
        Columna columna = new Columna(1,8);
        boolean ocupada = columna.celda(3).estaOcupada();
        Assert.assertEquals("La celda estaba ocupada",false,ocupada);
    }
    
}
