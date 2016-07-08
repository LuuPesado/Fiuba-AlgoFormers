package tp2.algoformers.vista;

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
import javafx.scene.control.ScrollPane;

public class NuestroContenedorPrincipal extends ScrollPane {

	 Canvas canvasCentral;
	 Button botonJugada;
	 private Juego juego;
	 private Stage stage;
	 private ContenedorTablero contenedorTablero;
	 private VBox pantalla;
	 private HBox contenedorJuego;
	 
	 public NuestroContenedorPrincipal(Stage stage, Juego unJuego){
		 this.pantalla = new VBox();
		 this.contenedorJuego = new HBox();
		 this.juego = unJuego;
		 juego.crearTablero();
		 this.dibujar();
		 this.setContent(pantalla);
		 Controlador.getControlador().setContenedorPrincipal(this);
	 }
	
	 private Botonera setBotonera() {
		 Botonera botonera = new Botonera(juego, contenedorTablero);
		 return botonera;
	}

	private void setMenu(Stage stage) {
		
	    pantalla.getChildren().add(new BarraDeMenu(stage));
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
		 } else{
			 contenedorHorizontal.setSpacing(10);
		     contenedorHorizontal.getChildren().add(this.setNombreJugadorActual());
			 contenedorHorizontal.getChildren().add(this.setBotonera());
			 contenedorVertical.getChildren().add(contenedorHorizontal);
		 }
		 contenedorJuego.getChildren().add(contenedorVertical);
		 
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
	 
	 private void setJugador1(){
		
		Label nombreJugador1 = new Label();
		nombreJugador1.setText(juego.getJugadorAutobots().getNombre());
		nombreJugador1.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		nombreJugador1.setTextFill(Color.BLACK);

		
     	VBox contenedorVertical1 = new VBox(nombreJugador1);
		contenedorVertical1.setSpacing(10);
		contenedorVertical1.setPadding(new Insets(15));	 
	     
	     for  (int i=0; i<juego.getJugadorAutobots().getAlgoformers().size(); i++){
	    	 ContenedorAlgoformer unContenedor = new ContenedorAlgoformer(juego.getJugadorAutobots().getAlgoformers().get(i), Color.BLUE);
	    	 contenedorVertical1.getChildren().add(unContenedor);
	     }
	     contenedorJuego.getChildren().add(contenedorVertical1);
	 }
	 
	 private void setJugador2(){
		
		Label nombreJugador1 = new Label();
		nombreJugador1.setText(juego.getJugadorDecepticons().getNombre());
		nombreJugador1.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		nombreJugador1.setTextFill(Color.BLACK);

		
     	VBox contenedorVertical1 = new VBox(nombreJugador1);
		contenedorVertical1.setSpacing(10);
		contenedorVertical1.setPadding(new Insets(15));

	     for  (int i=0; i<juego.getJugadorDecepticons().getAlgoformers().size(); i++){
	    	 ContenedorAlgoformer unContenedor = new ContenedorAlgoformer(juego.getJugadorDecepticons().getAlgoformers().get(i), Color.RED);
	    	 contenedorVertical1.getChildren().add(unContenedor);
	     }
	     
	     contenedorJuego.getChildren().add(contenedorVertical1);

	 }

	public void update() {
		this.juego.getTurno().borrarAlgoformersMuertos();
		this.dibujar();
		this.juego.getTurno().bajarTemporales();		
	}

	public void dibujar() {
		this.pantalla = new VBox();
		this.contenedorJuego = new HBox();
		this.setMenu(stage);
		this.setContenedorJuego();
		this.setContent(pantalla);
	}
	

	private void setContenedorJuego(){
		this.setJugador1();
		this.setJuego();
		this.setJugador2();
		pantalla.getChildren().add(contenedorJuego);
	}
		 
}

