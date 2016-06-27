package tp2.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	
	public BotonJugarEventHandler(Juego juego, ContenedorTablero contenedor) {
		this.jugador = juego.getTurno().jugadorActual();
		this.unaPosicion = new Posicion(2,2);
		this.unAlgoformer = jugador.getAlgoformers().get(1);
		this.contenedorTablero = contenedor;
	}
	@Override
	public void handle(ActionEvent arg0) {
		
		jugador.jugar(unAlgoformer, unaPosicion);
		this.contenedorTablero.dibujar();
	}

}
