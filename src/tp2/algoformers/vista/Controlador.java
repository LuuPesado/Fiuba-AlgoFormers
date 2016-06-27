package tp2.algoformers.vista;

import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.vista.eventos.BotonJugarEventHandler;

public class Controlador {

	private static Controlador instance = null;
	private BotonJugarEventHandler botonJugar;
	
	private Controlador(){
		
	}
	
	public static Controlador getControlador(){
	       if (Controlador.instance == null){
	           Controlador.instance = new Controlador();
	       }
	       return Controlador.instance;
	    }

	public void recibirBotonJugar(BotonJugarEventHandler botonJugar){
		this.botonJugar = botonJugar;
	}
	
	
	public void darContenido(Contenido elegido) {
		botonJugar.recibirContenido(elegido);
	}
	    
}
