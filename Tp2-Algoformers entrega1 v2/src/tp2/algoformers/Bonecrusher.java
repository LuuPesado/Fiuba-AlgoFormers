package tp2.algoformers;

public class Bonecrusher extends Decepticon {
    
   public Bonecrusher(){
       this.nombre = "BONECRUSHER";
       this.puntosDeVida = 200;
       this.ataque = 30;
       this.distanciaDeAtaque = 3;
       this.velocidadDeDesplazamiento = 1; 
   }
    
   public void transformar(){
       estado = estado.cambiar();
       this.ataque = 30;
       this.distanciaDeAtaque = 3;
       this.velocidadDeDesplazamiento = 8; 
   }
}
