package tp2.algoformers.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tp2.algoformers.modelo.Juego;
import tp2.algoformers.modelo.Jugador;
import tp2.algoformers.vista.ContenedorElegirJugadores;
import tp2.algoformers.vista.Controlador;
import tp2.algoformers.vista.NuestroContenedorPrincipal;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent>{


    Stage stage;
    Scene proximaEscena;
    private Jugador jugador1;
    private Jugador jugador2;

    public BotonEntrarEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.setTablero();

    }
    
    public void setTablero(){
    	 stage.setTitle("Probando La Interfaz Gráfica");
    	 jugador1 = new Jugador(Controlador.getControlador().getContenedorJuego().getNombreJugador1());
       	 jugador2 = new Jugador(Controlador.getControlador().getContenedorJuego().getNombreJugador2());
    	 Juego juego = new Juego(jugador1, jugador2); 
         NuestroContenedorPrincipal contenedorPrincipal = new NuestroContenedorPrincipal(stage, juego);
         Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
         stage.setScene(escenaJuego);
         stage.setFullScreen(true);
         stage.show();
    }
    
}
