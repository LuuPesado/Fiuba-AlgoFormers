package tp2.algoformers.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


public class NuestroContenedorBienvenidos extends VBox {

	    Stage stage;

	    public NuestroContenedorBienvenidos(Stage stage) {

	        super();

	        this.stage = stage;

	        this.setAlignment(Pos.CENTER);
	        this.setSpacing(20);
	        this.setPadding(new Insets(25));
	        Image imagen = new Image("file:src/tp2/algoformers/vista/imagenes/fondoJuego3.png");
	        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	        this.setBackground(new Background(imagenDeFondo));

	        Image logoTransformers = new Image("file:src/tp2/algoformers/vista/imagenes/Transformers.png");
	        ImageView mostrarLogo = new ImageView(logoTransformers);
	        
	        Label etiqueta = new Label();
	        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

	        etiqueta.setText("Ingrese el nombre de cada jugador");
	        etiqueta.setTextFill(Color.BLACK);
	        
	        ContenedorElegirJugadores elegirJugadores = new ContenedorElegirJugadores(stage);
	       
	        
	        this.getChildren().addAll(mostrarLogo, etiqueta, elegirJugadores);
	    }

	}

