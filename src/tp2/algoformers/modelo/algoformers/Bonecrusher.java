package tp2.algoformers.modelo.algoformers;

public class Bonecrusher extends Decepticon {
    
   public Bonecrusher(){
       this.nombre = "BONECRUSHER";
       this.puntosDeVida = 200;
       this.ataque = 30;
       this.distanciaDeAtaque = 3;
       this.velocidadDeDesplazamiento = 1; 
       this.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/algoformers/bonecrusher.png");
   }
    
   public void transformar(){
       estado = estado.transformarBonecrusher(this);
    }
}
