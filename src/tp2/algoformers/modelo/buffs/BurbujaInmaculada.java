package tp2.algoformers.modelo.buffs;

public class BurbujaInmaculada extends Buff{

	public BurbujaInmaculada(int fila, int columna) {
		super(fila, columna);
		duracion = 2;
		nombre = "Burbuja";
	}

	public int afectarDanio() {
		return 0;
	}
	

}
