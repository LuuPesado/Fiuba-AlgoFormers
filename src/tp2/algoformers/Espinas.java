
package tp2.algoformers;


public class Espinas extends TerrenoTerrestre {

  
    @Override
    public void afectarHumanoide(Algoformer unAlgoformer) {
        int daño = unAlgoformer.puntosDeVida();
        daño = daño*5/100;
        unAlgoformer.recibirDanio(daño);
    }

    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
        int daño = unAlgoformer.puntosDeVida();
        daño = daño*5/100;
        unAlgoformer.recibirDanio(daño);
    }
   
}
