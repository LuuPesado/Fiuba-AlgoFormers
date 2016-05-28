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
public class Celda {
    
    public Contenido contenido;
    
    public Celda(){
        contenido = new Agua();
    }
    
    public boolean estaOcupada(){
        return contenido.estaOcupado();
    }
    
    public void agregarBarco(Contenido unBarco){
        if (!(this.estaOcupada())){
            contenido = unBarco;
        }else{
              throw new LaCeldaYaTieneUnBote();     
        }
    }
    
    public void recibirMisil(){
        contenido.recibirMisil();
        if (contenido.loDestrui()){
            contenido = new Agua();
        }
    }
    
    public void recibirConvencional(){
        contenido.recibirConvencional();
        if (contenido.loDestrui()){
            contenido = new Agua();
        }
        
    }
    
    public void hundirBote(){
        contenido = new Agua();
    }

}
