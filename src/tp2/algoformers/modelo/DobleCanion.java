package tp2.algoformers.modelo;

public class DobleCanion extends Buff{

	public DobleCanion(int fila, int columna) {
		super(fila, columna);
		duracion = 3;
		nombre = "Canion";
	}

	public int afectarAtaque(int ataque){
		return ataque*2;
	} 

}
