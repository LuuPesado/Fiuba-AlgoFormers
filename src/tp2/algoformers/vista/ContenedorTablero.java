package tp2.algoformers.vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tp2.algoformers.modelo.Nube;
import tp2.algoformers.modelo.Rocosa;
import tp2.algoformers.modelo.Tablero;

public class ContenedorTablero extends BorderPane {

	public ContenedorTablero(Tablero tablero, Rocosa rocosa, Nube nube){
		Image imagenRocosa = new Image(rocosa.getDireccionDeImagen());
		Image imagenNube = new Image(nube.getDireccionDeImagen());
		int filas = tablero.cantidadDeFilas();
		int columnas = tablero.cantidadDeColumnas();
		
	    HBox contenedorHorizontal = new HBox();
	    for (int i = 1; i <= 18; i++){ //deberia ir columnas en lugar de 18
	    	VBox contenedorVertical = new VBox();
			for (int j = 1; j <= 18; j++){ //deberia ir filas en lugar de 18
				ImageView contenedorImagenRocosa = new ImageView();
				contenedorImagenRocosa.setFitHeight(33);
				contenedorImagenRocosa.setFitWidth(33);
				contenedorImagenRocosa.setImage(imagenRocosa);
				ImageView contenedorImagenNube = new ImageView();
				contenedorImagenNube.setFitHeight(33);
				contenedorImagenNube.setFitWidth(33);
				contenedorImagenNube.setImage(imagenNube);
				
				contenedorImagenRocosa.setOpacity(0.6);
				contenedorImagenNube.setOpacity(1);
				StackPane contenedorImagenesSuperpuestas = new StackPane();
				contenedorImagenesSuperpuestas.getChildren().addAll(contenedorImagenNube, contenedorImagenRocosa); 
				contenedorVertical.getChildren().add(contenedorImagenesSuperpuestas);
				contenedorVertical.setSpacing(2);
			}
			contenedorHorizontal.getChildren().add(contenedorVertical);
			contenedorHorizontal.setSpacing(2);
		}
	    this.setCenter(contenedorHorizontal);
		
	}
}