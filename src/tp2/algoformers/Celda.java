package tp2.algoformers;

public class Celda {
    
    public Contenido contenido;
    public TerrenoAereo terrenoAereo;
    public TerrenoTerrestre terrenoTerrestre;
    
    public Celda(){
        contenido = new Vacio();
        
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