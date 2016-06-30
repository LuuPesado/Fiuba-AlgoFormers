package tp2.algoformers.modelo;

import java.util.Random;

import tp2.algoformers.modelo.terrenos.Espinas;
import tp2.algoformers.modelo.terrenos.NebulosaDeAndromeda;
import tp2.algoformers.modelo.terrenos.Pantano;
import tp2.algoformers.modelo.terrenos.TerrenoAereo;
import tp2.algoformers.modelo.terrenos.TerrenoTerrestre;
import tp2.algoformers.modelo.terrenos.TormentaPsionica;

public class FabricaTerrenos {
	
	private int filas;
	private int columnas;
	
	public FabricaTerrenos(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
	}
	
	public void fabricarTerrenosAlAzar(int cantidadNebulosas, int cantidadTormentas, int cantidadPantanos, int cantidadEspinas){
		Posicion inicio = new Posicion(1,1);
		Posicion fin = new Posicion(filas,columnas);
		this.generarTerrenosAereos(inicio, fin, cantidadTormentas, new TormentaPsionica());
		this.generarTerrenosAereos(inicio, fin, cantidadNebulosas, new NebulosaDeAndromeda());
		this.generarTerrenosTerrestres(inicio, fin, cantidadPantanos, new Pantano());
		this.generarTerrenosTerrestres(inicio, fin, cantidadEspinas, new Espinas());
	}
	
	private void generarTerrenosAereos(Posicion inicio, Posicion fin, int cantidadDeTerrenos, TerrenoAereo terrenoAereo){
		Random rnd = new Random();
		for ( int i = 1; i <= cantidadDeTerrenos; i++ ){
			int fila1 = rnd.nextInt(filas);
			int columna1 = rnd.nextInt(columnas);
			//me fijo que ninguno sea menor a 2, para que los terrenos comiencen a partir de la posicion (2,2)
			//para que no se generen estos terrenos donde comienzan los algoformers
			//y rnd.nextInt(numero) excluye a numero por lo que se generaran hasta (18,18)
			while (fila1<2 || columna1<2){ 
				fila1 = rnd.nextInt(filas);
				columna1 = rnd.nextInt(columnas);
			}
			inicio.fila(fila1);
			inicio.columna(columna1);
			int fila2 = rnd.nextInt(filas);
			int columna2 = rnd.nextInt(columnas);
			while (fila2<2 || columna2<2){
				fila2 = rnd.nextInt(filas);
				columna2 = rnd.nextInt(columnas);
			}
			fin.fila(fila2);
			fin.columna(columna2);
			Tablero.getTablero().generarZonaAereo(inicio, fin, terrenoAereo);
		}
	}
	
	private void generarTerrenosTerrestres(Posicion inicio, Posicion fin, int cantidadDeTerrenos, TerrenoTerrestre terrenoTerrestre){
		Random rnd = new Random();
		for ( int i = 1; i <= cantidadDeTerrenos; i++ ){
			int fila1 = rnd.nextInt(filas);
			int columna1 = rnd.nextInt(columnas);
			while (fila1<2 || columna1<2){
				fila1 = rnd.nextInt(filas);
				columna1 = rnd.nextInt(columnas);
			}
			inicio.fila(fila1);
			inicio.columna(columna1);
			int fila2 = rnd.nextInt(filas);
			int columna2 = rnd.nextInt(columnas);
			while (fila2<2 || columna2<2){
				fila2 = rnd.nextInt(filas);
				columna2 = rnd.nextInt(columnas);
			}
			fin.fila(fila2);
			fin.columna(columna2);
			Tablero.getTablero().generarZonaTerrestre(inicio, fin, terrenoTerrestre);
		}
	}
	
}

