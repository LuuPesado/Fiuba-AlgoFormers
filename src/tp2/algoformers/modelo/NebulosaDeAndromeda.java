
package tp2.algoformers.modelo;


public class NebulosaDeAndromeda extends TerrenoAereo {


    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
    	unAlgoformer.agregarDebuff(new AfectadoPorNebulosa());
    }

}
