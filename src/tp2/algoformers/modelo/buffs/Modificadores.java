package tp2.algoformers.modelo.buffs;

import java.util.ArrayList;

import tp2.algoformers.modelo.AfectadoPorNebulosa;
import tp2.algoformers.modelo.AfectadoPorPantano;
import tp2.algoformers.modelo.AfectadoPorTormenta;
import tp2.algoformers.modelo.Contenido;

public class Modificadores {

	private ArrayList<Contenido> buffs;
	private ArrayList<Debuff> debuffs;

	
	public Modificadores(){
		buffs = new ArrayList<Contenido>();
		debuffs = new ArrayList<Debuff>();
	}
	
	public void agregarBuff(Contenido unBuff){
		buffs.add(unBuff);
	}

	public void agregarDebuff(Debuff unDebuff){
		debuffs.add(unDebuff);
	}

	
	
	public int afectarPasos(int pasos){
		if (this.debuffs.contains(new AfectadoPorNebulosa())){
			return 0;
		}
		if ( this.debuffs.contains(new AfectadoPorPantano()) ){
			return new AfectadoPorPantano().afectarPasos(pasos);
		} else {
			return pasos;
		}
	}
	
	public void afectarTurnos(){
		if ( this.debuffs.contains(new AfectadoPorNebulosa()) ){
			new AfectadoPorNebulosa().afectarTurnos();
		}
	}

	public int afectarAtaquePorTormenta(int ataque){
		if ( this.debuffs.contains(new AfectadoPorTormenta()) ){
			return new AfectadoPorTormenta().afectarAtaque(ataque);
		} else {
			return ataque;
		}
	}

	
	public int afectarAtaquePorCanion(int ataque) {
		if ( this.buffs.contains(new DobleCanion(0,0)) ){
			return new DobleCanion(0,0).afectarAtaque(ataque);
		} else {
			return ataque;
		}
	}
	
	public int afectarDanioRecibido(int danio){
		if (this.buffs.contains(new BurbujaInmaculada(0,0))){
			return new BurbujaInmaculada(0,0).afectarDanio();
		} else {
			return danio;
		}
	}
	
	public int afectarVelocidad(int velocidad){
		if (this.buffs.contains(new Flash(0,0))){
			return new Flash(0,0).afectarVelocidad(velocidad);
		} else {
			return velocidad;
		}
	}

	public void bajarTemporales(){
		int i = buffs.size();
		while (i > 0){
			((Buff) buffs.get(i)).bajarDuracion();
			i--;
		}
		int j = buffs.size();
		while (j > 0){
			debuffs.get(j).bajarDuracion();
			j--;
		}
		this.sacarExpirados();
	}
	
	private void sacarExpirados(){
		int i = buffs.size();
		while (i > 0){
			Buff buff = (Buff) buffs.get(i);
			if ( buff.duracion == 0){
				buffs.remove(i);
				i--;
			}
		}
		int j = buffs.size();
		while (j > 0){
			if (debuffs.get(j).duracion == 0){
				debuffs.remove(j);
				j--;
			}
		}
	}
	
	public boolean incluyeDebuff(Debuff unDebuff){
		return (this.debuffs.contains(unDebuff));
	}
	
	public boolean incluyeBuff(Buff unBuff){
		return (this.buffs.contains(unBuff));
	}
}