package tp2.algoformers.modelo;

public class AfectadoPorPantano extends Debuff{

	
	public AfectadoPorPantano(){
		duracion = 1;
		nombre = "Pantano";
	}
	
	
	public int afectarPasos(int pasos){
		return pasos--;
	}

	public void bajarDuracion(){
		duracion--;
	}
	
	
}
