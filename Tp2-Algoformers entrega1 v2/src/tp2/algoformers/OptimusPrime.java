package tp2.algoformers;

public class OptimusPrime extends Autobot{
    
   public OptimusPrime(){
       this.nombre = "OPTIMUS 'EL CONSTRUCTOR' PRIME";
       this.puntosDeVida = 500;
       this.ataque = 50;
       this.distanciaDeAtaque = 2;
       this.velocidadDeDesplazamiento = 2; 
   }
    
   public void transformar(){
       estado = estado.cambiar();
       this.ataque = 15;
       this.distanciaDeAtaque = 4;
       this.velocidadDeDesplazamiento = 5; 
   }
   
   
}
