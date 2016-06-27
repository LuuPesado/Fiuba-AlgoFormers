package tp2.algoformers.vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tp2.algoformers.modelo.Tablero;
import tp2.algoformers.modelo.terrenos.Nube;
import tp2.algoformers.modelo.terrenos.Rocosa;

public class ContenedorTablero extends BorderPane {

	public ContenedorTablero(){
		int filas = Tablero.getTablero().cantidadDeFilas();
		int columnas = Tablero.getTablero().cantidadDeColumnas();
	
	    HBox contenedorHorizontal = new HBox();
	    for (int i = 1; i <= columnas; i++){ 
	    	VBox contenedorVertical = new VBox();
			for (int j = 1; j <= filas; j++){ 
				//mostrar terrenos
				String direccionTerrenoTerrestre = Tablero.getTablero().fila(j).columna(i).getTerrenoTerrestre().getDireccionDeImagen();
				Image imagenTerrenoTerrestre = new Image(direccionTerrenoTerrestre);
				ImageView contenedorImagenTerrenoTerrestre = new ImageView();
				contenedorImagenTerrenoTerrestre.setFitHeight(33);
				contenedorImagenTerrenoTerrestre.setFitWidth(33);
				contenedorImagenTerrenoTerrestre.setImage(imagenTerrenoTerrestre);
				
				
				String direccionTerrenoAereo = Tablero.getTablero().fila(j).columna(i).getTerrenoAereo().getDireccionDeImagen();
				Image imagenTerrenoAereo = new Image(direccionTerrenoAereo);
				ImageView contenedorImagenTerrenoAereo = new ImageView();
				contenedorImagenTerrenoAereo.setFitHeight(33);
				contenedorImagenTerrenoAereo.setFitWidth(33);
				contenedorImagenTerrenoAereo.setImage(imagenTerrenoAereo);
				
				contenedorImagenTerrenoTerrestre.setOpacity(0.6);
				contenedorImagenTerrenoAereo.setOpacity(1);

				
				//mostrar contenido
				String direccionContenido = Tablero.getTablero().fila(j).columna(i).getContenido().getDireccionDeImagen();
				Image imagenContenido = new Image(direccionContenido);
				VistaContenido contenedorContenido;
				ImageView contenedorImagenContenido = new ImageView();
				contenedorImagenContenido.setFitHeight(33);
				contenedorImagenContenido.setFitWidth(33);
				contenedorImagenContenido.setImage(imagenContenido);
				contenedorImagenContenido.setOpacity(0.3);
				
				//Superponer imagenes
				StackPane contenedorImagenesSuperpuestas = new StackPane();
				contenedorImagenesSuperpuestas.getChildren().addAll(contenedorImagenTerrenoAereo, contenedorImagenTerrenoTerrestre, contenedorImagenContenido); 
				contenedorVertical.getChildren().add(contenedorImagenesSuperpuestas);
				contenedorVertical.setSpacing(2);

			}
			contenedorHorizontal.getChildren().add(contenedorVertical);
			contenedorHorizontal.setSpacing(2);
		}
	    this.setCenter(contenedorHorizontal);
		
	}
}