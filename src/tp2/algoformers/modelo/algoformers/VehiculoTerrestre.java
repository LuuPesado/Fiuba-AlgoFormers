
package tp2.algoformers.modelo.algoformers;

import tp2.algoformers.modelo.Celda;

public class VehiculoTerrestre extends Vehiculo {

    @Override
    public void atravesarTerreno(Celda celda,Algoformer unAlgoformer) {
       celda.afectarVehiculoTerrestre(unAlgoformer);
    }
    
}
