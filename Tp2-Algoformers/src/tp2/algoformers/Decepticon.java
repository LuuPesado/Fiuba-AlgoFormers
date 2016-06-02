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
public abstract class Decepticon extends Algoformer {
    
    
    public boolean puedoAtacar(Algoformer unAlgoformer){
        return unAlgoformer.puedoSerAtacadoPorDecepticon();
    }
    
    public boolean puedoSerAtacadoPorAutobot(){
        return true;
    }
    
    public boolean puedoSerAtacadoPorDecepticon(){
        return false;
    }
    
}
