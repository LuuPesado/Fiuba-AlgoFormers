package tp2.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.modelo.Juego;
import tp2.algoformers.modelo.Jugador;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.excepciones.EseAlgoformerPerteneceAlOtroJugadorException;
import tp2.algoformers.modelo.excepciones.FueraDeRangoException;
import tp2.algoformers.modelo.excepciones.NoPuedoAtacarUnCompanieroException;
import tp2.algoformers.vista.ContenedorTablero;
import tp2.algoformers.vista.Controlador;

public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugador;
	private Algoformer unAlgoformer = null;
	private Posicion unaPosicion;
	private ContenedorTablero contenedorTablero;
	private Juego juego;
	
	public BotonJugarEventHandler(Juego juego, ContenedorTablero contenedorTablero) {
		this.juego = juego;
		this.jugador = juego.getTurno().jugadorActual();
		this.contenedorTablero = contenedorTablero;
	}

	//Hay que modificar esto pero masomenos funciona, de esta forma si se toca al Algoformer una vez y despues "jugar" se transforma.
	public void recibirContenido(Contenido unContenido){
		if (unContenido.esUnAlgoformer() && (unAlgoformer == null)){
			unAlgoformer = ( (Algoformer) unContenido );
			unaPosicion = unContenido.getPosicion();
		} else {
			unaPosicion = unContenido.getPosicion();
		}
		if (unAlgoformer != null){
			unaPosicion = unContenido.getPosicion();
		}
	}
	
	
	@Override
	public void handle(ActionEvent arg0) {
		if ((unAlgoformer != null) && (unaPosicion != null)){
		try {
			jugador.jugar(unAlgoformer, unaPosicion);
		} catch (FueraDeRangoException e){
			this.mostrarAlertaFueraDeRango();
			return;
		} catch (NoPuedoAtacarUnCompanieroException e){
			this.mostrarAlertaNoPuedoAtacar();
			return;
		}
		if (juego.hayGanador()){
			this.anunciarGanador(jugador);
			return;
		}
		this.contenedorTablero.dibujar();
		Controlador.getControlador().update();
		}
		unAlgoformer = null;
	}
	
	private void mostrarAlertaFueraDeRango(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepción");
        alert.setHeaderText("Fuera de rango");
        String mensaje = "El algoformer no puede alcanzar la posición seleccionada."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
	}
	
	private void mostrarAlertaNoPuedoAtacar(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepción");
        alert.setHeaderText("No puede atacar un compañero");
        String mensaje = "Algoformers del mismo equipo no puede atacarse entre sí."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
	}
	
	private void anunciarGanador(Jugador jugador){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Fin de juego");
        String nombreGanador = jugador.getNombre();
        alert.setHeaderText("GANADOR: " + nombreGanador);
        alert.show();
	}

}
