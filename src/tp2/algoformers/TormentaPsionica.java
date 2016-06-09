
package tp2.algoformers;


public class TormentaPsionica extends TerrenoAereo{

    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
        if (!unAlgoformer.afectadoPorTormenta){
        	int ataque = unAlgoformer.getAtaque() - unAlgoformer.getAtaque()*40/100; 
        	unAlgoformer.setAtaque(ataque);
        }
    	unAlgoformer.afectadoPorTormenta = true;
    }
    
}
