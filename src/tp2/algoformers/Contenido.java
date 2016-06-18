package tp2.algoformers;

public interface Contenido {

    public boolean estaOcupado();
    
    public void atacadoPor(Algoformer unAlgoformer);
    
    public Posicion getPosicion();

	public boolean esUnBuff();
	
}
