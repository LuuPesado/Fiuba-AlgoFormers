
package tp2.algoformers.modelo.terrenos;

import tp2.algoformers.modelo.algoformers.Algoformer;

public class Nube extends TerrenoAereo{

	private String direccionDeImagen;
	
	public Nube(){
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/NubeTablero.png";
	}
	
    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
        
    }

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}

}
