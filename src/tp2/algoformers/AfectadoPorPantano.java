package tp2.algoformers;

public class AfectadoPorPantano extends Debuff{

	
	public AfectadoPorPantano(){
		duracion = 1;
	}
	
	
	public int afectarPasos(int pasos){
		return pasos--;
	}

	
	
	
}
