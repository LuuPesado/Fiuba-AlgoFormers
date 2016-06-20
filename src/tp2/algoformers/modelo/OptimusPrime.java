package tp2.algoformers.modelo;

public class OptimusPrime extends Autobot{
    
   public OptimusPrime(){
       this.nombre = "OPTIMUS PRIME";
       this.puntosDeVida = 500;
       this.ataque = 50;
       this.distanciaDeAtaque = 2;
       this.velocidadDeDesplazamiento = 2; 
       this.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/optimusPrime.jpg");
   }
    
   @Override
   public void transformar(){
       estado = estado.transformarOptimus(this);
   }
  
}
