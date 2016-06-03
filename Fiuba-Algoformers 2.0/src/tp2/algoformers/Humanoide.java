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


    public Estado transformarOptimus(Algoformer algoformer){
        algoformer.setAtaque(15);
        algoformer.setDistanciaDeAtaque(4);
        algoformer.setVelocidadDeDesplazamiento(5);
        return Vehiculo.getInstance();
    }

    public Estado transformarRatchet(Algoformer algoformer){
        algoformer.setAtaque(35);
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(8);
        return Vehiculo.getInstance();
    }

    public Estado transformarBumblebee(Algoformer algoformer){
        algoformer.setAtaque(20);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(5);
        return Vehiculo.getInstance();
    }

    public Estado transformarBonecrusher(Algoformer algoformer){
        algoformer.setAtaque(30);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(8);
        return Vehiculo.getInstance();
    }

    public Estado transformarFrenzy(Algoformer algoformer){
       algoformer.setAtaque(25);
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(6);
        return Vehiculo.getInstance();
    }

         public Estado transformarMegatron(Algoformer algoformer){
        algoformer.setAtaque(55);
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(8);
        return Vehiculo.getInstance();
    }
}
