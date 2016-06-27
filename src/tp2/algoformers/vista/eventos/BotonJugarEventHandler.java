package tp2.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.modelo.Juego;
import tp2.algoformers.modelo.Jugador;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.vista.ContenedorTablero;

public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugador;
	private Algoformer unAlgoformer;
	private Posicion unaPosicion;
	private ContenedorTablero contenedorTablero;
	
	public BotonJugarEventHandler(Juego juego, ContenedorTablero contenedorTablero) {
		this.jugador = juego.getTurno().jugadorActual();
		this.contenedorTablero = contenedorTablero;
	}

	public void recibirContenido(Contenido unContenido){
		if (unContenido.esUnAlgoformer()){
			unAlgoformer = ( (Algoformer) unContenido );
		} else {
			unaPosicion = unContenido.getPosicion();
		}
	}
	
	
	@Override
	public void handle(ActionEvent arg0) {
		if ((unAlgoformer != null) && (unaPosicion != null)){
		jugador.jugar(unAlgoformer, unaPosicion);
		this.contenedorTablero.dibujar();
		}
	}

}
