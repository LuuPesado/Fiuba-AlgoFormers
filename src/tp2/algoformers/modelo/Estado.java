package tp2.algoformers.modelo;

public interface Estado {

    public Estado transformarOptimus(Algoformer algoformer);
    
    public Estado transformarBumblebee(Algoformer algoformer);
    
    public Estado transformarBonecrusher(Algoformer algoformer);
    
    public Estado transformarFrenzy(Algoformer algoformer);
    
    public Estado transformarMegatron(Megatron algoformer);
    
    public Estado transformarRatchet(Ratchet algoformer);
    
    public void atravesarTerreno(Celda celda,Algoformer unAlgoformer);
    
}
