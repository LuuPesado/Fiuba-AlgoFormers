package tp2.algoformers;

import java.util.ArrayList;
import java.util.Random;

public class Celda {
    
    public Contenido contenido;
    public TerrenoAereo terrenoAereo;
    public TerrenoTerrestre terrenoTerrestre;
    
    public Celda(){
        contenido = new Vacio();
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
        }else{
              throw new LaCeldaYaTieneUnAlgoformer();     
        }
    }

    public void quitarAlgoformer() {
        this.contenido = new Vacio();
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