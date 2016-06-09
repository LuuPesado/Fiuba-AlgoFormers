package tp2.algoformers;

public class Humanoide implements Estado {
    
    public Humanoide(){
    }

    @Override
    public Estado transformarOptimus(Algoformer algoformer){
        algoformer.setAtaque(15);
        algoformer.setDistanciaDeAtaque(4);
        algoformer.setVelocidadDeDesplazamiento(5);
        return new VehiculoTerrestre();
    }

    @Override
    public Estado transformarBumblebee(Algoformer algoformer){
        algoformer.setAtaque(20);
        algoformer.setDistanciaDeAtaque(3);
        algoformer.setVelocidadDeDesplazamiento(5);
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
        return new VehiculoTerrestre();
    }

    @Override
    public Estado transformarMegatron(Megatron algoformer){
        if (algoformer.afectadoPorTormenta){
        	algoformer.setAtaque(33);
        } else {
        	algoformer.setAtaque(55);
        }
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(8);
        return new VehiculoAereo();
    }
         
    @Override
    public Estado transformarRatchet(Ratchet algoformer){
    	if (algoformer.afectadoPorTormenta){
        	algoformer.setAtaque(21);
        } else {
        	algoformer.setAtaque(35);
        }
        algoformer.setDistanciaDeAtaque(2);
        algoformer.setVelocidadDeDesplazamiento(8);
        return new VehiculoAereo();
    }     

    @Override
    public void atravesarTerreno(Celda celda,Algoformer unAlgoformer) {
        celda.afectarHumanoide(unAlgoformer);
    }
}
