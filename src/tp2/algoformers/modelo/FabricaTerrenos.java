package tp2.algoformers.modelo;

import java.util.ArrayList;
import java.util.Random;

public class FabricaTerrenos {
	
	private int filas;
	private int columnas;
	
	public FabricaTerrenos(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
	}
	
	public void fabricarTerrenosAlAzar(int cantidadNebulosas, int cantidadTormentas, int cantidadPantanos, int cantidadEspinas){
		Posicion inicio = new Posicion(0,0);
		Posicion fin = new Posicion(filas,columnas);
		Tablero.getTablero().generarZonaAereo(inicio, fin, new Nube());
		Tablero.getTablero().generarZonaTerrestre(inicio, fin, new Rocosa());
		//ArrayList<TerrenoAereo> terrenosAereos = this.getTerrenosAereos();
		//ArrayList<TerrenoTerrestre> terrenosTerrestres = this.getTerrenosTerrestres();
		this.generarTerrenosAereo(inicio, fin, cantidadTormentas, new TormentaPsionica());
		this.generarTerrenosAereo(inicio, fin, cantidadNebulosas, new NebulosaDeAndromeda());
		this.generarTerrenosTerrestres(inicio, fin, cantidadPantanos, new Pantano());
		this.generarTerrenosTerrestres(inicio, fin, cantidadEspinas, new Espinas());
	}
	
	private void generarTerrenosAereo(Posicion inicio, Posicion fin, int cantidadTormentas,TerrenoAereo terrenoAereo){
		Random rnd = new Random();
		for ( int i = 1; i <= cantidadTormentas; i++ ){
			int fila = rnd.nextInt(filas);
			int columna = rnd.nextInt(columnas);
			inicio.fila(fila);
			inicio.columna(columna);
			fin.fila(fila);
			fin.columna(columna);
			Tablero.getTablero().generarZonaAereo(inicio,fin,terrenoAereo);
		}
	}
	
	private void generarTerrenosTerrestres(Posicion inicio, Posicion fin, int cantidadDeTerreno,TerrenoTerrestre terrenoTerrestre){
		Random rnd = new Random();
		for ( int i = 1; i <= cantidadDeTerreno; i++ ){
			int fila = rnd.nextInt(filas);
			int columna = rnd.nextInt(columnas);
			inicio.fila(fila);
			inicio.columna(columna);
			fin.fila(fila);
			fin.columna(columna);
			Tablero.getTablero().generarZonaTerrestre(inicio,fin,terrenoTerrestre);
		}
	}
	
	/*private ArrayList<TerrenoAereo> getTerrenosAereos(){
		ArrayList<TerrenoAereo> terrenos = new ArrayList<TerrenoAereo>();
		terrenos.add(new Nube());
		terrenos.add(new NebulosaDeAndromeda());
		terrenos.add(new TormentaPsionica());
		return terrenos;
	}

	private ArrayList<TerrenoTerrestre>	getTerrenosTerrestres(){
		ArrayList<TerrenoTerrestre> terrenos = new ArrayList<TerrenoTerrestre>();
		terrenos.add(new Rocosa());
		terrenos.add(new Pantano());
		terrenos.add(new Espinas());
		return terrenos;
	}*/
}

