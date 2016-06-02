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
public class Celda {
    
    public Contenido contenido;
    
    public Celda(){
        contenido = new Vacio();
    }
    
    public boolean estaOcupada(){
        return contenido.estaOcupado();
    }
    
    public void agregarAlgoformer(Algoformer unAlgoformer){
        if (!(this.estaOcupada())){
            contenido = unAlgoformer;
        }else{
              throw new LaCeldaYaTieneUnAlgoformer();     
        }
    }

    void quitarAlgoformer(Algoformer unAlgoformer) {
        this.contenido = new Vacio();
    }
    
}