package tp2.algoformers;

public class Megatron extends Decepticon{
    
   public Megatron(){
       this.nombre = "MEGATRON";
       this.puntosDeVida = 550;
       this.ataque = 10;
       this.distanciaDeAtaque = 3;
       this.velocidadDeDesplazamiento = 1; 
   }
    
   public void transformar(){
       estado = estado.transformarMegatron(this); 
   }
}