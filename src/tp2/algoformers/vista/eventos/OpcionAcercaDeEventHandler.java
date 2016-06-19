package tp2.algoformers.vista.eventos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Ejemplo de mensaje de alerta");
        String mensaje = "75.07 Algoritmos y  programaci�n III."
        		+ " Nuestro TP by Euni, Santi, Mart�n y Lu";
        alert.setContentText(mensaje);
        alert.show();
    }
}