package tp2.algoformers.modelo;

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
