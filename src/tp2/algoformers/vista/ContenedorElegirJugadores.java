package tp2.algoformers.vista;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ContenedorElegirJugadores extends HBox{
	
	private TextField nombreJugador1;
	private TextField nombreJugador2;
	
	public ContenedorElegirJugadores(){
		this.setSpacing(30);
        this.columnaAutobots();
        this.columnaDecepticons();

        
	}


	private void columnaAutobots() {
		
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
        
        
		this.nombreJugador1 = new TextField();
		
		elegirNombre.getChildren().add(jugador1);
		elegirNombre.getChildren().add(nombreJugador1);
		
		autobots.getChildren().add(titulo);
		autobots.getChildren().add(elegirNombre);
		
		this.getChildren().add(autobots);
	}
	
	private void columnaDecepticons() {
		
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
