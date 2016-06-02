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
public class Bonecrusher extends Decepticon {
    
   public Bonecrusher(){
       this.nombre = "BONECRUSHER";
       this.puntosDeVida = 200;
       this.ataque = 30;
       this.distanciaDeAtaque = 3;
       this.velocidadDeDesplazamiento = 1; 
   }
    
   public void transformar(){
       estado = estado.cambiar();
       this.ataque = 30;
       this.distanciaDeAtaque = 3;
       this.velocidadDeDesplazamiento = 8; 
   }
}
