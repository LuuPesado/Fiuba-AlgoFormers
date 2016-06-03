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
    
    public void controlarRango(Posicion posicionNueva, int rango){
        int movimientoEnFila =  Math.abs( posicionNueva.getFila() - fila );
        int movimientoEnColumna = Math.abs( posicionNueva.getColumna() - columna );
        if ( Math.max(movimientoEnFila, movimientoEnColumna) > rango ){
            throw new FueraDeRangoException();
        }
    }
 }
