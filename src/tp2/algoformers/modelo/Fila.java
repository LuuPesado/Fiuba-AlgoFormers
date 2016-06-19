package tp2.algoformers.modelo;


public class Fila {
    
    
    public Columna columnas[];
    
    public Fila(int fila, int cantidadDeColumnas){
        columnas = new Columna[cantidadDeColumnas];
        for (int i = 0; i<cantidadDeColumnas;i++){
            columnas[i] = new Columna(fila, cantidadDeColumnas);
    }
    }
    
    public Celda columna(int posicion){
        Celda celdaADevolver = (columnas[posicion-1].celda(posicion));
        return celdaADevolver;
    
    }
}