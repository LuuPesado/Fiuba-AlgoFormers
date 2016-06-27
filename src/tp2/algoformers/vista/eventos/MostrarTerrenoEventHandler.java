package tp2.algoformers.vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import tp2.algoformers.modelo.Contenido;


public class MostrarTerrenoEventHandler implements EventHandler<MouseEvent>{
	
	private Contenido terrenoTerrestre;
	private Label etiqueta;
	private Pane panel;
	
	
	public MostrarTerrenoEventHandler(Contenido unTerrenoTerrestre) {
		this.terrenoTerrestre = unTerrenoTerrestre;
		this.etiqueta = new Label();
		panel = new Pane(etiqueta);
	}
	

	@Override
	public void handle(MouseEvent arg0) {
		etiqueta.setText(terrenoTerrestre.getDireccionDeImagen());
		panel = setUpPane();
	}
	
	private Pane setUpPane(){
		VBox contenedor = new VBox();
		contenedor.getChildren().add(etiqueta);
		panel.getChildren().add(contenedor);
		return panel;
	}
}
