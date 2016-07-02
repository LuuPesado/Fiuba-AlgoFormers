package tp2.algoformers.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import tp2.algoformers.vista.eventos.BotonEntrarEventHandler;

public class NuestroContenedorBienvenidos extends VBox {

	    Stage stage;

	    public NuestroContenedorBienvenidos(Stage stage, Scene proximaEscena) {

	        super();

	        this.stage = stage;

	        this.setAlignment(Pos.CENTER);
	        this.setSpacing(20);
	        this.setPadding(new Insets(25));
	        Image imagen = new Image("file:src/tp2/algoformers/vista/imagenes/fondoJuego3.png");
	        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	        this.setBackground(new Background(imagenDeFondo));
       
	        
	        Button botonEntrar = new Button();
	        botonEntrar.setText("Entrar");

	        Label etiqueta = new Label();
	        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

	        etiqueta.setText("Bienvenidos al juego de los Algoformers. Haga click en entrar");
	        etiqueta.setTextFill(Color.BLACK);
	        
	        ContenedorElegirJugadores elegirJugadores = new ContenedorElegirJugadores();
	        

	        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
	        botonEntrar.setOnAction(botonEntrarHandler);

	        this.getChildren().addAll(etiqueta, elegirJugadores, botonEntrar);
	    }

	}

