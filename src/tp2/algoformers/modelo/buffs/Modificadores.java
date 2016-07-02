package tp2.algoformers.modelo.buffs;

import java.util.ArrayList;

import tp2.algoformers.modelo.AfectadoPorNebulosa;
import tp2.algoformers.modelo.AfectadoPorPantano;
import tp2.algoformers.modelo.AfectadoPorTormenta;
import tp2.algoformers.modelo.Contenido;

public class Modificadores {

	private ArrayList<Contenido> buffs;
	private ArrayList<Debuff> debuffs;
	private boolean afectadoPorTormenta;

	
	public Modificadores(){
		buffs = new ArrayList<Contenido>();
		debuffs = new ArrayList<Debuff>();
		afectadoPorTormenta = false;
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

	public boolean isAfectadoPorTormenta() {
		return afectadoPorTormenta;
	}

	public void setAfectadoPorTormenta(boolean afectadoPorTormenta) {
		this.afectadoPorTormenta = afectadoPorTormenta;
	}

	
	public int afectarAtaquePorTormenta(int ataque){
		if ( (this.debuffs.contains(new AfectadoPorTormenta())) && (!this.isAfectadoPorTormenta())){
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
		int i = 0;
		while ( i < buffs.size()){
			((Buff) buffs.get(i)).bajarDuracion();
			i++;
		}
		int j = 0;
		while (j < debuffs.size()){
			debuffs.get(j).bajarDuracion();
			j++;
		}
		this.sacarExpirados();
	}
	
	private void sacarExpirados(){
		int i = 0;
		while (i < buffs.size()){
			Buff buff = (Buff) buffs.get(i);
			if ( buff.getDuracion() == 0){
				buffs.remove(i);
			}
			i++;
		}
		int j = 0;
		while (j < debuffs.size()){
			if (debuffs.get(j).getDuracion() == 0){
				debuffs.remove(j);				
			}
			j++;
		}
	}
	
	public boolean incluyeDebuff(Debuff unDebuff){
		return (this.debuffs.contains(unDebuff));
	}
	
	public boolean incluyeBuff(Buff unBuff){
		return (this.buffs.contains(unBuff));
	}
}