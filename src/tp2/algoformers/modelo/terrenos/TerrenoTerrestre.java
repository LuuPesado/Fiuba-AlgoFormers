
package tp2.algoformers.modelo.terrenos;

import tp2.algoformers.modelo.algoformers.Algoformer;

public abstract class TerrenoTerrestre {
    
    public abstract void afectarVehiculo(Algoformer unAlgoformer);

    public abstract void afectarHumanoide(Algoformer unAlgoformer);
    
    public abstract String getDireccionDeImagen();
    
}
