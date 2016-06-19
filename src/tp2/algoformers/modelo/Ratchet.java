package tp2.algoformers.modelo;

public class Ratchet extends Autobot {
        
   public boolean afectadoPorTormenta = false;
		
   public Ratchet(){
       this.nombre = "Ratchet";
       this.puntosDeVida = 150;
       this.ataque = 5;
       this.distanciaDeAtaque = 5;
       this.velocidadDeDesplazamiento = 1; 
   }
    
   public void transformar(){
       estado = estado.transformarRatchet(this);
   }
}
