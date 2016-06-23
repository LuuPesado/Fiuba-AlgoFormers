package tp2.algoformers.modelo;

public class ChispaSuprema implements Contenido{
    
    private Posicion posicion;
    private boolean atrapada;
    
    public ChispaSuprema(){
    	atrapada = false;
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

	@Override
	public boolean esUnBuff(){
		return false;
	}

	@Override
	public void setDireccionDeImagen(String unaDireccion){		
	}

	@Override
	public String getDireccionDeImagen(){
		return null;
	}
}
