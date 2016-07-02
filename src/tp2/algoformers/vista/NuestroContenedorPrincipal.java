package tp2.algoformers.vista;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tp2.algoformers.modelo.Juego;
import tp2.algoformers.modelo.Jugador;
import tp2.algoformers.vista.BarraDeMenu;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class NuestroContenedorPrincipal extends BorderPane {
	 BarraDeMenu menuBar;
	 Canvas canvasCentral;
	 Button botonJugada;
	 private Juego juego;
	 private Stage stage;
	 private ContenedorTablero contenedorTablero;
	 
	 
	 public NuestroContenedorPrincipal(Stage stage, Juego unJuego){
		 this.juego = unJuego;
		 juego.crearTablero();
		 this.dibujar();
		 Controlador.getControlador().setContenedorPrincipal(this);
	 }
	
	 private Botonera setBotonera() {
		 Botonera botonera = new Botonera(juego, contenedorTablero);
		 return botonera;
	}

	private void setMenu(Stage stage) {
	    this.menuBar = new BarraDeMenu(stage);
	    this.setTop(menuBar);
	}

	private VBox setNombreJugadorActual(){
		Jugador jugadorActual = juego.getTurno().devolverJugadorSiguiente();
		Label nombre = new Label();
		String texto = "Turno: " + jugadorActual.getNombre();
        nombre.setText(texto);
        nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 16));
        nombre.setTextFill(Color.BLUE);
        VBox contenedor = new VBox(nombre);
        return contenedor;
	}
	
	 private void setJuego(){
		 this.contenedorTablero = new ContenedorTablero();
		 VBox contenedorVertical = new VBox(contenedorTablero);
		 HBox contenedorHorizontal = new HBox();
		 if (juego.hayGanador()){
			 contenedorHorizontal.getChildren().add(this.anunciarGanador());
			 contenedorVertical.getChildren().add(contenedorHorizontal);
			 this.setCenter(contenedorVertical);
			 return; //si hay ganador no muestro mas la botonera
		 }
		 contenedorHorizontal.setSpacing(10);
	     contenedorHorizontal.getChildren().add(this.setNombreJugadorActual());
		 contenedorHorizontal.getChildren().add(this.setBotonera());
		 contenedorVertical.getChildren().add(contenedorHorizontal);
		 this.setCenter(contenedorVertical);
	 }
	 
	 private VBox anunciarGanador(){
		 //escribo el ganador debajo del tablero
		 Jugador jugadorGanador = juego.getTurno().devolverJugadorActual();
	     String nombreGanador = jugadorGanador.getNombre();
	     Label nombre = new Label();
		 String texto = "GANADOR: " + nombreGanador;
	     nombre.setText(texto);
	     nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 20));
	     nombre.setTextFill(Color.BLACK);
	     VBox contenedor = new VBox(nombre);
	     return contenedor;
	 }
	 
	 private void setJugador1(Jugador unJugador){
		Label nombreJugador1 = new Label();
		nombreJugador1.setText(unJugador.getNombre());
		nombreJugador1.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		nombreJugador1.setTextFill(Color.BLACK);

		
     	VBox contenedorVertical1 = new VBox(nombreJugador1);
		contenedorVertical1.setSpacing(10);
		contenedorVertical1.setPadding(new Insets(15));	 
	    //contenedorVertical1.getChildren().add(this.setBotonera());
	     
	     for  (int i=0; i<unJugador.getAlgoformers().size(); i++){
	    	 ContenedorAlgoformer unContenedor = new ContenedorAlgoformer(unJugador.getAlgoformers().get(i), Color.BLUE);
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
		//contenedorVertical1.getChildren().add(this.setBotonera());

	     for  (int i=0; i<unJugador.getAlgoformers().size(); i++){
	    	 ContenedorAlgoformer unContenedor = new ContenedorAlgoformer(unJugador.getAlgoformers().get(i), Color.RED);
	    	 contenedorVertical1.getChildren().add(unContenedor);
	     }
	     
	     this.setRight(contenedorVertical1);

	 }

	public void update() {
		this.juego.getTurno().borrarAlgoformersMuertos();
		this.dibujar();
		this.juego.getTurno().bajarTemporales();		
	}

	public void dibujar() {
		this.setMenu(this.stage);
		this.setJugador1(juego.getJugadorAutobots());
		this.setJugador2(juego.getJugadorDecepticons());
		this.setJuego();
	}
		 
}

