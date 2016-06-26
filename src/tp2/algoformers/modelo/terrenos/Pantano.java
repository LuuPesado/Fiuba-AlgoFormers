
package tp2.algoformers.modelo.terrenos;

import tp2.algoformers.modelo.AfectadoPorPantano;
import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.excepciones.UnHumanoideNoPuedeCruzarUnPantano;

public class Pantano extends TerrenoTerrestre {

	private String direccionDeImagen;
	
	public Pantano(){
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/PantanoTablero.png";
	}
	
    @Override
    public void afectarHumanoide(Algoformer unAlgoformer) {
        throw new UnHumanoideNoPuedeCruzarUnPantano();
    }

    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
        unAlgoformer.agregarDebuff(new AfectadoPorPantano());
    }

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}

}
