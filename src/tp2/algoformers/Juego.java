package tp2.algoformers;

import java.util.ArrayList;

public class Juego {
    private Jugador jugadorAutobots;
    private Jugador jugadorDecepticons;
    public ArrayList<Algoformer> autobots;
    public ArrayList<Algoformer> decepticons;
    public ChispaSuprema chispaSuprema;
    public int turno;
    
    public Juego(Jugador jugadorAutobots, Jugador jugadorDecepticons){
    	this.turno = 1;
        this.jugadorAutobots = jugadorAutobots;
        this.jugadorDecepticons = jugadorDecepticons;
        this.autobots = new ArrayList();
        this.decepticons = new ArrayList();
        autobots.add(new OptimusPrime());
        autobots.add(new Bumblebee());
        autobots.add(new Ratchet());
        decepticons.add(new Megatron());
        decepticons.add(new Bonecrusher());
        decepticons.add(new Frenzy());
        jugadorAutobots.agregarAlgoformers(autobots);
        jugadorDecepticons.agregarAlgoformers(decepticons);
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
    
    /*public void turno (Jugador unJugador, Algoformer algoformer, int accion, ArrayList<Algoformer> enemigos){
        unJugador.miTurno(algoformer, accion, enemigos);  
    }*/
    
    public boolean hayGanador(){
    	boolean ganador = false;
        if (jugadorAutobots.estanTodosMuertos()){
    		ganador = true;
    	}
    	if (jugadorDecepticons.estanTodosMuertos()){
    		ganador = true;
    	}
    	return ganador;
    }
    
    public void jugar(int numeroDeAlgoformer, Posicion posicion) {
    	//int numeroDeTurno = 1;
    	//boolean hayGanador = false;
    	//Turno turno = new Turno(this.jugadorAutobots);
    	//while (!hayGanador){
            if ( turno == 1){
                this.jugadorAutobots.jugar(numeroDeAlgoformer, posicion);
                turno = 2;
            } else {
                this.jugadorDecepticons.jugar(numeroDeAlgoformer, posicion);
                turno = 1;
            }
    	//}
    }
}
