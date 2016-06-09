package tp2.algoformers;

public class Tablero {
    
    
    public Fila filas[];
    private static final int CANTIDAD_COLUMNAS = 100;
    private static final int CANTIDAD_FILAS = 100;
    private static Tablero instance = null;
    
    
    private Tablero(){
        filas = new Fila[CANTIDAD_FILAS];
        for (int i = 0; i<CANTIDAD_FILAS;i++){
            filas[i] = new Fila(CANTIDAD_COLUMNAS);
         }
        TerrenoTerrestre rocoso = new Rocosa();
        TerrenoAereo nube = new Nube();
    	for (int i = 1; i <= CANTIDAD_FILAS; i++){
    		for (int j = 1; j <= CANTIDAD_COLUMNAS; j++){
    			this.fila(i).columna(j).asignarTerrenoTerrestre(rocoso);
    			this.fila(i).columna(j).asignarTerrenoAereo(nube);
    		}
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
        Posicion posicion = new Posicion(CANTIDAD_FILAS/2,CANTIDAD_COLUMNAS/2);
        chispaSuprema.setPosicion(posicion);
    }
    
    public int cantidadDeFilas(){
        return CANTIDAD_FILAS;
    }
    
    public int cantidadDeColumnas(){
        return CANTIDAD_COLUMNAS;
    }
    
    public Contenido getAlgoformer(int fila, int columna){
    	if ( !this.fila(fila).columna(columna).estaOcupada() ){
    		throw new NoHayUnAlgoformerEnEsaPosicion();
    	}
    	return this.fila(fila).columna(columna).contenido;
    }
    
    public void generarZonaTerrestre(Posicion inicio, Posicion fin, TerrenoTerrestre terreno){
    	for (int i = inicio.getFila(); i <= fin.getFila(); i++){
    		for (int j = inicio.getColumna(); j <= fin.getColumna(); j++){
    			this.fila(i).columna(j).asignarTerrenoTerrestre(terreno);
    		}
    	}
    }
    
    public void generarZonaAereo(Posicion inicio, Posicion fin, TerrenoAereo terreno){
    	for (int i = inicio.getFila(); i <= fin.getFila(); i++){
    		for (int j = inicio.getColumna(); j <= fin.getColumna(); j++){
    			this.fila(i).columna(j).asignarTerrenoAereo(terreno);
    		}
    	}
    }

}
