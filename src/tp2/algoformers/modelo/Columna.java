package tp2.algoformers.modelo;

public class Columna {
    
    public Celda celdas[];
    
    public Columna(int fila, int largoDeLaColumna){
        celdas = new Celda[largoDeLaColumna]; 
        for (int i = 0; i<largoDeLaColumna;i++){
            celdas[i] = new Celda(fila+1, i+1);
        }
    }
    
    public Celda celda(int posicion){
        return celdas[posicion-1];
    }
            
 }
