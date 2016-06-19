
package tp2.algoformers.modelo;


public class Espinas extends TerrenoTerrestre {

  
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
   
}
