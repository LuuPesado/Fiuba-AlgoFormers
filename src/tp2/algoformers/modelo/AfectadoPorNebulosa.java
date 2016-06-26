package tp2.algoformers.modelo;

import tp2.algoformers.modelo.buffs.Debuff;
import tp2.algoformers.modelo.excepciones.AtrapadoEnNebulosaException;

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
