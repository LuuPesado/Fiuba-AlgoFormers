package tp2.algoformers.modelo;

public abstract class Vehiculo implements Estado {
    
    
    @Override
    public Estado transformarOptimus(Algoformer algoformer){
        algoformer.setAtaque(50);
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(2);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/optimusPrime.jpg");
        return new Humanoide();
    }


    @Override
    public Estado transformarBumblebee(Algoformer algoformer){
        algoformer.setAtaque(40);
        algoformer.setDistanciaDeAtaque(1);
        algoformer.setVelocidadDeDesplazamiento(2);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/bumblebee.jpg");
        return new Humanoide();
    }

    @Override
    public Estado transformarBonecrusher(Algoformer algoformer){
        algoformer.setAtaque(30);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(1);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/bonecrusher.jpg");
        return new Humanoide();
    }

    @Override
    public Estado transformarFrenzy(Algoformer algoformer){
       algoformer.setAtaque(10);
        algoformer.setDistanciaDeAtaque(5);
        algoformer.setVelocidadDeDesplazamiento(2);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/frenzy.jpg");
        return new Humanoide();
    }

    @Override
        public Estado transformarMegatron(Megatron algoformer){
        algoformer.setAtaque(10);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(1);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/Megatron.jpg");
        return new Humanoide();
    }
    
    @Override
    public Estado transformarRatchet(Ratchet algoformer){
        algoformer.setAtaque(5);
        algoformer.setDistanciaDeAtaque(5);
        algoformer.setVelocidadDeDesplazamiento(1);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/ratchet.jpg");
        return new Humanoide();
    }
    
    @Override
    public abstract void atravesarTerreno(Celda celda,Algoformer unAlgoformer);
}





