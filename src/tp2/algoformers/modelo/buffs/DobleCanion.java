package tp2.algoformers.modelo.buffs;

public class DobleCanion extends Buff{

	private String direccionDeImagen;

	public DobleCanion(int fila, int columna) {
		super(fila, columna);
		duracion = 4;
		nombre = "Canion";
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/tablero/DobleCanion.png";
	}

	public int afectarAtaque(int ataque){
		return ataque*2;
	} 
	
	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}
	
}
