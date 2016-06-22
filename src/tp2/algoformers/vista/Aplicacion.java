package tp2.algoformers.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp2.algoformers.vista.NuestroContenedorPrincipal;


public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Probando La Interfaz Gráfica");
        NuestroContenedorPrincipal contenedorPrincipal = new NuestroContenedorPrincipal(stage);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
        stage.setScene(escenaJuego);
        stage.setFullScreen(true);
        stage.show();
       

    }

}
