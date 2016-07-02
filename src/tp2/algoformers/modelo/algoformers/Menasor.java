package tp2.algoformers.modelo.algoformers;


import tp2.algoformers.modelo.excepciones.FusionNoPuedeTransformarseException;

public class Menasor extends Decepticon{
    
	   public Menasor(){
	       this.nombre = "MENASOR";
	       this.puntosDeVida = 0;
	       this.ataque = 115;
	       this.distanciaDeAtaque = 2;
	       this.velocidadDeDesplazamiento = 2; 
	       this.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/algoformers/Menasor.png");
	   }
	    
	   public void transformar(){
	       throw new FusionNoPuedeTransformarseException(); 
	   }
	   

	   
	}