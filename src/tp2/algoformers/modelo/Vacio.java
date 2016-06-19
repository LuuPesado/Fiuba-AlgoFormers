package tp2.algoformers.modelo;

public class Vacio implements Contenido{
	
    public Posicion posicion;
    
    public Vacio(int fila, int columna) {
        posicion = new Posicion(fila, columna);
    }
    
    public boolean estaOcupado(){
        return false;
    }
    
    public boolean esUnBuff(){
    	return false;
    }
    

    public void atacadoPor(Algoformer unAlgoformer) {
        unAlgoformer.moverAlgoformer(posicion.getFila(), posicion.getColumna());
    }
    
    public Posicion getPosicion(){
        return posicion;
    }
    
    
}
