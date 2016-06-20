package tp2.algoformers.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import tp2.algoformers.modelo.Algoformer;
import tp2.algoformers.modelo.OptimusPrime;

public class ContenedorAlgoformer extends BorderPane {

	public ContenedorAlgoformer(String direccionImagen){
		Image imagen = new Image(direccionImagen);
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		VBox contenedorImagen = new VBox();
		contenedorImagen.setSpacing(10);
        contenedorImagen.setPadding(new Insets(8));
		contenedorImagen.setBackground(new Background(imagenDeFondo));
		this.setLeft(contenedorImagen);
		
		Algoformer optimus = new OptimusPrime();
		VBox contenedorDatos = new VBox();
        Label nombre = new Label();
        nombre.setText("Nombre = " + optimus.getNombre());
        nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        nombre.setTextFill(Color.WHITE);
        
        Label nombre1 = new Label();
        nombre1.setText("Nombre = " + optimus.getNombre());
        nombre1.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        nombre1.setTextFill(Color.WHITE);
        
        Label nombre1 = new Label();
        nombre1.setText("Nombre = " + optimus.getNombre());
        nombre1.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        nombre1.setTextFill(Color.WHITE);
        
        Label nombre1 = new Label();
        nombre1.setText("Nombre = " + optimus.getNombre());
        nombre1.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        nombre1.setTextFill(Color.WHITE);
        
	}
	
}
