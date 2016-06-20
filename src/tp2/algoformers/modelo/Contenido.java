package tp2.algoformers.modelo;

public interface Contenido {

    public boolean estaOcupado();
    
    public void atacadoPor(Algoformer unAlgoformer);
    
    public Posicion getPosicion();

	public boolean esUnBuff();
	
	public void setDireccionDeImagen(String unaDireccion);
	
	public String getDireccionDeImagen();
	
}
