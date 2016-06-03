package tp2.algoformers;

public interface Estado {

    public Estado transformarOptimus(Algoformer algoformer);
    
    public Estado transformarBumblebee(Algoformer algoformer);
    
    public Estado transformarBonecrusher(Algoformer algoformer);
    
    public Estado transformarFrenzy(Algoformer algoformer);
    
    public Estado transformarMegatron(Algoformer algoformer);
    
    public Estado transformarRatchet(Algoformer algoformer);
    
}
