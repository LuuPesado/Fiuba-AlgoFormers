package tp2.algoformers;

public interface Contenido {

    boolean estaOcupado();
    
    public void atacadoPor(Algoformer unAlgoformer);
    public Posicion getPosicion();
}
