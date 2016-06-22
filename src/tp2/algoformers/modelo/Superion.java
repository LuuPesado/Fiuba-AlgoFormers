package tp2.algoformers.modelo;

import java.util.ArrayList;

public class Superion extends Autobot  {
    
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