package tp2.algoformers;

public class Frenzy extends Decepticon {
        
   public Frenzy(){
       this.nombre = "FRENZY";
       this.puntosDeVida = 400;
       this.ataque = 10;
       this.distanciaDeAtaque = 5;
       this.velocidadDeDesplazamiento = 2; 
   }
    
   public void transformar(){
       estado = estado.transformarFrenzy(this);
   }
   

}
