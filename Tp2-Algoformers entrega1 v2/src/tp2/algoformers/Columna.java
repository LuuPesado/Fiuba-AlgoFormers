package tp2.algoformers;

public class Columna {
    
    public Celda celdas[];
    
    public Columna(int largoDeLaColumna){
        celdas = new Celda[largoDeLaColumna]; 
        for (int i = 0; i<largoDeLaColumna;i++){
            celdas[i] = new Celda();
        }
    }
    
    public Celda celda(int posicion){
        return celdas[posicion-1];
    }
            
 }
