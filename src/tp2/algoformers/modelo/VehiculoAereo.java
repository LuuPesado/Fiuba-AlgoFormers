
package tp2.algoformers.modelo;


public class VehiculoAereo extends Vehiculo {

    @Override
    public void atravesarTerreno(Celda celda,Algoformer unAlgoformer) {
        celda.afectarVehiculoAereo(unAlgoformer);
    }
    
}
