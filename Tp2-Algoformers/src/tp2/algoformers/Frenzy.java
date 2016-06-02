/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.algoformers;

/**
 *
 * @author LuuPesado
 */
public class Frenzy extends Decepticon {
        
   public Frenzy(){
       this.nombre = "FRENZY";
       this.puntosDeVida = 400;
       this.ataque = 10;
       this.distanciaDeAtaque = 5;
       this.velocidadDeDesplazamiento = 2; 
   }
    
   public void transformar(){
       estado = estado.cambiar();
       this.ataque = 25;
       this.distanciaDeAtaque = 2;
       this.velocidadDeDesplazamiento = 6; 
   }
}
