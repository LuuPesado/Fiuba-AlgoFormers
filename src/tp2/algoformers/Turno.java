package tp2.algoformers;

public class Turno {
	
	private Jugador jugador;
	
	public Turno (Jugador unJugador){
		jugador = unJugador;
	}
	
	public void bajarTemporales(){
		
	}
	
	public boolean revisarGanador(){
		return false;
	}
	
	/*public void realizarAccion(){
		Algoformer algoformer = jugador.elegirAlgoformer(elegido);
		int accion = jugador.elegirAccion();
		switch (accion) {
        	case 1: //mover a (posicionX, posicionY)
                Posicion posicion = jugador.elegirMovimiento();
        		algoformer.moverAlgoformer(posicion.getFila(),posicion.getColumna());
                break;
        	case 2: //atacar al objetivo
        		Algoformer objetivo = jugador.elegirObjetivo();
                algoformer.atacar(objetivo);
                break;
        	case 3: //transformarse
                algoformer.transformar();
                break;
        	default: ;
                 break;
	}*/
	
	
}
