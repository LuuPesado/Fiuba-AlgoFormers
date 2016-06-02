package tp2.algoformers;

public class Bumblebee extends Autobot {
        
   public Bumblebee(){
       this.nombre = "BUMBLEBEE";
       this.puntosDeVida = 350;
       this.ataque = 40;
       this.distanciaDeAtaque = 1;
       this.velocidadDeDesplazamiento = 2; 
   }
    
   public void transformar(){
       estado = estado.cambiar();
       this.ataque = 20;
       this.distanciaDeAtaque = 3;
       this.velocidadDeDesplazamiento = 5; 
   }
}
