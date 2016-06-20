package tp2.algoformers.vista;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tp2.algoformers.vista.BarraDeMenu;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class NuestroContenedorPrincipal extends BorderPane {
	 BarraDeMenu menuBar;
	 Canvas canvasCentral;
	 
	 public NuestroContenedorPrincipal(Stage stage){
		 this.setMenu(stage);
		 this.setJugador1();
	 }
	
	 private void setMenu(Stage stage) {
	    this.menuBar = new BarraDeMenu(stage);
	    this.setTop(menuBar);
	}
	 private void setJugador1(){
		 
		 Label nombreJugador1 = new Label();
		 nombreJugador1.setText("Jugador1");
		 nombreJugador1.setFont(Font.font("courier new", FontWeight.BOLD, 24));
	     nombreJugador1.setTextFill(Color.BLACK);
		 
		 VBox contenedorVertical1 = new VBox(nombreJugador1);
	     contenedorVertical1.setSpacing(10);
	     contenedorVertical1.setPadding(new Insets(15));
	     this.setLeft(contenedorVertical1);
	     
		 Label nombreJugador2 = new Label();
		 nombreJugador2.setText("Jugador2");
		 nombreJugador2.setFont(Font.font("courier new", FontWeight.BOLD, 24));
	     nombreJugador2.setTextFill(Color.BLACK);
		 
		 VBox contenedorVertical2 = new VBox(nombreJugador2);
	     contenedorVertical2.setSpacing(10);
	     contenedorVertical2.setPadding(new Insets(15));
	     
	     this.setRight(contenedorVertical2);
	 }
	
}
