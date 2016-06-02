package tp2.algoformers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuuPesado
 */
public abstract class Autobot extends Algoformer{
    
    public boolean puedoAtacar(Algoformer unAlgoformer){
        return unAlgoformer.puedoSerAtacadoPorAutobot();
    }
    
    public boolean puedoSerAtacadoPorAutobot(){
        return false;
    }
    
    public boolean puedoSerAtacadoPorDecepticon(){
        return true;
    }
}
