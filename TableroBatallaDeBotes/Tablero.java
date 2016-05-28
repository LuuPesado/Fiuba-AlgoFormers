package batalladebotes;

import static java.lang.Math.random;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuuPesado
 */
public class Tablero {
    
    
    public Fila filas[];
    
    public Tablero(){
        filas = new Fila[8];
        for (int i = 0; i<8;i++){
            filas[i] = new Fila();
    }
        
    }
    
    public Fila fila(int posicion){
        return filas[posicion-1];
    }
    
    public void agregarBoteEnUnaPosicion(int unaFila, int unaColumna, Contenido unBarco){
        (( this.fila(unaFila)).columna(unaColumna)).agregarBarco(unBarco);
      }
    
    public void reiniciarTablero(){
        for (int f = 1; f<=8; f++){
            for (int c = 1; c<=8; c++){
                ((this.fila(f)).columna(c)).hundirBote();
            }
        }
    }
    
    public void colocarOchoBotesAlAzar(){
        Random random = new Random();
        int i = 1;
        while ( i <= 8){
             int fila = random.nextInt(8)+1;
             int columna = random.nextInt(8)+1;
            if (!this.fila(fila).columna(columna).estaOcupada()){
                BoteARemo bote = new BoteARemo();
                this.agregarBoteEnUnaPosicion(fila, columna, bote);
                i++;
            }
        }
    }
    
    
}
