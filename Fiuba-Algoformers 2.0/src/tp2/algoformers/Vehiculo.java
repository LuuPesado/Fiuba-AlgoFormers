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
    
    
    @Override
    public Estado transformarOptimus(Algoformer algoformer){
        algoformer.setAtaque(50);
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(2);
        return Humanoide.getInstance();
    }

    @Override
    public Estado transformarRatchet(Algoformer algoformer){
        algoformer.setAtaque(5);
        algoformer.setDistanciaDeAtaque(5);
        algoformer.setVelocidadDeDesplazamiento(1);
        return Humanoide.getInstance();
    }

    @Override
    public Estado transformarBumblebee(Algoformer algoformer){
        algoformer.setAtaque(40);
        algoformer.setDistanciaDeAtaque(1);
        algoformer.setVelocidadDeDesplazamiento(2);
        return Humanoide.getInstance();
    }

    @Override
    public Estado transformarBonecrusher(Algoformer algoformer){
        algoformer.setAtaque(30);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(1);
        return Humanoide.getInstance();
    }

    @Override
    public Estado transformarFrenzy(Algoformer algoformer){
       algoformer.setAtaque(10);
        algoformer.setDistanciaDeAtaque(5);
        algoformer.setVelocidadDeDesplazamiento(2);
        return Humanoide.getInstance();
    }

    @Override
         public Estado transformarMegatron(Algoformer algoformer){
        algoformer.setAtaque(10);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(1);
        return Humanoide.getInstance();
    }
}





