
package tp2.algoformers;


public class TormentaPsionica extends TerrenoAereo{

    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
    	if (!unAlgoformer.afectadoPorDebuff( new AfectadoPorTormenta() )){
        	unAlgoformer.setAtaque(unAlgoformer.getAtaque() - unAlgoformer.getAtaque()*40/100);
        	unAlgoformer.agregarDebuff(new AfectadoPorTormenta());
    	}
    	
    }
}
