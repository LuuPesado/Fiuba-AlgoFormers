package tp2.algoformers;

public abstract class Vehiculo implements Estado {
    
    
    @Override
    public Estado transformarOptimus(Algoformer algoformer){
        algoformer.setAtaque(50);
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(2);
        return new Humanoide();
    }


    @Override
    public Estado transformarBumblebee(Algoformer algoformer){
        algoformer.setAtaque(40);
        algoformer.setDistanciaDeAtaque(1);
        algoformer.setVelocidadDeDesplazamiento(2);
        return new Humanoide();
    }

    @Override
    public Estado transformarBonecrusher(Algoformer algoformer){
        algoformer.setAtaque(30);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(1);
        return new Humanoide();
    }

    @Override
    public Estado transformarFrenzy(Algoformer algoformer){
       algoformer.setAtaque(10);
        algoformer.setDistanciaDeAtaque(5);
        algoformer.setVelocidadDeDesplazamiento(2);
        return new Humanoide();
    }

    @Override
         public Estado transformarMegatron(Algoformer algoformer){
        algoformer.setAtaque(10);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(1);
        return new Humanoide();
    }
    
    @Override
    public Estado transformarRatchet(Algoformer algoformer){
        algoformer.setAtaque(5);
        algoformer.setDistanciaDeAtaque(5);
        algoformer.setVelocidadDeDesplazamiento(1);
        return new Humanoide();
    }
    
    @Override
    public abstract void atravesarTerreno(Celda celda,Algoformer unAlgoformer);
}





