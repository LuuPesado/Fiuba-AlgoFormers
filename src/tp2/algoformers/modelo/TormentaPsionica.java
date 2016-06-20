
package tp2.algoformers.modelo;


public class TormentaPsionica extends TerrenoAereo{

	private String direccionDeImagen;
	
	public TormentaPsionica(){
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/TormentaTablero.png";
	}
	
    @Override
    public void afectarVehiculo(Algoformer unAlgoformer) {
    	if (!unAlgoformer.afectadoPorDebuff( new AfectadoPorTormenta() )){
        	unAlgoformer.setAtaque(unAlgoformer.getAtaque() - unAlgoformer.getAtaque()*40/100);
        	unAlgoformer.agregarDebuff(new AfectadoPorTormenta());
    	}
    	
    }

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}
	
}
