package tp2.algoformers.modelo;

import tp2.algoformers.modelo.excepciones.FueraDeRangoException;

public class Posicion {
    
    private int fila;
    private int columna;
    
    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }
    
    public int getFila(){
        return fila;
    }
    
    public int getColumna(){
        return columna;
    }
    
    public void fila(int fila){
        this.fila = fila;
    }
    
    public void columna (int columna){
        this.columna = columna;
    }
    
    public int controlarRango(Posicion posicionNueva, int rango){
        int movimientoEnFila =  Math.abs( posicionNueva.getFila() - this.fila );
        int movimientoEnColumna = Math.abs( posicionNueva.getColumna() - this.columna );
        if ( Math.max(movimientoEnFila, movimientoEnColumna) > rango ){
            throw new FueraDeRangoException();
        }
        return Math.max(movimientoEnFila, movimientoEnColumna);
    }
    
    public boolean equals(Posicion posicion){
        boolean esIgual;
        esIgual = posicion.getFila() == this.fila;
        esIgual = ((esIgual) && (posicion.getColumna()== this.columna));
        return esIgual;
    }
    
    public Posicion calcularSiguientePosicion(Posicion posicionAnterior){
    	int siguienteFila = posicionAnterior.getFila();
    	int siguienteColumna = posicionAnterior.getColumna();
    	if ((( posicionAnterior.getFila() - this.fila ) < 0 ) && ( posicionAnterior.getFila() != this.fila )){
    		siguienteFila++;
    	} else if ( posicionAnterior.getFila() != this.fila ){
    		siguienteFila--;
    	}
    	if ((( posicionAnterior.getColumna() - this.columna ) < 0 ) && ( posicionAnterior.getColumna() != this.columna )){
    		siguienteColumna++;
    	} else if ( posicionAnterior.getColumna() != this.columna ){
    		siguienteColumna--;
    	}
    	Posicion siguientePosicion = new Posicion(siguienteFila,siguienteColumna);
        return siguientePosicion;
    }
    
    
 }
