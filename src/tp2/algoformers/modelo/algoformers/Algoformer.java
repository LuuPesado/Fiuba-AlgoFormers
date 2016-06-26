package tp2.algoformers.modelo.algoformers;

import java.util.ArrayList;

import tp2.algoformers.modelo.Celda;
import tp2.algoformers.modelo.Contenido;
import tp2.algoformers.modelo.Estado;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.Tablero;
import tp2.algoformers.modelo.buffs.Buff;
import tp2.algoformers.modelo.buffs.Debuff;
import tp2.algoformers.modelo.buffs.Modificadores;
import tp2.algoformers.modelo.excepciones.NoPuedoAtacarUnCompanieroException;

public abstract class Algoformer implements Contenido{
    
    protected Estado estado;
    protected int velocidadDeDesplazamiento;
    protected int puntosDeVida;
    protected int ataque;
    protected int distanciaDeAtaque;
    protected String nombre;
    protected Posicion posicion;
    protected Modificadores modificadores;
    protected String direccionDeImagen;
    
    
    public Algoformer(){
        estado = new Humanoide();
        posicion = new Posicion(1,1);
        modificadores = new Modificadores();
    }
    public void setNombre(String unNombre){
    	nombre = unNombre;
    }
    public String getNombre(){
    	return nombre;
    }
    
    public void setDireccionDeImagen(String unaDireccion){
    	direccionDeImagen = unaDireccion;
    }
    
    public String getDireccionDeImagen(){
    	return direccionDeImagen;
    }
    
    public int getPuntosDeVida(){
    	return puntosDeVida;
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
    
    public boolean hayChispa(){
    	return false;
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
        	Posicion siguientePosicion = posicionNueva.calcularSiguientePosicion(this.posicion);
        	Celda celda = Tablero.getTablero().fila(fila).columna(columna);
        	Tablero.getTablero().sacarAlgoformer(this.posicion);
        	Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(siguientePosicion.getFila(), siguientePosicion.getColumna(), this);
        	estado.atravesarTerreno(celda, this);
        	pasos = modificadores.afectarPasos(pasos);
        	pasos--;
        }
    }
    
   public void sumarPuntosDeVida(ArrayList<Algoformer> listaDeAlgoformers){
	    for (int i=0; i<listaDeAlgoformers.size(); i++){
	        this.puntosDeVida= puntosDeVida + listaDeAlgoformers.get(i).puntosDeVida();
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
	
	
}