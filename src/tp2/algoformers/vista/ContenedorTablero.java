package tp2.algoformers.vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.modelo.Tablero;

public class ContenedorTablero extends BorderPane {
	
	private int filas;
	private int columnas;

	
	public ContenedorTablero(){
		this.filas = Tablero.getTablero().cantidadDeFilas();
		this.columnas = Tablero.getTablero().cantidadDeColumnas();
		this.dibujar();
	}
	   

public void dibujar(){
	 HBox contenedorHorizontal = new HBox();
	    for (int i = 1; i <= columnas; i++){ 
	    	VBox contenedorVertical = new VBox();
			for (int j = 1; j <= filas; j++){ 
				//mostrar terrenos
				
				ImageView contenedorImagenTerrenoTerrestre = this.dibujarTerrenoTerrestre(i, j);
				
				ImageView contenedorImagenTerrenoAereo = this.dibujarTerrenoAereo(i, j);
				
				//mostrar contenido
				Contenido contenido = Tablero.getTablero().fila(j).columna(i).getContenido();
				VistaContenido contenedorContenido = new VistaContenido(contenido);
				
				//Superponer imagenes
				StackPane contenedorImagenesSuperpuestas = new StackPane();
				contenedorImagenesSuperpuestas.getChildren().addAll(contenedorImagenTerrenoAereo, contenedorImagenTerrenoTerrestre, contenedorContenido); 
				contenedorVertical.getChildren().add(contenedorImagenesSuperpuestas);
				contenedorVertical.setSpacing(2);

			}
			contenedorHorizontal.getChildren().add(contenedorVertical);
			contenedorHorizontal.setSpacing(2);
		}
	    this.setCenter(contenedorHorizontal);
		
	}


private ImageView dibujarTerrenoAereo(int i, int j) {
	String direccionTerrenoAereo = Tablero.getTablero().fila(j).columna(i).getTerrenoAereo().getDireccionDeImagen();
	Image imagenTerrenoAereo = new Image(direccionTerrenoAereo);
	ImageView contenedorImagenTerrenoAereo = new ImageView();
	contenedorImagenTerrenoAereo.setFitHeight(33);
	contenedorImagenTerrenoAereo.setFitWidth(33);
	contenedorImagenTerrenoAereo.setImage(imagenTerrenoAereo);
	contenedorImagenTerrenoAereo.setOpacity(1);
	return contenedorImagenTerrenoAereo;
}
 

private ImageView dibujarTerrenoTerrestre(int i, int j) {
	String direccionTerrenoTerrestre = Tablero.getTablero().fila(j).columna(i).getTerrenoTerrestre().getDireccionDeImagen();
	Image imagenTerrenoTerrestre = new Image(direccionTerrenoTerrestre);
	ImageView contenedorImagenTerrenoTerrestre = new ImageView();
	contenedorImagenTerrenoTerrestre.setFitHeight(33);
	contenedorImagenTerrenoTerrestre.setFitWidth(33);
	contenedorImagenTerrenoTerrestre.setImage(imagenTerrenoTerrestre);
	contenedorImagenTerrenoTerrestre.setOpacity(0.6);
	return contenedorImagenTerrenoTerrestre;
}




}