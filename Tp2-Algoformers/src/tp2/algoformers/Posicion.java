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
public class Posicion {
    
    public int fila;
    public int columna;
    
    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }
    
    public int getFila(){
        return fila;
    }
    
    public int getColumna(){
        return columna;
    }
    
    public void fila(int fila){
        this.fila = fila;
    }
    
    public void columna (int columna){
        this.columna = columna;
    }
 }
