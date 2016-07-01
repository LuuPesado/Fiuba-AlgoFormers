package tp2.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.modelo.Juego;
import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.excepciones.FueraDeRangoException;
import tp2.algoformers.modelo.excepciones.NoPuedeFusionarseException;
import tp2.algoformers.vista.ContenedorTablero;
import tp2.algoformers.vista.Controlador;

public class BotonFusionarEventHandler implements EventHandler<ActionEvent>{

	private ContenedorTablero contenedorTablero;
	private Algoformer unAlgoformer = null;
	private Juego juego;

	public BotonFusionarEventHandler(Juego juego, ContenedorTablero contenedorTablero) {
		this.juego = juego;
		this.contenedorTablero = contenedorTablero;
	}
	
	public void recibirContenido(Contenido unContenido){
		if (unContenido.esUnAlgoformer()){
			unAlgoformer = ( (Algoformer) unContenido );
		}
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		if (unAlgoformer == null){
			return;
		}
		if (unAlgoformer.getNombre() == "MENASOR" || unAlgoformer.getNombre() == "SUPERION"){
			this.mostrarYaFusionado();
			return;
		}
		try{
			juego.getTurno().jugadorActual().fusionar(unAlgoformer);
		} catch (NoPuedeFusionarseException e){
			this.mostrarNoPuedeFusionarse();
			return;
		} catch (FueraDeRangoException e){
			this.mostrarFueraRango();
			return;
		}
		this.contenedorTablero.dibujar();
		Controlador.getControlador().update();
		this.unAlgoformer = null;
	}
	
	private void mostrarNoPuedeFusionarse(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepción");
        alert.setHeaderText("No pueden fusionarse");
        String mensaje = "Algoformers muertos / Algoformers afectados por nebulosa."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
	}
	
	private void mostrarFueraRango(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepción");
        alert.setHeaderText("No pueden fusionarse");
        String mensaje = "Algoformers fuera de rango."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
	}
	
	private void mostrarYaFusionado(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepción");
        alert.setHeaderText("Algoformers ya fusionados");
        String mensaje = "No se puede volver al estado anterior."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
	}

}
