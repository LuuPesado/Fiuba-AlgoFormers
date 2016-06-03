package tp2.algoformers;

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
