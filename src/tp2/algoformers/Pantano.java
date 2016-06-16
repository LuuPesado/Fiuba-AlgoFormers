
package tp2.algoformers;


public class Pantano extends TerrenoTerrestre {

    @Override
    public void afectarHumanoide(Algoformer unAlgoformer) {
        throw new UnHumanoideNoPuedeCruzarUnPantano();
    }

    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
        unAlgoformer.agregarDebuff(new AfectadoPorPantano());
    }

}
