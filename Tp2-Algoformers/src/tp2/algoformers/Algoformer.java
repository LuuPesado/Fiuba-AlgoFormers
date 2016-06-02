/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.algoformers;

/**
 *
 * @author LuuPesado
 */
public abstract class Algoformer implements Contenido{
    
    protected Estado estado;
    protected int velocidadDeDesplazamiento;
    protected int puntosDeVida;
    protected int ataque;
    protected int distanciaDeAtaque;
    protected String nombre;
    protected Posicion posicion;
    
    
    public Algoformer(){
        estado = Humanoide.getInstance();
        posicion = new Posicion(1,1);
    }
    
    public boolean estaOcupado(){
        return true;
    }
    
    public Estado estado(){
        return estado;
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
        return (this.velocidadDeDesplazamiento);
    }

    public abstract boolean puedoSerAtacadoPorAutobot();

    public abstract boolean puedoSerAtacadoPorDecepticon();
    
    public abstract boolean puedoAtacar(Algoformer unAlgoformer);
    
    public void recibirDaño(int daño){
        this.puntosDeVida = this.puntosDeVida - daño;
    }
    
    public void atacar(Algoformer unAlgoformer){
        this.controlarRango(posicion, unAlgoformer.posicion(), distanciaDeAtaque);
        if (this.puedoAtacar(unAlgoformer)){
            unAlgoformer.recibirDaño(ataque);
        }
        else {
            throw new NoPuedoAtacarUnCompañeroException();
        }
    }
    
    public int puntosDeVida(){
        return this.puntosDeVida;
    }
    
    public void controlarRango(Posicion posicionActual, Posicion posicionNueva, int rango){
        int fila =  Math.abs( posicionNueva.getFila() - posicionActual.getFila() );
        int columna = Math.abs( posicionNueva.getColumna() - posicionActual.getColumna() );
        if ( Math.max(fila, columna) > rango ){
            throw new FueraDeRangoException();
        }
    }


}