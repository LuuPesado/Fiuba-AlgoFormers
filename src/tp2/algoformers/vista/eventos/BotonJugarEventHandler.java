package tp2.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.modelo.Juego;
import tp2.algoformers.modelo.Jugador;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.vista.ContenedorTablero;
import tp2.algoformers.vista.Controlador;

public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugador;
	private Algoformer unAlgoformer = null;
	private Posicion unaPosicion;
	private ContenedorTablero contenedorTablero;
	
	public BotonJugarEventHandler(Juego juego, ContenedorTablero contenedorTablero) {
		this.jugador = juego.getTurno().jugadorActual();
		this.contenedorTablero = contenedorTablero;
	}

	//Hay que modificar esto pero masomenos funciona, de esta forma si se toca al Algoformer una vez y despues "jugar" se transforma.
	public void recibirContenido(Contenido unContenido){
		if (unContenido.esUnAlgoformer() && (unAlgoformer == null)){
			unAlgoformer = ( (Algoformer) unContenido );
			unaPosicion = unContenido.getPosicion();
		} else {
			unaPosicion = unContenido.getPosicion();
		}
		if (unAlgoformer != null){
			unaPosicion = unContenido.getPosicion();
		}
	}
	
	
	@Override
	public void handle(ActionEvent arg0) {
		if ((unAlgoformer != null) && (unaPosicion != null)){
		jugador.jugar(unAlgoformer, unaPosicion);
		this.contenedorTablero.dibujar();
		Controlador.getControlador().update();
		}
		unAlgoformer = null;
	}

}
