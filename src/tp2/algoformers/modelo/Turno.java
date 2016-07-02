package tp2.algoformers.modelo;

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
	
	public Jugador devolverJugadorSiguiente(){
		return jugadorSiguiente;
	}
	
	public Jugador devolverJugadorActual(){
		return jugadorActual;
	}

	public void borrarAlgoformersMuertos() {
		jugadorActual.borrarAlgoformersMuertos();
		jugadorSiguiente.borrarAlgoformersMuertos();
	}
	
	
	
}
