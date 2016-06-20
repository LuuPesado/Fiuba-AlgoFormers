
package tp2.algoformers.modelo;


public class NebulosaDeAndromeda extends TerrenoAereo {

	private String direccionDeImagen;
	
	public NebulosaDeAndromeda(){
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/NebulosaTablero.png";
	}
	
    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
    	unAlgoformer.agregarDebuff(new AfectadoPorNebulosa());
    }

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}

}
