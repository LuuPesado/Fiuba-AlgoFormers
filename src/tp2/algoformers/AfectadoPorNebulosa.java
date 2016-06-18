package tp2.algoformers;

public class AfectadoPorNebulosa extends Debuff {
	
	public AfectadoPorNebulosa(){
		duracion = 3;
		nombre = "Nebulosa";
	}
	
	public void afectarTurnos(){
		throw new AtrapadoEnNebulosaException();
	}
	
	public void bajarDuracion(){
		duracion--;
	}
	
}