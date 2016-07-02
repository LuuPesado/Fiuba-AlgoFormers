package tp2.algoformers.modelo;

import tp2.algoformers.modelo.buffs.Debuff;

public class AfectadoPorTormenta extends Debuff {

	public AfectadoPorTormenta(){
		nombre = "Tormenta";
		duracion = 1;
	}
	
	public int afectarAtaque(int ataque){
		return (ataque - ataque*40/100);
	}
	
	public void bajarDuracion(){
	}
}
