
package tp2.algoformers.modelo.terrenos;

import tp2.algoformers.modelo.algoformers.Algoformer;

public class Espinas extends TerrenoTerrestre {

	private String direccionDeImagen;
	
	public Espinas(){
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/tablero/EspinasTablero.png";
	}
	
    @Override
    public void afectarHumanoide(Algoformer unAlgoformer) {
        int danio = unAlgoformer.puntosDeVida();
        danio = danio*5/100;
        unAlgoformer.recibirDanio(danio);
    }

    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
        int danio = unAlgoformer.puntosDeVida();
        danio = danio*5/100;
        unAlgoformer.recibirDanio(danio);
    }

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}
   
}
