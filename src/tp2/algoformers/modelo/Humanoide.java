package tp2.algoformers.modelo;

public class Humanoide implements Estado {
    
    public Humanoide(){
    }

    @Override
    public Estado transformarOptimus(Algoformer algoformer){
        algoformer.setAtaque(15);
        algoformer.setDistanciaDeAtaque(4);
        algoformer.setVelocidadDeDesplazamiento(5);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/vehiculoOptimus.jpg");

        return new VehiculoTerrestre();
    }

    @Override
    public Estado transformarBumblebee(Algoformer algoformer){
        algoformer.setAtaque(20);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(5);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/vehiculoBumblebee.jpg");
        return new VehiculoTerrestre();
           }

    @Override
    public Estado transformarBonecrusher(Algoformer algoformer){
        algoformer.setAtaque(30);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(8);
        return new VehiculoTerrestre();
    }

    @Override
    public Estado transformarFrenzy(Algoformer algoformer){
        algoformer.setAtaque(25);
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(6);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/vehiculoFrenzy.jpg");
        return new VehiculoTerrestre();
    }

    @Override
    public Estado transformarMegatron(Megatron algoformer){
       	algoformer.setAtaque(algoformer.getModificadores().afectarAtaquePorTormenta(55));
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(8);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/vehiculoMegatron.jpg");
        return new VehiculoAereo();
    }
         
    @Override
    public Estado transformarRatchet(Ratchet algoformer){
      	algoformer.setAtaque(algoformer.getModificadores().afectarAtaquePorTormenta(35));
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(8);
        algoformer.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/vehiculoRatchet.jpg");
        return new VehiculoAereo();
    }     

    @Override
    public void atravesarTerreno(Celda celda,Algoformer unAlgoformer) {
        celda.afectarHumanoide(unAlgoformer);
    }
}
