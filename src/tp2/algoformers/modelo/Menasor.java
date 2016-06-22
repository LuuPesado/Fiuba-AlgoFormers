package tp2.algoformers.modelo;

import java.util.ArrayList;

public class Menasor extends Decepticon{
    
	   public Menasor(){
	       this.nombre = "MENASOR";
	       this.puntosDeVida = 0;
	       this.ataque = 115;
	       this.distanciaDeAtaque = 2;
	       this.velocidadDeDesplazamiento = 2; 
	   }
	    
	   public void transformar(){
	       throw new FusionNoPuedeTransformarseException(); 
	   }
	   

	   
	}