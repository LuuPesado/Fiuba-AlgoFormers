package tp2.algoformers.modelo;

public class Flash extends Buff{

	public Flash(int fila, int columna) {
		super(fila, columna);
		duracion = 3;
		nombre = "Flash";
	}

	public int afectarVelocidad(int velocidad) {
		return velocidad*3;
	}

}
