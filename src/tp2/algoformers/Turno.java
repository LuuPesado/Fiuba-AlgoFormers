package tp2.algoformers;

public class Turno {
	
	private Jugador jugadorActual;
	private Jugador jugadorSiguiente;
	private ChispaSuprema chispaSuprema;
	
	public Turno (Jugador jugador1, Jugador jugador2, ChispaSuprema chispa){
		jugadorActual = jugador2;
		jugadorSiguiente= jugador1;
		chispaSuprema = chispa;
	}
	
	public void bajarTemporales(){
		jugadorActual.bajarTemporales();
	}
	
	public boolean revisarGanador(){
		return chispaSuprema.hayGanador();
	}
	
	public Jugador jugadorActual(){
		this.intercambiarJugadores();
		return jugadorActual;
	}
	
	private void intercambiarJugadores(){
		Jugador jugadorAuxiliar;
		jugadorAuxiliar = jugadorActual;
		jugadorActual = jugadorSiguiente;
		jugadorSiguiente = jugadorAuxiliar;
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
