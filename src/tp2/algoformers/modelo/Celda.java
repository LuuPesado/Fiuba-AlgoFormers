package tp2.algoformers.modelo;

import tp2.algoformers.modelo.algoformers.Algoformer;
import tp2.algoformers.modelo.buffs.Buff;
import tp2.algoformers.modelo.excepciones.LaCeldaYaTieneUnAlgoformer;
import tp2.algoformers.modelo.terrenos.TerrenoAereo;
import tp2.algoformers.modelo.terrenos.TerrenoTerrestre;

public class Celda {
    
    private Contenido contenido;
    private TerrenoAereo terrenoAereo;
    private TerrenoTerrestre terrenoTerrestre;
    private Posicion posicion;
    
    public Celda(int fila, int columna){
        contenido = new Vacio(fila,columna);
        posicion = new Posicion(fila, columna);
    }
    
    public Contenido getContenido(){
        return contenido;
    }
    public void asignarVacio(){
    	contenido = new Vacio(posicion.getFila(), posicion.getColumna());
    }
    
    public void asignarTerrenoTerrestre(TerrenoTerrestre unTerreno){
    	this.terrenoTerrestre = unTerreno;
    }
    
    public void asignarTerrenoAereo(TerrenoAereo unTerreno){
    	this.terrenoAereo = unTerreno;
    }
    public TerrenoAereo getTerrenoAereo(){
    	return this.terrenoAereo;
    }
    
    public TerrenoTerrestre getTerrenoTerrestre(){
    	return this.terrenoTerrestre;
    }
    public boolean estaOcupada(){
        return contenido.estaOcupado();
    }
    
    public void agregarAlgoformer(Algoformer unAlgoformer){
        if (!(this.estaOcupada())){
        	this.darBuff(unAlgoformer);
        	this.darChispa();
        	contenido = unAlgoformer;
    	} else {
        	throw new LaCeldaYaTieneUnAlgoformer();
        }
    }

    private void darChispa(){
    	if (contenido.hayChispa()){
    		((ChispaSuprema) contenido).chispaAtrapada();
    	}
    }
    public void quitarAlgoformer() {
        this.contenido = new Vacio(posicion.getFila(), posicion.getColumna());
    }

    public void darBuff(Algoformer unAlgoformer){
    	if ( contenido.esUnBuff() ){
    		unAlgoformer.agregarBuff(contenido);
    	}
    }
    
    public void afectarHumanoide(Algoformer unAlgoformer) {
        terrenoTerrestre.afectarHumanoide(unAlgoformer);
    }

    public void afectarVehiculoAereo(Algoformer unAlgoformer) {
        terrenoAereo.afectarVehiculo(unAlgoformer);
    }

    public void afectarVehiculoTerrestre(Algoformer unAlgoformer) {
         terrenoTerrestre.afectarVehiculo(unAlgoformer);
    }

	public void agregarBuff(Buff unBuff) {
		if (!this.estaOcupada()){
			this.contenido = unBuff;
		}
		
	}

	public void agregarContenido(Contenido unContenido) {
		this.contenido = unContenido;
	}
    
}