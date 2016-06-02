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
public class Humanoide implements Estado {
    
    private static Humanoide instance = null;
    
    private Humanoide(){
    }
    
    public static Humanoide getInstance(){
       if (Humanoide.instance == null){
           Humanoide.instance = new Humanoide();
       }
       return Humanoide.instance;
    }
    
    
    public Estado cambiar(){
        return Vehiculo.getInstance();
    }
}
