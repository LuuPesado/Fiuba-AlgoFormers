package tp2.algoformers.modelo;

import java.util.ArrayList;

public class Juego {
    private Jugador jugadorAutobots;
    private Jugador jugadorDecepticons;
    public ArrayList<Algoformer> autobots;
    public ArrayList<Algoformer> decepticons;
    public ChispaSuprema chispaSuprema;
    public Turno turno;
    
    public Juego(Jugador jugadorAutobots, Jugador jugadorDecepticons){
    	
        this.jugadorAutobots = jugadorAutobots;
        this.jugadorDecepticons = jugadorDecepticons;
        this.autobots = new ArrayList<Algoformer>();
        this.decepticons = new ArrayList<Algoformer>();
        autobots.add(new OptimusPrime());
        autobots.add(new Bumblebee());
        autobots.add(new Ratchet());
        autobots.add(new Superion());
        decepticons.add(new Megatron());
        decepticons.add(new Bonecrusher());
        decepticons.add(new Frenzy());
        decepticons.add(new Menasor());
        jugadorAutobots.agregarAlgoformers(autobots);
        jugadorDecepticons.agregarAlgoformers(decepticons);
        this.turno = new Turno(jugadorAutobots, jugadorDecepticons, chispaSuprema);
        chispaSuprema = new ChispaSuprema();
    }
    
    public void crearTablero(){
        Tablero tablero = Tablero.getTablero();
        int filas = tablero.cantidadDeFilas();
        int columnas = tablero.cantidadDeColumnas();
        tablero.ubicarAlgoformerEnUnaPosicion(1,1, autobots.get(0));
        tablero.ubicarAlgoformerEnUnaPosicion(2,1, autobots.get(1));
        tablero.ubicarAlgoformerEnUnaPosicion(1,2, autobots.get(2));
        tablero.ubicarAlgoformerEnUnaPosicion(filas, columnas, decepticons.get(0));
        tablero.ubicarAlgoformerEnUnaPosicion(filas-1,columnas, decepticons.get(1));
        tablero.ubicarAlgoformerEnUnaPosicion(filas, columnas-1, decepticons.get(2));
        tablero.ubicarChispaSuprema(chispaSuprema);
    }
    
    public Algoformer devolverAutobot(int numero){
        return autobots.get(numero);
    }
    
    public Algoformer devolverDecepticon(int numero){
        return decepticons.get(numero);
    }
    
   
    
    public boolean hayGanador(){
    	boolean ganador = false;
        if (jugadorAutobots.estanTodosMuertos()){
    		ganador = true;
    	}
    	if (jugadorDecepticons.estanTodosMuertos()){
    		ganador = true;
    	}
    	if (chispaSuprema.hayGanador()){
    		ganador = true;
    	}
    	return ganador;
    }
    
    public void jugar(int numeroDeAlgoformer, Posicion posicion) {
        while (!hayGanador()){
    		turno.jugadorActual().jugar(numeroDeAlgoformer, posicion);
    		turno.bajarTemporales();
        }
    }
    
    public Jugador getJugadorAutobots(){
    	return jugadorAutobots;
    }
    
    public Jugador getJugadorDecepticons(){
    	return jugadorDecepticons;
    }
}
