package tp2.algoformers.vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tp2.algoformers.vista.eventos.BotonEntrarEventHandler;

public class ContenedorElegirJugadores extends HBox{
	
	private TextField nombreJugador1;
	private TextField nombreJugador2;
	private Button botonEntrar;
	
	public ContenedorElegirJugadores(Stage stage){
		this.setSpacing(30);
        this.setColumnaAutobots();
        this.setColumnaDecepticons();
        this.setBotonEntrar(stage);
        Controlador.getControlador().setContenedroElegirJugador(this);

        
	}
	
	private void setBotonEntrar(Stage stage) {
        
		VBox contenedorVertical = new VBox();
        
		botonEntrar = new Button();
        botonEntrar.setText("Entrar");
		BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage);
        botonEntrar.setOnAction(botonEntrarHandler);
        
        Button botonBorrar = new Button();
        botonBorrar.setText("Borrar");
        
        contenedorVertical.getChildren().addAll(botonEntrar, botonBorrar);
        this.getChildren().add(contenedorVertical);

	}
	
	public String getNombreJugador1(){	
		return (nombreJugador1.getText());
	}

	public String getNombreJugador2(){
		return (nombreJugador2.getText());
	}
	
	private void setColumnaAutobots() {
		
		VBox autobots = new VBox();
		HBox elegirNombre = new HBox();
		
		Label titulo = new Label();
		titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));
		titulo.setText("AUTOBOTS");
		titulo.setTextFill(Color.BLUE);
		
		Label jugador1 = new Label();
        jugador1.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        jugador1.setText("NOMBRE: ");
        jugador1.setTextFill(Color.BLACK);
        
        elegirNombre.setSpacing(10);
		this.nombreJugador1 = new TextField();
		
		elegirNombre.getChildren().add(jugador1);
		elegirNombre.getChildren().add(nombreJugador1);
		
		autobots.setSpacing(10);
		autobots.getChildren().add(titulo);
		autobots.getChildren().add(elegirNombre);
		
		this.getChildren().add(autobots);
	}
	
	private void setColumnaDecepticons() {
		
		VBox decepticons = new VBox();
		HBox elegirNombre = new HBox();
		
		Label titulo = new Label();
		titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));
		titulo.setText("DECEPTICONS");
		titulo.setTextFill(Color.RED);
		
		Label jugador2 = new Label();
        jugador2.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        jugador2.setText("NOMBRE: ");
        jugador2.setTextFill(Color.BLACK);
        
        elegirNombre.setSpacing(10);
        
		this.nombreJugador2 = new TextField();
		
		elegirNombre.getChildren().add(jugador2);
		elegirNombre.getChildren().add(nombreJugador2);
		
		decepticons.getChildren().add(titulo);
		decepticons.getChildren().add(elegirNombre);
		decepticons.setSpacing(10);
		this.getChildren().add(decepticons);
		
	}
}
