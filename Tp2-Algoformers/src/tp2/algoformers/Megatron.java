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
public class Megatron extends Decepticon{
    
   public Megatron(){
       this.nombre = "MEGATRON";
       this.puntosDeVida = 550;
       this.ataque = 10;
       this.distanciaDeAtaque = 3;
       this.velocidadDeDesplazamiento = 1; 
   }
    
   public void transformar(){
       estado = estado.cambiar();
       this.ataque = 55;
       this.distanciaDeAtaque = 2;
       this.velocidadDeDesplazamiento = 8; 
   }
}