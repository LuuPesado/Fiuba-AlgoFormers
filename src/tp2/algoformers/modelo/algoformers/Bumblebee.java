package tp2.algoformers.modelo.algoformers;

public class Bumblebee extends Autobot {
        
   public Bumblebee(){
       this.nombre = "BUMBLEBEE";
       this.puntosDeVida = 350;
       this.ataque = 40;
       this.distanciaDeAtaque = 1;
       this.velocidadDeDesplazamiento = 2;
       this.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/bumblebee.jpg");
   }
    
   public void transformar(){
       estado = estado.transformarBumblebee(this);
   }
}
