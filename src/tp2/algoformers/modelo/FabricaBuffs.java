package tp2.algoformers.modelo;

import java.util.Random;

import tp2.algoformers.modelo.buffs.BurbujaInmaculada;
import tp2.algoformers.modelo.buffs.DobleCanion;
import tp2.algoformers.modelo.buffs.Flash;


public class FabricaBuffs {

	private int filas;
	private int columnas;
	
	public FabricaBuffs(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
	}
	
	public void fabricarBuffsAlAzar(int dobleCanion, int burbujaInmaculada, int flash){
		Random rnd = new Random();
		for (int i = 1; i <= dobleCanion; i++){
			int fil = rnd.nextInt(filas);
			int col = rnd.nextInt(columnas);
			while (fil<2 || col<2){ 
				fil = rnd.nextInt(filas);
				col = rnd.nextInt(columnas);
			}
			Tablero.getTablero().ubicarBuff(new DobleCanion(fil,col), fil, col);
		}
		for (int i = 1; i <= burbujaInmaculada; i++){
			int fil = rnd.nextInt(filas);
			int col = rnd.nextInt(columnas);
			while (fil<2 || col<2){ 
				fil = rnd.nextInt(filas);
				col = rnd.nextInt(columnas);
			}
			Tablero.getTablero().ubicarBuff(new BurbujaInmaculada(fil,col), fil, col);
		}
		for (int i = 1; i < flash; i++){
			int fil = rnd.nextInt(filas);
			int col = rnd.nextInt(columnas);
			while (fil<2 || col<2){ 
				fil = rnd.nextInt(filas);
				col = rnd.nextInt(columnas);
			}
			Tablero.getTablero().ubicarBuff(new Flash(fil,col), fil, col);
		}
	}
	
}
