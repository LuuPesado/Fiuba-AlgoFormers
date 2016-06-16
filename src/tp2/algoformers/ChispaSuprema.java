package tp2.algoformers;

public class ChispaSuprema {
    
    public Posicion posicion;
    public boolean atrapada;
    
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
}
