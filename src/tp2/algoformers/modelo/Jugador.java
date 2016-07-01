package tp2.algoformers.modelo;

import java.util.ArrayList;

import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.excepciones.EseAlgoformerPerteneceAlOtroJugadorException;
import tp2.algoformers.modelo.excepciones.NoPuedeFusionarseException;


public class Jugador {
    private String nombre;
    private ArrayList<Algoformer> algoformers;
    private Algoformer fusion;
   
    public Jugador(String unNombre){
        this.setNombre(unNombre);
    }
    
    public void agregarAlgoformers(ArrayList<Algoformer> unaListaDeAlgoformers){
        if (unaListaDeAlgoformers.size()>1){
    	this.fusion = unaListaDeAlgoformers.get(unaListaDeAlgoformers.size()-1);
        unaListaDeAlgoformers.remove(unaListaDeAlgoformers.size()-1);
        }
        this.algoformers = unaListaDeAlgoformers;
    }

    public Algoformer elegirAlgoformer(Algoformer unAlgoformer) {
        if (!this.algoformers.contains(unAlgoformer)){
        	throw new EseAlgoformerPerteneceAlOtroJugadorException();
        }
    	return unAlgoformer;
    }  
    
      
    public void jugar(Algoformer unAlgoformer, Posicion unaPosicion){
        Algoformer algoformer = this.elegirAlgoformer(unAlgoformer);
        algoformer.getModificadores().afectarTurnos();
        this.miTurno(algoformer, unaPosicion);
    }
    
    public void miTurno(Algoformer algoformer, Posicion posicion){
        Tablero tablero = Tablero.getTablero();
        (tablero.fila(posicion.getFila()).columna(posicion.getColumna()).getContenido()).atacadoPor(algoformer);
        
        this.borrarAlgoformersMuertos();
    }

    public boolean estanTodosVivos(){
        boolean vivos = true;
        int i = 0;
        while (vivos && i<algoformers.size()){
                vivos = (algoformers.get(i).puntosDeVida() > 0);
                i++;
        }
        return vivos;
    }
    
    public boolean estanTodosMuertos(){
        boolean muertos = true;
        int i = 0;
        while (muertos && i<algoformers.size()){
                muertos = (algoformers.get(i).puntosDeVida() <= 0);
                i++;
        }
        return muertos;
    }
    
    public boolean algoformersAfectadosPorNebulosa(){
        boolean afectados = false;
        int i = 0;
        while (!afectados && i<algoformers.size()){
                afectados = (algoformers.get(i).afectadoPorDebuff(new AfectadoPorNebulosa()));
                i++;
        }
        return afectados;
    }
    
    public boolean todosAlgoformersEnRango(Algoformer unAlgoformer){
        boolean enRango = true;
        int i = 0;
        while (enRango && i<algoformers.size()){
        		Posicion posicion = algoformers.get(i).getPosicion();
        		int distancia = unAlgoformer.getPosicion().controlarRango(posicion, unAlgoformer.getVelocidad());
                enRango = (unAlgoformer.getVelocidad() >= distancia);
        		i++;
        }
        return enRango;
    }

    public void borrarAlgoformersMuertos(){
    	int i=0;
        while (i<algoformers.size()){
        	if (algoformers.get(i).puntosDeVida()<=0){
        		Algoformer algoformerMuerto = algoformers.get(i);
        		Posicion posicion = algoformerMuerto.getPosicion();
        		Tablero.getTablero().sacarAlgoformer(posicion);
        		algoformers.remove(i);
        	} else {
        		i++;
        	}
        }
    }
    
	public void bajarTemporales() {
		for (int i = 0; i<algoformers.size(); i++){
			algoformers.get(i).bajarTemporales();
		}
		
	}
	
	public boolean puedoFusionar(Algoformer unAlgoformer){
		return (this.estanTodosVivos() && !this.algoformersAfectadosPorNebulosa() && this.todosAlgoformersEnRango(unAlgoformer));
	}
	
	public void fusionar(Algoformer unAlgoformer){
		if (!this.puedoFusionar(unAlgoformer)){
			throw new NoPuedeFusionarseException();
		}
		this.fusion.sumarPuntosDeVida(algoformers);
		int fila = unAlgoformer.getPosicion().getFila();
		int columna = unAlgoformer.getPosicion().getColumna();
		for (int i = 0; i<algoformers.size(); i++){
			Posicion posicion = algoformers.get(i).getPosicion();
			Tablero.getTablero().sacarAlgoformer(posicion);
		}
		while (algoformers.size()>0){
			algoformers.remove(0);
		}
		algoformers.add(this.fusion);
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(fila, columna, fusion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Algoformer> getAlgoformers(){
		return algoformers;
	}
}

        

