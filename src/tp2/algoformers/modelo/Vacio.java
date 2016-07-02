package tp2.algoformers.modelo;

import tp2.algoformers.modelo.algoformers.Algoformer;

public class Vacio implements Contenido{
	
    private Posicion posicion;
    private String direccionDeImagen;
    public Vacio(int fila, int columna) {
        posicion = new Posicion(fila, columna);
        this.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/tablero/transparente.png");
    }
    
    
    public boolean estaOcupado(){
        return false;
    }
    
    public boolean esUnBuff(){
    	return false;
    }
    
    public boolean esUnAlgoformer(){
    	return false;
    }
    
    public void atacadoPor(Algoformer unAlgoformer) {
        unAlgoformer.moverAlgoformer(posicion.getFila(), posicion.getColumna());
    }
    
    public Posicion getPosicion(){
        return posicion;
    }

    public boolean hayChispa(){
    	return false;
    }
	@Override
	public void setDireccionDeImagen(String unaDireccion) {
		direccionDeImagen = unaDireccion;
		
	}

	@Override
	public String getDireccionDeImagen() {
		return this.direccionDeImagen;
	}
    
    
}
