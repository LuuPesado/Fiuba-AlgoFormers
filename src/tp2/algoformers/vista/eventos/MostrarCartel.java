package tp2.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import tp2.algoformers.modelo.Tablero;

public class MostrarCartel implements EventHandler<ActionEvent>{

		private final Tablero tablero;
		
	    public MostrarCartel() {
	        tablero = Tablero.getTablero();
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	    	tablero.fila(posicion)
	    }
}
