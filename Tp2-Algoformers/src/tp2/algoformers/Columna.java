/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.algoformers;

/**
 *
 * @author LuuPesado
 */
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
