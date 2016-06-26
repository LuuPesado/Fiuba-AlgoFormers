package tp2.algoformers.vista;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tp2.algoformers.modelo.Juego;
import tp2.algoformers.modelo.Jugador;
import tp2.algoformers.modelo.Tablero;
import tp2.algoformers.modelo.terrenos.Nube;
import tp2.algoformers.modelo.terrenos.Rocosa;
import tp2.algoformers.vista.BarraDeMenu;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class NuestroContenedorPrincipal extends BorderPane {
	 BarraDeMenu menuBar;
	 Canvas canvasCentral;
	 
	 public NuestroContenedorPrincipal(Stage stage){
		 Jugador jugador1 = new Jugador("Autobots");
		 Jugador jugador2 = new Jugador("Decepticons");
		 Juego juego = new Juego(jugador1, jugador2);
		 juego.crearTablero();
		 this.setJugador1(jugador1);
		 this.setJugador2(jugador2);
		 this.setMenu(stage);
		 this.setTablero();
	 }
	
	 private void setMenu(Stage stage) {
	    this.menuBar = new BarraDeMenu(stage);
	    this.setTop(menuBar);
	}

	 private void setTablero(){
		 Tablero tablero = Tablero.getTablero();
		 Rocosa rocosa = new Rocosa();
		 Nube nube = new Nube();
		 ContenedorTablero contenedorTablero = new ContenedorTablero(tablero, rocosa, nube);
		 
		 VBox contenedorVertical = new VBox(contenedorTablero);
	     contenedorVertical.setSpacing(10);
	     contenedorVertical.setPadding(new Insets(15));
	     this.setCenter(contenedorVertical);
	 }
	 
	 private void setJugador1(Jugador unJugador){
		Label nombreJugador1 = new Label();
		nombreJugador1.setText(unJugador.getNombre());
		nombreJugador1.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		nombreJugador1.setTextFill(Color.BLACK);

		
     	VBox contenedorVertical1 = new VBox(nombreJugador1);
		contenedorVertical1.setSpacing(10);
		contenedorVertical1.setPadding(new Insets(15));	 
	    
	     for  (int i=0; i<unJugador.getAlgoformers().size(); i++){
	    	 ContenedorAlgoformer unContenedor = new ContenedorAlgoformer(unJugador.getAlgoformers().get(i));
	    	 contenedorVertical1.getChildren().add(unContenedor);
	     }
    
	     this.setLeft(contenedorVertical1);

	 }
	 
	 private void setJugador2(Jugador unJugador){
		Label nombreJugador1 = new Label();
		nombreJugador1.setText(unJugador.getNombre());
		nombreJugador1.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		nombreJugador1.setTextFill(Color.BLACK);

		
     	VBox contenedorVertical1 = new VBox(nombreJugador1);
		contenedorVertical1.setSpacing(10);
		contenedorVertical1.setPadding(new Insets(15));

	     for  (int i=0; i<unJugador.getAlgoformers().size(); i++){
	    	 ContenedorAlgoformer unContenedor = new ContenedorAlgoformer(unJugador.getAlgoformers().get(i));
	    	 contenedorVertical1.getChildren().add(unContenedor);
	     }
    
	     this.setRight(contenedorVertical1);

	 }
		 
}

