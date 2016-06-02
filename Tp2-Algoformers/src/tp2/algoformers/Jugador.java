/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.algoformers;

import java.util.ArrayList;

/**
 *
 * @author LuuPesado
 */
public class Jugador {
    
    public String nombre;
    public ArrayList<Algoformer> algoformers;
    
    public Jugador(String unNombre){
        this.nombre = unNombre;
    }
    
    public void agregarAlgoformers(ArrayList<Algoformer> unaListaDeAlgoformers){
        algoformers = unaListaDeAlgoformers;
    }            
        
   
    public void miTurno(){
    }
}
