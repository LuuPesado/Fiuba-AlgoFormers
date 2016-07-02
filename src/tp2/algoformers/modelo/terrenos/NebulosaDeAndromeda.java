
package tp2.algoformers.modelo.terrenos;

import tp2.algoformers.modelo.AfectadoPorNebulosa;
import tp2.algoformers.modelo.algoformers.Algoformer;

public class NebulosaDeAndromeda extends TerrenoAereo {

	private String direccionDeImagen;
	
	public NebulosaDeAndromeda(){
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/tablero/NebulosaTablero.png";
	}
	
    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
    	unAlgoformer.agregarDebuff(new AfectadoPorNebulosa());
    }

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}

}
