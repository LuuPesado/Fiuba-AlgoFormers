
package tp2.algoformers.modelo.terrenos;

import tp2.algoformers.modelo.AfectadoPorTormenta;
import tp2.algoformers.modelo.algoformers.Algoformer;

public class TormentaPsionica extends TerrenoAereo{

	private String direccionDeImagen;
	
	public TormentaPsionica(){
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/tablero/TormentaTablero.png";
	}
	
    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
    	if (!unAlgoformer.afectadoPorDebuff( new AfectadoPorTormenta() )){
        	unAlgoformer.setAtaque(unAlgoformer.getAtaque() - unAlgoformer.getAtaque()*40/100);
        	unAlgoformer.agregarDebuff(new AfectadoPorTormenta());
    	}
    	
    }

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}
	
}
