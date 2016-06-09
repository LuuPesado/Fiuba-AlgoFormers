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

	public Algoformer elegirAlgoformer(int elegido) {
		return algoformers.get(elegido);
	}            
    
	 public void miTurno(int numeroDeAlgoformer, int accion, int fila, int columna, Algoformer objetivo){
	        //Mal implementado, obvio. Despues vemos
	        //El numero de accion decide que va a hacer el Algoformer de numero 'numeroDeAlgoformer' dado
	        switch (accion) {
	            case 1: //mover a (posicionX, posicionY)
	                    objetivo.moverAlgoformer(fila, columna);
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

        

