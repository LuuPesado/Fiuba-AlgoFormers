package tp2.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2.algoformers.vista.Controlador;

public class BotonBorrarEventHandler implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent arg0) {
		this.borrrarTextFields();
		}

	private void borrrarTextFields() {
		Controlador.getControlador().getContenedorJuego().getCampoNombreJugador1().clear();
		Controlador.getControlador().getContenedorJuego().getCampoNombreJugador2().clear();
	}
}
