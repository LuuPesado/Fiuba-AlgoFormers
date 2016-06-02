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
public class Ratchet extends Autobot {
        
   public Ratchet(){
       this.nombre = "Ratchet";
       this.puntosDeVida = 150;
       this.ataque = 5;
       this.distanciaDeAtaque = 5;
       this.velocidadDeDesplazamiento = 1; 
   }
    
   public void transformar(){
       estado = estado.cambiar();
       this.ataque = 35;
       this.distanciaDeAtaque = 2;
       this.velocidadDeDesplazamiento = 8; 
   }
}
