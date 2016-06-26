package tp2.algoformers.modelo.buffs;

import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.algoformers.Algoformer;

public class Buff implements Contenido{

	
	protected Posicion posicion;
	protected int duracion;
	protected String nombre;
	    
	public Buff(int fila, int columna) {
		posicion = new Posicion(fila, columna);
	}
	
	public boolean esUnBuff(){
    	return true;
    }

	public boolean hayChispa(){
		return false;
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
	
	public String getNombre(){
		return this.nombre;
	}
	
	public boolean equals(Object unBuff){
		return ((Buff) unBuff).getNombre() == this.nombre;
	}

	@Override
	public void setDireccionDeImagen(String unaDireccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDireccionDeImagen() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
