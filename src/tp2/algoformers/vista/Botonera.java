/**
 * 
 */
package tp2.algoformers.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import tp2.algoformers.modelo.Juego;
import tp2.algoformers.vista.eventos.BotonJugarEventHandler;

public class Botonera extends BorderPane {
	
	private Juego juego;
	private ContenedorTablero contenedorTablero;
	
	public Botonera (Juego juego, ContenedorTablero tablero){
		this.contenedorTablero= tablero;
		this.juego = juego;
		HBox contenedorBotones = new HBox();
		contenedorBotones.getChildren().add(this.setBotonJugar());
		contenedorBotones.getChildren().add(this.setBotonFusionar());
	    contenedorBotones.setSpacing(10);
	    contenedorBotones.setPadding(new Insets(15));
		this.setCenter(contenedorBotones);

	}

	private Button setBotonJugar() {
		Button botonJugar = new Button("Jugar");
		BotonJugarEventHandler jugarEventHandler = new BotonJugarEventHandler(juego, contenedorTablero);
		botonJugar.setOnAction(jugarEventHandler);
		return botonJugar;
	}

	private Button setBotonFusionar() {
		Button botonFusionar = new Button("Fusionar");
		return botonFusionar;
	}
}
