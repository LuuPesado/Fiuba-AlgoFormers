package tp2.algoformers.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import tp2.algoformers.modelo.algoformers.Algoformer;

public class ContenedorAlgoformer extends BorderPane {

	Canvas canvas;
	private Image imagen;
	private ImageView contenedorImagen;
	private Algoformer unAlgoformer;
	
	public ContenedorAlgoformer(Algoformer unAlgoformer, Color unColor){
		this.unAlgoformer = unAlgoformer;
		this.imagen = new Image(unAlgoformer.getDireccionDeImagen());
		this.dibujar(unColor);
	}
	public void dibujar(Color unColor){

		this.contenedorImagen = new ImageView();
		contenedorImagen.setFitHeight(100);
		contenedorImagen.setFitWidth(70);
		contenedorImagen.setImage(imagen);
		this.setLeft(contenedorImagen);

        Label nombre = new Label();
        nombre.setText(unAlgoformer.getNombre());
        nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        nombre.setTextFill(unColor);
        
        Label vida = new Label();
        vida.setText("Vida = " + unAlgoformer.getPuntosDeVida());
        vida.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        vida.setTextFill(unColor);
        
        Label ataque = new Label();
        ataque.setText("Ataque = " + unAlgoformer.getAtaque());
        ataque.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        ataque.setTextFill(unColor);
        
        Label distanciaDeAtaque = new Label();
        distanciaDeAtaque.setText("Distancia de Ataque = " + unAlgoformer.getDistanciaDeAtaque());
        distanciaDeAtaque.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        distanciaDeAtaque.setTextFill(unColor);
        
        Label velocidadDeDesplazamiento = new Label();
        velocidadDeDesplazamiento.setText("Velocidad = " + unAlgoformer.getModificadores().afectarVelocidad(unAlgoformer.getVelocidad()));
        velocidadDeDesplazamiento.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        velocidadDeDesplazamiento.setTextFill(unColor);
		
		VBox texto = new VBox(nombre, vida, ataque, distanciaDeAtaque, velocidadDeDesplazamiento);
        this.setRight(texto);
	}
}
