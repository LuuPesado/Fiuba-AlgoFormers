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
public class Fila {
    
    
    public Columna columnas[];
    
    public Fila(){
        columnas = new Columna[8];
        for (int i = 0; i<8;i++){
            columnas[i] = new Columna();
    }
    }
    
    public Celda columna(int posicion){
        Celda celdaADevolver = (columnas[posicion-1].celda(posicion));
        return celdaADevolver;
    
    }
}