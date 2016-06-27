package tp2.algoformers.modelo.algoformers;

public class Megatron extends Decepticon {
    
   public Megatron(){
       this.nombre = "MEGATRON";
       this.puntosDeVida = 550;
       this.ataque = 10;
       this.distanciaDeAtaque = 3;
       this.velocidadDeDesplazamiento = 1; 
       this.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/Megatron.png");
   }
    
   public void transformar(){
       estado = estado.transformarMegatron(this); 
   }
}