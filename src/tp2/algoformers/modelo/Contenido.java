package tp2.algoformers.modelo;

import tp2.algoformers.modelo.algoformers.Algoformer;

public interface Contenido {

    public boolean estaOcupado();
    
    public void atacadoPor(Algoformer unAlgoformer);
    
    public Posicion getPosicion();

	public boolean esUnBuff();
	
	public void setDireccionDeImagen(String unaDireccion);
	
	public String getDireccionDeImagen();

	public boolean hayChispa();

	public boolean esUnAlgoformer();
	
}
