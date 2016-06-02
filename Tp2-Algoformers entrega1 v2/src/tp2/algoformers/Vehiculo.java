package tp2.algoformers;

public class Vehiculo implements Estado {
    
    private static Vehiculo instance = null;
    
    private Vehiculo(){
    }
    
    public static Vehiculo getInstance(){
       if (Vehiculo.instance == null){
           Vehiculo.instance = new Vehiculo();
       }
       return Vehiculo.instance;
    }
    
    public Estado cambiar(){
        return Humanoide.getInstance();
    }
}
