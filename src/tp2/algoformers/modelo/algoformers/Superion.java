package tp2.algoformers.modelo.algoformers;


import tp2.algoformers.modelo.excepciones.FusionNoPuedeTransformarseException;

public class Superion extends Autobot  {
    
	   public Superion(){
	       this.nombre = "SUPERION";
	       this.puntosDeVida = 0;
	       this.ataque = 100;
	       this.distanciaDeAtaque = 2;
	       this.velocidadDeDesplazamiento = 3; 
	       this.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/algoformers/Superion.png");
	   }
	    
	   public void transformar(){
	       throw new FusionNoPuedeTransformarseException(); 
	   }

	}