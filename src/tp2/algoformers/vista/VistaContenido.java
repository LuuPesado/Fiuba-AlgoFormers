package tp2.algoformers.vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.vista.eventos.ElegirContenidoEventHandler;

public class VistaContenido extends ImageView {
	
	private Contenido contenido;
	private Image imagenContenido;
	
	public VistaContenido(Contenido unContenido){
		this.contenido = unContenido;
		String direccionContenido = contenido.getDireccionDeImagen();
		this.imagenContenido = new Image(direccionContenido);
		this.setVistaContenido();
		this.setOnMouseClicked(new ElegirContenidoEventHandler(this.contenido));
	}

	public Contenido getContenido() {
		return contenido;
	}
	
	public void setVistaContenido(){
		this.setFitHeight(33);
		this.setFitWidth(33);
		this.setImage(imagenContenido);
		this.setOpacity(0.3);
	}
	
	

}
