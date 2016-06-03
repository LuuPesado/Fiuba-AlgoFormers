package tp2.algoformers;

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
