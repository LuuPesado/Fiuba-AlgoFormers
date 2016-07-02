package tp2.algoformers.modelo;

import java.util.ArrayList;

import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.algoformers.Bonecrusher;
import tp2.algoformers.modelo.algoformers.Bumblebee;
import tp2.algoformers.modelo.algoformers.Frenzy;
import tp2.algoformers.modelo.algoformers.Megatron;
import tp2.algoformers.modelo.algoformers.Menasor;
import tp2.algoformers.modelo.algoformers.OptimusPrime;
import tp2.algoformers.modelo.algoformers.Ratchet;
import tp2.algoformers.modelo.algoformers.Superion;

public class Juego {
    private Jugador jugadorAutobots;
    private Jugador jugadorDecepticons;
    private ArrayList<Algoformer> autobots;
    private ArrayList<Algoformer> decepticons;
    private ChispaSuprema chispaSuprema;
    private Turno turno;

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
        int filas = Tablero.getTablero().cantidadDeFilas();
        int columnas = Tablero.getTablero().cantidadDeColumnas();
        Tablero.getTablero().vaciarTablero();
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(1,1, autobots.get(0));
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(2,1, autobots.get(1));
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(1,2, autobots.get(2));
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(filas, columnas, decepticons.get(0));
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(filas-1,columnas, decepticons.get(1));
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(filas, columnas-1, decepticons.get(2));
        Tablero.getTablero().ubicarChispaSuprema(chispaSuprema);
        int fil = Tablero.getTablero().cantidadDeFilas();
        int colum = Tablero.getTablero().cantidadDeColumnas();
        this.crearFabricaTerrenos(fil, colum);
        this.crearFabricaBuffs(fil, colum);
    }

	private void crearFabricaTerrenos(int filas, int columnas){
    	FabricaTerrenos fabrica = new FabricaTerrenos(filas, columnas);
		fabrica.fabricarTerrenosAlAzar(1, 1, 2, 2); //pongo cualquier numero
    }
    
    private void crearFabricaBuffs(int filas, int columnas){
    	FabricaBuffs fabrica = new FabricaBuffs(filas, columnas);
		fabrica.fabricarBuffsAlAzar(5, 4, 4); //pongo cualquier numero
    }
    
    public Turno getTurno() {
		return turno;
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
  
    public Jugador getJugadorAutobots(){
    	return jugadorAutobots;
    }
    
    public Jugador getJugadorDecepticons(){
    	return jugadorDecepticons;
    }
}
