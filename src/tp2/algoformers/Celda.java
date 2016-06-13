package tp2.algoformers;

import java.util.ArrayList;
import java.util.Random;

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
    public void asignarTerrenoTerrestre(TerrenoTerrestre unTerreno){
    	this.terrenoTerrestre = unTerreno;
    }
    
    public void asignarTerrenoAereo(TerrenoAereo unTerreno){
    	this.terrenoAereo = unTerreno;
    }
    
    
    public boolean estaOcupada(){
        return contenido.estaOcupado();
    }
    
    public void agregarAlgoformer(Algoformer unAlgoformer){
        if (!(this.estaOcupada())){
    		contenido = unAlgoformer;
        } else {
        	throw new LaCeldaYaTieneUnAlgoformer();
        }
    }

    public void quitarAlgoformer() {
        this.contenido = new Vacio(posicion.getFila(), posicion.getColumna());
    }

    
    public void afectarHumanoide(Algoformer unAlgoformer) {
        terrenoTerrestre.afectarHumanoide(unAlgoformer);
    }

    void afectarVehiculoAereo(Algoformer unAlgoformer) {
        terrenoAereo.afectarVehiculo(unAlgoformer);
    }

    void afectarVehiculoTerrestre(Algoformer unAlgoformer) {
         terrenoTerrestre.afectarVehiculo(unAlgoformer);
    }
    
}