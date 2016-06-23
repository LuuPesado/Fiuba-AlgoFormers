package tp2.algoformers.modelo;

public class ChispaSuprema implements Contenido{
    
    private Posicion posicion;
    private boolean atrapada;

    private String direccionDeImagen;

    public ChispaSuprema(){
    	atrapada = false;
    	this.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/ChispaSupremaTablero.png");
    }
    
    public void chispaAtrapada(){
    	atrapada = true;
    }
    
    
    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }
    
    public Posicion getPosicion(){
        return this.posicion;
    }
    
    public boolean hayGanador(){
    	return atrapada;
    }

	@Override
<<<<<<< HEAD
	public boolean estaOcupado() {
		return true;
	}

	@Override
	public void atacadoPor(Algoformer unAlgoformer) {
		// TODO Auto-generated method stub Debería GANAR
=======
	public boolean estaOcupado(){
		return false;
	}

	public boolean hayChispa(){
		return true;
	}
	@Override
	public void atacadoPor(Algoformer unAlgoformer){
		unAlgoformer.moverAlgoformer(posicion.getFila(), posicion.getColumna());
>>>>>>> 054ad7b45fe7c695789f926c9dbc48303ad03a27
		
	}

	@Override
<<<<<<< HEAD
	public boolean esUnBuff() {
=======
	public boolean esUnBuff(){
>>>>>>> 054ad7b45fe7c695789f926c9dbc48303ad03a27
		return false;
	}

	@Override
<<<<<<< HEAD
	public void setDireccionDeImagen(String unaDireccion) {
		direccionDeImagen = unaDireccion;
		
	}

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
=======
	public void setDireccionDeImagen(String unaDireccion){		
	}

	@Override
	public String getDireccionDeImagen(){
		return null;
>>>>>>> 054ad7b45fe7c695789f926c9dbc48303ad03a27
	}
}
