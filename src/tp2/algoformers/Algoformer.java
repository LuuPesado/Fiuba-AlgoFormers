package tp2.algoformers;

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
    
  
    public void moverAlgoformer(int fila, int columna){
        Posicion posicionNueva = new Posicion(fila, columna);
        this.posicion.controlarRango(posicionNueva, this.velocidad());
        Tablero.getTablero().sacarAlgoformer(posicion);
        Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(fila, columna, this);
    }
}