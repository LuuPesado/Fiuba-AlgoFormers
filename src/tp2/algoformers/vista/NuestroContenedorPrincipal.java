package tp2.algoformers.vista;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tp2.algoformers.vista.BarraDeMenu;
import javafx.scene.canvas.Canvas;

public class NuestroContenedorPrincipal extends BorderPane {
	 BarraDeMenu menuBar;
	 Canvas canvasCentral;
	 
	 public NuestroContenedorPrincipal(Stage stage){
		 this.setMenu(stage);
	 }
	
	 private void setMenu(Stage stage) {
	    this.menuBar = new BarraDeMenu(stage);
	    this.setTop(menuBar);
	}
}
