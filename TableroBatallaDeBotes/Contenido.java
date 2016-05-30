package batalladebotes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LucyHeavy
 */
public interface Contenido {
    
    public boolean estaOcupado();
   
    public void recibirMisil();
    
    public void recibirConvencional();
    
    public boolean loDestrui();
}
