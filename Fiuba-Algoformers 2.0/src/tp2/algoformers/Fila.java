package tp2.algoformers;

import tp2.algoformers.Columna;

public class Fila {
    
    
    public Columna columnas[];
    
    public Fila(int cantidadDeColumnas){
        columnas = new Columna[cantidadDeColumnas];
        for (int i = 0; i<cantidadDeColumnas;i++){
            columnas[i] = new Columna(cantidadDeColumnas);
    }
    }
    
    public Celda columna(int posicion){
        Celda celdaADevolver = (columnas[posicion-1].celda(posicion));
        return celdaADevolver;
    
    }
}