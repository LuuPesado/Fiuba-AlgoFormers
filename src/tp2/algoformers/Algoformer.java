package tp2.algoformers;

public abstract class Algoformer implements Contenido{
    
    protected Estado estado;
    protected int velocidadDeDesplazamiento;
    protected int puntosDeVida;
    protected int ataque;
    protected int distanciaDeAtaque;
    protected String nombre;
    protected Posicion posicion;
    public boolean afectadoPorTormenta = false;

    
    public Algoformer(){
        estado = new Humanoide();
        posicion = new Posicion(1,1);
    }
    
    @Override
    public boolean estaOcupado(){
        return true;
    }
    
    public int getAtaque(){
    	return this.ataque;
    }
    
    public Estado estado(){
        return estado;
    }
    
    public void setAtaque(int ataque){
       this.ataque = ataque;
   }
   
    public void setDistanciaDeAtaque(int distanciaDeAtaque){
       this.distanciaDeAtaque = distanciaDeAtaque;
   }
   
    public void setVelocidadDeDesplazamiento(int velocidad){
       this.velocidadDeDesplazamiento = velocidad;
   }
   
    public abstract void transformar();
    
    public void nuevaPosicion(int fila, int columna){
        this.posicion.fila(fila);
        this.posicion.columna(columna);
    }
    
    public Posicion posicion(){
        return posicion;
    }

    public int velocidad() {
        return this.velocidadDeDesplazamiento;
    }

    public abstract boolean puedoSerAtacadoPorAutobot();

    public abstract boolean puedoSerAtacadoPorDecepticon();
    
    public abstract boolean puedoAtacar(Algoformer unAlgoformer);
    
    public void recibirDanio(int danio){
        this.puntosDeVida = this.puntosDeVida - danio;
    }
    
    public void atacar(Algoformer unAlgoformer){
        this.posicion.controlarRango(unAlgoformer.posicion(), distanciaDeAtaque);
        if (this.puedoAtacar(unAlgoformer)){
            unAlgoformer.recibirDanio(ataque);
        }
        else {
            throw new NoPuedoAtacarUnCompanieroException();
        }
    }
    
    public int puntosDeVida(){
        return this.puntosDeVida;
    }
    
    private Posicion calcularSiguientePosicion(Posicion posicionNueva){
    	int siguienteFila = this.posicion.getFila();
    	int siguienteColumna = this.posicion.getColumna();
    	if ((( this.posicion.getFila() - posicionNueva.getFila() ) < 0 ) && ( this.posicion.getFila() != posicionNueva.getFila() )){
    		siguienteFila++;
    	} else if ( this.posicion.getFila() != posicionNueva.getFila() ){
    		siguienteFila--;
    	}
    	if ((( this.posicion.getColumna() - posicionNueva.getColumna() ) < 0 ) && ( this.posicion.getColumna() != posicionNueva.getColumna() )){
    		siguienteColumna++;
    	} else if ( this.posicion.getColumna() != posicionNueva.getColumna() ){
    		siguienteColumna--;
    	}
    	Posicion siguientePosicion = new Posicion(siguienteFila,siguienteColumna);
    	return siguientePosicion;
    }
    
    
    public void moverAlgoformer(int fila, int columna){
    	Posicion posicionNueva = new Posicion(fila, columna);
        int pasos = this.posicion.controlarRango(posicionNueva, this.velocidad());
        while ( pasos > 0 ){
        	Posicion siguientePosicion = this.calcularSiguientePosicion(posicionNueva);
        	Celda celda = Tablero.getTablero().fila(fila).columna(columna);
        	estado.atravesarTerreno(celda, this);
        	Tablero.getTablero().sacarAlgoformer(this.posicion);
        	Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(siguientePosicion.getFila(), siguientePosicion.getColumna(), this);
        	pasos = pasos - 1;
        }
    }
    
}