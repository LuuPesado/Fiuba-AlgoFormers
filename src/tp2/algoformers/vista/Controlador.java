package tp2.algoformers.vista;

import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.vista.eventos.BotonFusionarEventHandler;
import tp2.algoformers.vista.eventos.BotonJugarEventHandler;

public class Controlador {

	private static Controlador instance = null;
	private BotonJugarEventHandler botonJugar;
	private NuestroContenedorPrincipal contenedor;
	private BotonFusionarEventHandler botonFusionar;
	
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
		botonFusionar.recibirContenido(elegido);
	}
	
	public void getContenedorPrincipal(NuestroContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}
	
	public void update(){
		contenedor.update();
	}

	public void recibirBotonFusionar(BotonFusionarEventHandler botonFusionar) {
		this.botonFusionar = botonFusionar;
	}
}
