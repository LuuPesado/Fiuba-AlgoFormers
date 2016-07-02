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
		this.setOnMouseClicked(new ElegirContenidoEventHandler(this.getContenido()));
	}

	public Contenido getContenido() {
		return contenido;
	}
	
	public void setVistaContenido(){
		this.setFitHeight(32);
		this.setFitWidth(32);
		this.setImage(imagenContenido);
		//este if es horrible, ya se, pero asi pongo la opacidad del contenido en 0 solo si es vacio
		if (contenido.getClass().getName() == "tp2.algoformers.modelo.Vacio"){
			this.setOpacity(0);
			return;
		}
		this.setOpacity(1);
	}

}