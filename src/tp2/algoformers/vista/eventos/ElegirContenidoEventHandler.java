package tp2.algoformers.vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.vista.Controlador;

public class ElegirContenidoEventHandler implements EventHandler<MouseEvent> {
	
	private Contenido contenido;
	
	public ElegirContenidoEventHandler(Contenido unContenido){
		this.contenido = unContenido;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		Controlador.getControlador().darContenido(contenido);
		
	}

}
