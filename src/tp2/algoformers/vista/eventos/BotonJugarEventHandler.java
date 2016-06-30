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
import tp2.algoformers.modelo.excepciones.AtrapadoEnNebulosaException;
import tp2.algoformers.modelo.excepciones.EseAlgoformerPerteneceAlOtroJugadorException;
import tp2.algoformers.modelo.excepciones.FueraDeRangoException;
import tp2.algoformers.modelo.excepciones.LaCeldaYaTieneUnAlgoformer;
import tp2.algoformers.modelo.excepciones.NoPuedoAtacarUnCompanieroException;
import tp2.algoformers.modelo.excepciones.UnHumanoideNoPuedeCruzarUnPantano;
import tp2.algoformers.vista.ContenedorTablero;
import tp2.algoformers.vista.Controlador;

public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

	private Jugador jugador;
	private Algoformer unAlgoformer = null;
	private Posicion unaPosicion;
	private ContenedorTablero contenedorTablero;
	
	public BotonJugarEventHandler(Juego juego, ContenedorTablero contenedorTablero) {
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
			unAlgoformer = null;
			return;
		} catch (NoPuedoAtacarUnCompanieroException e){
			this.mostrarAlertaNoPuedoAtacar();
			unAlgoformer = null;
			return;
		} catch (LaCeldaYaTieneUnAlgoformer e){
			this.mostrarAlertaYaTieneAlgoformer();
			unAlgoformer = null;
			return;
		} catch (UnHumanoideNoPuedeCruzarUnPantano e){
			this.mostrarHumanoideNoPuede();
			unAlgoformer = null;
			return;
		} catch (AtrapadoEnNebulosaException e){
			this.mostrarAtrapadoEnNebulosa();
			unAlgoformer = null;
			return;
		} catch (EseAlgoformerPerteneceAlOtroJugadorException e){
			this.mostrarAlertaPerteneceOtroJugador();
			unAlgoformer = null;
			return;
		}
		this.contenedorTablero.dibujar();
		Controlador.getControlador().update();
		}
		unAlgoformer = null;
	}
	
	private void mostrarAlertaFueraDeRango(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepci�n");
        alert.setHeaderText("Fuera de rango");
        String mensaje = "El algoformer no puede alcanzar la posici�n seleccionada."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
	}
	
	private void mostrarAlertaNoPuedoAtacar(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepci�n");
        alert.setHeaderText("No puede atacar un compa�ero");
        String mensaje = "Algoformers del mismo equipo no puede atacarse entre s�."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
	}
	
	private void mostrarAlertaYaTieneAlgoformer(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepci�n");
        alert.setHeaderText("La celda ya tiene un algoformer");
        String mensaje = "Est� intentando atravesar una celda que est� ocupada."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
	}
	
	private void mostrarHumanoideNoPuede(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepci�n");
        alert.setHeaderText("No puede cruzar pantano");
        String mensaje = "Algoformer en modo humanoide no puede hacerlo."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
        //no funciona bien
	}
	
	private void mostrarAtrapadoEnNebulosa(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepci�n");
        alert.setHeaderText("Atrapado en nebulosa");
        String mensaje = "Su algoformer se liberar� pasados 3 turnos."
        		+ " Utilice otro algoformer.";
        alert.setContentText(mensaje);
        alert.show();
        //NO FUNCIONA
        //No atrapa al algoformer cuando solo lo atraviesa (es decir cuando paso sin querer por ahi).
        //Y cuando me muevo a una posicion nebulosa lo atrapa eternamente.
	}
	
	private void mostrarAlertaPerteneceOtroJugador(){
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepci�n");
        alert.setHeaderText("Algoformer del otro equipo");
        String mensaje = "Ha elegido un algoformer del otro jugador."
        		+ " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
	}
	
}
