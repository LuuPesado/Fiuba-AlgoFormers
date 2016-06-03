package tp2.algoformers;

public class Tablero {
    
    
    public Fila filas[];
    private int cantidadDeColumnas = 100;
    private int cantidadDeFilas = 100;
    private static Tablero instance = null;
    
    
    private Tablero(){
        filas = new Fila[cantidadDeFilas];
        for (int i = 0; i<cantidadDeFilas;i++){
            filas[i] = new Fila(cantidadDeColumnas);
         }
    }
    
    public static Tablero getTablero(){
       if (Tablero.instance == null){
           Tablero.instance = new Tablero();
       }
       return Tablero.instance;
    }
    
    public Fila fila(int posicion){
        return filas[posicion-1];
    }
    
    public void ubicarAlgoformerEnUnaPosicion(int unaFila, int unaColumna, Algoformer unAlgoformer){
        (( this.fila(unaFila)).columna(unaColumna)).agregarAlgoformer(unAlgoformer);
        unAlgoformer.nuevaPosicion(unaFila, unaColumna);
    }
  

    public void sacarAlgoformer(Posicion posicionActual) {
        (( this.fila(posicionActual.getFila())).columna(posicionActual.getColumna())).quitarAlgoformer();
    }

    void ubicarChispaSuprema(ChispaSuprema chispaSuprema) {
        Posicion posicion = new Posicion(cantidadDeFilas/2,cantidadDeColumnas/2);
        chispaSuprema.posicion(posicion);
    }
       
}
