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

	public boolean estaOcupado(){
		return false;
	}

	public boolean hayChispa(){
		return true;
	}
	@Override
	public void atacadoPor(Algoformer unAlgoformer){
		unAlgoformer.moverAlgoformer(posicion.getFila(), posicion.getColumna());
		
	}


	public boolean esUnBuff(){
		return false;
	}

	@Override
	public void setDireccionDeImagen(String unaDireccion) {
		direccionDeImagen = unaDireccion;
		
	}

	@Override
	public String getDireccionDeImagen() {
		return direccionDeImagen;
	}
}
