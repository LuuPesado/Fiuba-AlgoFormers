package tp2.algoformers;

public class AfectadoPorTormenta extends Debuff {

	public AfectadoPorTormenta(){
		duracion = 100000;
	}
	
	public int afectarAtaque(int ataque){
		return (ataque - ataque*40/100);
	}
}
