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
public class Vehiculo implements Estado {
    
    private static Vehiculo instance = null;
    
    private Vehiculo(){
    }
    
    public static Vehiculo getInstance(){
       if (Vehiculo.instance == null){
           Vehiculo.instance = new Vehiculo();
       }
       return Vehiculo.instance;
    }
    
    public Estado cambiar(){
        return Humanoide.getInstance();
    }
}
