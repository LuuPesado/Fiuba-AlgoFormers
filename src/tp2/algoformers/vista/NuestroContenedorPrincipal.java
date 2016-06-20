package tp2.algoformers.vista;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tp2.algoformers.modelo.Algoformer;
import tp2.algoformers.modelo.Bonecrusher;
import tp2.algoformers.modelo.Bumblebee;
import tp2.algoformers.modelo.Frenzy;
import tp2.algoformers.modelo.Megatron;
import tp2.algoformers.modelo.Nube;
import tp2.algoformers.modelo.OptimusPrime;
import tp2.algoformers.modelo.Ratchet;
import tp2.algoformers.modelo.Rocosa;
import tp2.algoformers.modelo.Tablero;
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
		 this.setTablero();
	 }
	
	 private void setMenu(Stage stage) {
	    this.menuBar = new BarraDeMenu(stage);
	    this.setTop(menuBar);
	}
	 
	 private void setJugador1(){
		 
		 Label nombreJugador1 = new Label();
		 nombreJugador1.setText("Autobots");
		 nombreJugador1.setFont(Font.font("courier new", FontWeight.BOLD, 24));
	     nombreJugador1.setTextFill(Color.BLACK);
		 
	     Algoformer optimus = new OptimusPrime();
	     ContenedorAlgoformer contenedorOptimus = new ContenedorAlgoformer(optimus);
	     
	     Algoformer bumblebee = new Bumblebee();
	     bumblebee.transformar();
	     ContenedorAlgoformer contenedorBumblebee = new ContenedorAlgoformer(bumblebee);
	     
	     Algoformer ratchet = new Ratchet();
	     ContenedorAlgoformer contenedorRatchet = new ContenedorAlgoformer(ratchet);
	     
	     
		 VBox contenedorVertical1 = new VBox(nombreJugador1, contenedorOptimus, contenedorBumblebee, contenedorRatchet);
	     contenedorVertical1.setSpacing(10);
	     contenedorVertical1.setPadding(new Insets(15));
	     this.setLeft(contenedorVertical1);
	     
		 Label nombreJugador2 = new Label();
		 nombreJugador2.setText("Decepticons");
		 nombreJugador2.setFont(Font.font("courier new", FontWeight.BOLD, 24));
	     nombreJugador2.setTextFill(Color.BLACK);
		 
	     Algoformer megatron = new Megatron();
	     megatron.transformar();
	     ContenedorAlgoformer contenedorMegatron = new ContenedorAlgoformer(megatron);
	     
	     Algoformer bonecrusher = new Bonecrusher();
	     ContenedorAlgoformer contenedorBonecrusher = new ContenedorAlgoformer(bonecrusher);
	     
	     Algoformer frenzy = new Frenzy();
	     frenzy.transformar();
	     ContenedorAlgoformer contenedorFrenzy = new ContenedorAlgoformer(frenzy);
	     
		 VBox contenedorVertical2 = new VBox(nombreJugador2, contenedorMegatron, contenedorBonecrusher, contenedorFrenzy);
	     contenedorVertical2.setSpacing(10);
	     contenedorVertical2.setPadding(new Insets(15));
	     
	     this.setRight(contenedorVertical2);
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
	
}
