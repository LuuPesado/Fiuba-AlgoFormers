
package tp2.algoformers;


public class TormentaPsionica extends TerrenoAereo{

    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
        
    	unAlgoformer.agregarDebuff(new AfectadoPorTormenta());
        
    }
    
}
