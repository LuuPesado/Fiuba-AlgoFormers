
package tp2.algoformers.modelo.terrenos;

import tp2.algoformers.modelo.algoformers.Algoformer;

public class Rocosa extends TerrenoTerrestre{

	private String direccionDeImagen;
	
	public Rocosa(){
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/RocosoTablero.png";
	}
	
    @Override
    public void afectarHumanoide(Algoformer unAlgoformer) {
        
    }

    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
        
    }

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}


}
