package tp2.algoformers.modelo.buffs;

public abstract class Debuff {
	
	protected int duracion;
	protected String nombre;
	
	public abstract void bajarDuracion();
	
	public String getNombre(){
		return nombre;
	}
	
	@Override
	public boolean equals(Object unDebuff){
		return ((Debuff) unDebuff).getNombre() == this.nombre;
	}

	public int getDuracion(){
		return duracion;
	}
}
