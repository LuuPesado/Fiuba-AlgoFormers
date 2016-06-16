package tp2.algoformers;

public class Buff implements Contenido{

	
	public Posicion posicion;
	public int duracion;
	    
	public Buff(int fila, int columna) {
		posicion = new Posicion(fila, columna);
	}
	
	public boolean esUnBonus(){
    	return true;
    }

	@Override
	public boolean estaOcupado() {
		return false;
	}

	@Override
	public void atacadoPor(Algoformer unAlgoformer) {
		unAlgoformer.moverAlgoformer(posicion.getFila(), posicion.getColumna());
	}

	@Override
	public Posicion getPosicion() {
		return posicion;
	}
    
	public void bajarDuracion(){
		duracion--;
	}
}
