package tp2.algoformers.modelo;

import java.util.ArrayList;

public abstract class Algoformer implements Contenido{
    
    protected Estado estado;
    protected int velocidadDeDesplazamiento;
    protected int puntosDeVida;
    protected int ataque;
    protected int distanciaDeAtaque;
    protected String nombre;
    protected Posicion posicion;
    protected Modificadores modificadores;
    
    public Algoformer(){
        estado = new Humanoide();
        posicion = new Posicion(1,1);
        modificadores = new Modificadores();
    }
    
    public Modificadores getModificadores(){
    	return modificadores;
    }
    
    public boolean esUnBuff(){
    	return false;
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
    
    public Posicion getPosicion(){
        return posicion;
    }

    public int getDistanciaDeAtaque(){
        return this.distanciaDeAtaque;
    }
    public int getVelocidad() {
        return this.velocidadDeDesplazamiento;
    }

    public abstract boolean puedoSerAtacadoPorAutobot();

    public abstract boolean puedoSerAtacadoPorDecepticon();
    
    public abstract boolean puedoAtacar(Algoformer unAlgoformer);
    
    public void recibirDanio(int danio){
        this.puntosDeVida = this.puntosDeVida - (modificadores.afectarDanioRecibido(danio));
    }
    
    public void atacadoPor(Algoformer unAlgoformer){
        if (unAlgoformer.puedoAtacar(this)){
            this.posicion.controlarRango(unAlgoformer.getPosicion(), unAlgoformer.getDistanciaDeAtaque());
            this.recibirDanio(unAlgoformer.getModificadores().afectarAtaquePorCanion(unAlgoformer.getAtaque()));
        }
        else if (unAlgoformer == this){
            unAlgoformer.transformar();
        }else{
            throw new NoPuedoAtacarUnCompanieroException();
        }
    }
    
    public int puntosDeVida(){
        return this.puntosDeVida;
    }
   
    
    //Mover a Posicion
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
    
    
    public void agregarBuff(Contenido unBuff){
    	this.modificadores.agregarBuff(unBuff);
    }
    
    public void agregarDebuff(Debuff unDebuff){
    	this.modificadores.agregarDebuff(unDebuff);
    }
    
    public void moverAlgoformer(int fila, int columna){
    	Posicion posicionNueva = new Posicion(fila, columna);
        int pasos = this.posicion.controlarRango(posicionNueva, this.modificadores.afectarVelocidad(velocidadDeDesplazamiento));
        while ( pasos > 0 ){
        	Posicion siguientePosicion = this.calcularSiguientePosicion(posicionNueva);
        	Celda celda = Tablero.getTablero().fila(fila).columna(columna);
        	Tablero.getTablero().sacarAlgoformer(this.posicion);
        	Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(siguientePosicion.getFila(), siguientePosicion.getColumna(), this);
        	estado.atravesarTerreno(celda, this);
        	pasos = modificadores.afectarPasos(pasos);
        	pasos--;
        }
    }

	public void bajarTemporales() {
		modificadores.bajarTemporales();
	}
    
	public boolean afectadoPorBuff(Buff unBuff){
		return (this.modificadores.incluyeBuff(unBuff));
	}
	
	public boolean afectadoPorDebuff(Debuff unDebuff){
		return (this.modificadores.incluyeDebuff(unDebuff));
	}
	
	public void sumarPuntosDeVida(ArrayList<Algoformer> listaDeAlgoformers){
	    for (int i=0; i<listaDeAlgoformers.size(); i++){
	        this.puntosDeVida= puntosDeVida + listaDeAlgoformers.get(i).puntosDeVida();
	    }
	}
	
}