package tp2.algoformers.modelo;

public class Frenzy extends Decepticon {
        
   public Frenzy(){
       this.nombre = "FRENZY";
       this.puntosDeVida = 400;
       this.ataque = 10;
       this.distanciaDeAtaque = 5;
       this.velocidadDeDesplazamiento = 2;
       this.setDireccionDeImagen("file:src/tp2/algoformers/vista/imagenes/frenzy.jpg");
   }
    
   public void transformar(){
       estado = estado.transformarFrenzy(this);
   }
   

}
