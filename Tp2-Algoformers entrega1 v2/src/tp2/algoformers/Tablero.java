package tp2.algoformers;

public class Tablero {
    
    
    public Fila filas[];
    private int cantidadDeColumnas;
    private int cantidadDeFilas;
   
    
    
    public Tablero(int cantidadDeFilas, int cantidadDeColumnas){
        filas = new Fila[cantidadDeFilas];
        for (int i = 0; i<cantidadDeFilas;i++){
            filas[i] = new Fila(cantidadDeColumnas);
         }
        this.cantidadDeColumnas = cantidadDeColumnas;
        this.cantidadDeFilas = cantidadDeFilas;
    }
    
    public Fila fila(int posicion){
        return filas[posicion-1];
    }
    
    public void ubicarAlgoformerEnUnaPosicion(int unaFila, int unaColumna, Algoformer unAlgoformer){
        (( this.fila(unaFila)).columna(unaColumna)).agregarAlgoformer(unAlgoformer);
        unAlgoformer.nuevaPosicion(unaFila, unaColumna);
    }
    
    public void moverAlgoformer(int fila, int columna, Algoformer unAlgoformer){
        Posicion posicionActual = unAlgoformer.posicion();
        Posicion posicionNueva = new Posicion(fila, columna);
        this.controlarMaximoTablero(fila, columna);
        this.controlarRango(posicionActual, posicionNueva, unAlgoformer.velocidad());
        this.sacarAlgoformer(posicionActual,unAlgoformer);
        this.ubicarAlgoformerEnUnaPosicion(fila, columna, unAlgoformer);
    }
   
    public void controlarMaximoTablero(int fila, int columna){
        if (( fila > cantidadDeFilas )||( columna > cantidadDeColumnas)){
            throw new FueraDeRangoException();
        } 
    }
    
    public void controlarRango(Posicion posicionActual, Posicion posicionNueva, int rango){
        int fila =  Math.abs( posicionNueva.getFila() - posicionActual.getFila() );
        int columna = Math.abs( posicionNueva.getColumna() - posicionActual.getColumna() );
        if ( Math.max(fila, columna) > rango ){
            throw new FueraDeRangoException();
        }
    }

    private void sacarAlgoformer(Posicion posicionActual, Algoformer unAlgoformer) {
        (( this.fila(posicionActual.getFila())).columna(posicionActual.getColumna())).quitarAlgoformer(unAlgoformer);
    }

    void ubicarChispaSuprema(ChispaSuprema chispaSuprema) {
        Posicion posicion = new Posicion(cantidadDeFilas/2,cantidadDeColumnas/2);
        chispaSuprema.posicion(posicion);
    }
       
}
