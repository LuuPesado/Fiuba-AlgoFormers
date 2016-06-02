package tp2.algoformers;

import java.util.ArrayList;

public class Jugador {
    
    public String nombre;
    public ArrayList<Algoformer> algoformers;
    
    public Jugador(String unNombre){
        this.nombre = unNombre;
    }
    
    public void agregarAlgoformers(ArrayList<Algoformer> unaListaDeAlgoformers){
        algoformers = unaListaDeAlgoformers;
    }            
    
    public void miTurno(Tablero tablero, int numeroDeAlgoformer, int accion, int fila, int columna, Algoformer objetivo){
        //Mal implementado, obvio. Después vemos
        //El numero de accion decide qué va a hacer el Algoformer de número 'numeroDeAlgoformer' dado
        switch (accion) {
            case 1: //mover a (posicionX, posicionY)
                    tablero.moverAlgoformer(fila, columna, algoformers.get(numeroDeAlgoformer));
                    break;
            case 2: //atacar al objetivo
                    algoformers.get(numeroDeAlgoformer).atacar(objetivo);
                    break;
            case 3: //transformarse
                    algoformers.get(numeroDeAlgoformer).transformar();
                    break;
            default: ;
                     break;
        }
        
    }
}
        

