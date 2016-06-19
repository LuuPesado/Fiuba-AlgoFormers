
package tp2.algoformers.modelo;


public class VehiculoTerrestre extends Vehiculo {

    @Override
    public void atravesarTerreno(Celda celda,Algoformer unAlgoformer) {
       celda.afectarVehiculoTerrestre(unAlgoformer);
    }
    
}
