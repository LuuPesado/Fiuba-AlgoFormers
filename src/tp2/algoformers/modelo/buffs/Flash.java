package tp2.algoformers.modelo.buffs;

public class Flash extends Buff{

	private String direccionDeImagen;

	public Flash(int fila, int columna) {
		super(fila, columna);
		duracion = 4;
		nombre = "Flash";
		direccionDeImagen = "file:src/tp2/algoformers/vista/imagenes/tablero/Flash.png";
	}

	public int afectarVelocidad(int velocidad) {
		return velocidad*3;
	}

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}
	
}
