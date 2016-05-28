/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalladebotes;

/**
 *
 * @author LuuPesado
 */
public class Columna {
    
    public Celda celdas[];
    
    public Columna(){
        celdas = new Celda[8]; 
        for (int i = 0; i<8;i++){
            celdas[i] = new Celda();
    }
    }
    
    public Celda celda(int posicion){
        return celdas[posicion-1];
    }
            
 }
