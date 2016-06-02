package tp2.algoformers;

public class Humanoide implements Estado {
    
    private static Humanoide instance = null;
    
    private Humanoide(){
    }
    
    public static Humanoide getInstance(){
       if (Humanoide.instance == null){
           Humanoide.instance = new Humanoide();
       }
       return Humanoide.instance;
    }
    
    
    public Estado cambiar(){
        return Vehiculo.getInstance();
    }
}
