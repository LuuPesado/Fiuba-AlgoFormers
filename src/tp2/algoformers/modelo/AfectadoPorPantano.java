package tp2.algoformers.modelo;

import tp2.algoformers.modelo.buffs.Debuff;

public class AfectadoPorPantano extends Debuff{

	
	public AfectadoPorPantano(){
		duracion = 1;
		nombre = "Pantano";
	}
	
	
	public int afectarPasos(int pasos){
		this.bajarDuracion();
		return pasos--;
	}

	public void bajarDuracion(){
		duracion--;
	}
	
	
}
