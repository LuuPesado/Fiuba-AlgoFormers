package tp2.algoformers;

import java.util.ArrayList;


public class Jugador {
    private String nombre;
    private ArrayList<Algoformer> algoformers;
    private Algoformer fusion;
   
    public Jugador(String unNombre, Algoformer unaFusion){
        this.nombre = unNombre;
        this.fusion = unaFusion;
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
        Tablero tablero = Tablero.getTablero();
        (tablero.fila(posicion.getFila()).columna(posicion.getColumna()).getContenido()).atacadoPor(algoformer);
        
    }

    public boolean estanTodosVivos(){
        boolean vivos = true;
        int i = 0;
        while (vivos && i<algoformers.size()){
                vivos = (algoformers.get(i).puntosDeVida() > 0);
                i++;
        }
        return vivos;
    }
    
    public boolean estanTodosMuertos(){
        boolean muertos = true;
        int i = 0;
        while (muertos && i<algoformers.size()){
                muertos = (algoformers.get(i).puntosDeVida() <= 0);
                i++;
        }
        return muertos;
    }
    
    public boolean ningunAlgoformerAfectadoPorNebulosa(){
        boolean noAfectado = true;
        int i = 0;
        while (noAfectado && i<algoformers.size()){
                noAfectado = (algoformers.get(i).afectadoPorDebuff(new AfectadoPorNebulosa()));
                i++;
        }
        return noAfectado;
    }
    
    public boolean todosAlgoformersEnRango(Algoformer unAlgoformer){
        boolean enRango = true;
        int i = 0;
        while (enRango && i<algoformers.size()){
        		Posicion posicion = algoformers.get(i).getPosicion();
        		int distancia = unAlgoformer.getPosicion().controlarRango(posicion, unAlgoformer.getVelocidad());
                enRango = (unAlgoformer.getVelocidad() >= distancia);
        		i++;
        }
        return enRango;
    }

	public void bajarTemporales() {
		for (int i = 0; i<algoformers.size(); i++){
			algoformers.get(i).bajarTemporales();
		}
		
	}
	
	public boolean puedoFusionar(Algoformer unAlgoformer){
		return (this.estanTodosVivos() && this.ningunAlgoformerAfectadoPorNebulosa() && this.todosAlgoformersEnRango(unAlgoformer));
	}
	public void fusionar(Algoformer unAlgoformer){
		
		if (!this.puedoFusionar(unAlgoformer)){
			throw new NoPuedeFusionarseException();
		}
		this.fusion.sumarPuntosDeVida(algoformers);
		algoformers.remove(0);
		algoformers.remove(1);
		algoformers.remove(2);
		algoformers.add(this.fusion);
		Tablero.getTablero().ubicarAlgoformerEnUnaPosicion(unAlgoformer.getPosicion().getFila(),unAlgoformer.getPosicion().getColumna(), fusion);
	}

}

        

