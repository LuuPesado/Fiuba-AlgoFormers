package tp2.algoformers;

public class AfectadoPorNebulosa extends Debuff {
	
	public AfectadoPorNebulosa(){
		duracion = 3;
	}
	
	public void afectarTurnos(){
		throw new AtrapadoEnNebulosaException();
	}
	
}
