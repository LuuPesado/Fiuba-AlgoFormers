package tp2.algoformers;

public class Superion extends Autobot {
    
	   public Superion(){
	       this.nombre = "SUPERION";
	       this.puntosDeVida = 1;
	       this.ataque = 100;
	       this.distanciaDeAtaque = 2;
	       this.velocidadDeDesplazamiento = 3; 
	   }
	    
	   public void transformar(){
	       throw new FusionNoPuedeTransformarseException(); 
	   }
	}