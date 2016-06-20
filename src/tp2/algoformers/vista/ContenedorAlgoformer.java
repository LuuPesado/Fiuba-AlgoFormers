package tp2.algoformers.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

	public ContenedorAlgoformer(Algoformer unAlgoformer){
		Image imagen = new Image(unAlgoformer.getDireccionDeImagen());
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		ImageView contenedorImagen = new ImageView();
		contenedorImagen.setFitHeight(100);
		contenedorImagen.setFitWidth(70);
		contenedorImagen.setImage(imagen);
		this.setLeft(contenedorImagen);

        Label nombre = new Label();
        nombre.setText(unAlgoformer.getNombre());
        nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        nombre.setTextFill(Color.BLUE);
        
        Label vida = new Label();
        vida.setText("Vida = " + unAlgoformer.getPuntosDeVida());
        vida.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        vida.setTextFill(Color.BLUE);
        
        Label ataque = new Label();
        ataque.setText("Ataque = " + unAlgoformer.getAtaque());
        ataque.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        ataque.setTextFill(Color.BLUE);
        
        Label distanciaDeAtaque = new Label();
        distanciaDeAtaque.setText("Distancia de Ataque = " + unAlgoformer.getDistanciaDeAtaque());
        distanciaDeAtaque.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        distanciaDeAtaque.setTextFill(Color.BLUE);
        
        Label velocidadDeDesplazamiento = new Label();
        velocidadDeDesplazamiento.setText("Velocidad =" + unAlgoformer.getVelocidad());
        velocidadDeDesplazamiento.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        velocidadDeDesplazamiento.setTextFill(Color.BLUE);
		
		VBox texto = new VBox(nombre, vida, ataque, distanciaDeAtaque, velocidadDeDesplazamiento);
        this.setRight(texto);
	}
	
}
