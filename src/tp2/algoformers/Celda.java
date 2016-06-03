package tp2.algoformers;

public class Celda {
    
    public Contenido contenido;
    
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

    void quitarAlgoformer() {
        this.contenido = new Vacio();
    }
    
}