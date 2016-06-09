package tp2.algoformers;



public class Posicion {
    
    public int fila;
    public int columna;
    
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
        int movimientoEnFila =  Math.abs( posicionNueva.getFila() - fila );
        int movimientoEnColumna = Math.abs( posicionNueva.getColumna() - columna );
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
 }
