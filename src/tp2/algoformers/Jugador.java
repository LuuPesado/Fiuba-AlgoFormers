package tp2.algoformers;

import java.util.ArrayList;


public class Jugador {
    private String nombre;
    private ArrayList<Algoformer> algoformers;
   
    public Jugador(String unNombre){
        this.nombre = unNombre;
    }
    
    public void agregarAlgoformers(ArrayList<Algoformer> unaListaDeAlgoformers){
        algoformers = unaListaDeAlgoformers;
    }

    public Algoformer elegirAlgoformer(int numeroDeAlgoformer) {
        //Después en vez de enviarla como parametro se va a elegir mediante la interfaz grafica
        return algoformers.get(numeroDeAlgoformer);
    }  
    
    private Posicion elegirPosicion(Posicion unaPosicion) {
        //Después en vez de enviarla como parametro se va a elegir mediante la interfaz grafica
        return unaPosicion;
    }
    
    public void jugar(int numeroDeAlgoformer, Posicion unaPosicion){
        Algoformer algoformer = this.elegirAlgoformer(numeroDeAlgoformer);
        Posicion posicion = this.elegirPosicion(unaPosicion);
        this.miTurno(algoformer, posicion);
    }
    
    public void miTurno(Algoformer algoformer, Posicion posicion){
        //Mal implementado, obvio. Despues vemos
        //El numero de accion decide que va a hacer el Algoformer de numero 'numeroDeAlgoformer' dado
    	Tablero tablero = Tablero.getTablero();
        Posicion posicionAlgoformer = algoformer.getPosicion();
        (tablero.fila(posicion.getFila()).columna(posicion.getColumna()).getContenido()).atacadoPor(algoformer);
        //tablero.fila(posicion.getFila()).columna(posicion.getColumna()).getContenido().atacadoPor(algoformer);

    }

    public boolean estanTodosMuertos(){
        boolean muertos = true;
        int i = 0;
        while (muertos && i<3){
                muertos = (algoformers.get(i).puntosDeVida() <= 0);
                i++;
        }
        return muertos;
    }

}

        

