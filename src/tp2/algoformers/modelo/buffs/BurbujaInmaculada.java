package tp2.algoformers.modelo.buffs;

public class BurbujaInmaculada extends Buff{

	private String direccionDeImagen;

	public BurbujaInmaculada(int fila, int columna) {
		super(fila, columna);
		duracion = 3;
		nombre = "Burbuja";
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/tablero/BurbujaInmaculada.png";
	}

	public int afectarDanio() {
		return 0;
	}
	
	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}
	
}
