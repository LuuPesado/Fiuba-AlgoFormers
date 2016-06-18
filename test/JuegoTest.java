import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import tp2.algoformers.FueraDeRangoException;
import tp2.algoformers.Juego;
import tp2.algoformers.Jugador;
import tp2.algoformers.Menasor;
import tp2.algoformers.Posicion;
import tp2.algoformers.Superion;

public class JuegoTest {
    
    private static Juego juego;
    private static Jugador jugador1;
    private static Jugador jugador2;
    
    @BeforeClass
    public static void setUpBeforeClass(){
       Superion superion = new Superion();
       Menasor menasor = new Menasor();
       jugador1 = new Jugador("Martin",superion);
       jugador2 = new Jugador("Lucia",menasor);
       juego = new Juego(jugador1,jugador2);
       juego.crearTablero(); 
    }
   
    //todos funcionan bien si se los corre solos por separado    
    
    @Test
    public void test01MoverAlgoformerEnTurno(){
       //muevo el autobot 0 ubicado en (1,1) a la posicion (2,2)
       Posicion posicion = new Posicion(2,2);
       juego.jugar(0, posicion);
       Assert.assertTrue(juego.devolverAutobot(0).getPosicion().getFila() == 2);
       Assert.assertTrue(juego.devolverAutobot(0).getPosicion().getColumna() == 2);
    }
   
    @Test
    public void test02TransformarAlgoformerEnTurno(){
    	//transformar autobot 1
    	Posicion posicion = new Posicion(2,1);
    	juego.jugar(1, posicion);
    	//turno de los decepticons, muevo el decepticon 0
    	Posicion posicion2 = new Posicion(99, 99);
    	juego.jugar(0, posicion2);
    	//mover autobot 1 a posicion (7,1) (no posible en modo humanoide)
    	Posicion posicion1 = new Posicion(7,1);
    	juego.jugar(1, posicion1);
        Assert.assertTrue(juego.devolverAutobot(1).getPosicion().getFila() == 7);
        Assert.assertTrue(juego.devolverAutobot(1).getPosicion().getColumna() == 1);
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test03AtacarAUnAlgoformerFueraDeRangoLanzaUnaExcepcion(){
    	//muevo el autobot 2 ubicado en (1,2) a la posicion (1,3)
        Posicion posicion = new Posicion(1,3);
        juego.jugar(2, posicion);
        //el decepticon 0 ataca al autobot 2 en la posicion (1,3) que es fuera de rango
    	Posicion posicion1 = new Posicion(1,3);
    	juego.jugar(0, posicion1);
    }
    
}