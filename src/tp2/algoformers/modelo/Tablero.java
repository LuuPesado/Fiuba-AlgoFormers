package tp2.algoformers.modelo;

import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.buffs.Buff;
import tp2.algoformers.modelo.excepciones.NoHayUnAlgoformerEnEsaPosicion;
import tp2.algoformers.modelo.terrenos.Nube;
import tp2.algoformers.modelo.terrenos.Rocosa;
import tp2.algoformers.modelo.terrenos.TerrenoAereo;
import tp2.algoformers.modelo.terrenos.TerrenoTerrestre;

public class Tablero {
    
    public Fila filas[];
    private static final int CANTIDAD_COLUMNAS = 19;
    private static final int CANTIDAD_FILAS = 19;
    private static Tablero instance = null;
    
    private Tablero(){
        filas = new Fila[CANTIDAD_FILAS];
        for (int i = 0; i<CANTIDAD_FILAS;i++){
            filas[i] = new Fila(i, CANTIDAD_COLUMNAS);
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
    
    public void reiniciarTablero(){
    	Tablero.instance = null;
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

    public void ubicarChispaSuprema(ChispaSuprema chispaSuprema) {
        Posicion posicion = new Posicion((CANTIDAD_FILAS+1)/2,(CANTIDAD_FILAS+1)/2);
        chispaSuprema.setPosicion(posicion);
        this.fila((CANTIDAD_FILAS+1)/2).columna((CANTIDAD_COLUMNAS+1)/2).agregarContenido(chispaSuprema);
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
    	return this.fila(fila).columna(columna).getContenido();
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

	public void ubicarBuff(Buff unBuff, int unaFila, int unaColumna) {
		(( this.fila(unaFila)).columna(unaColumna)).agregarBuff(unBuff);
	}

}