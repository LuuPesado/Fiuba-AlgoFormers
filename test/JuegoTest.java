import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import tp2.algoformers.modelo.FueraDeRangoException;
import tp2.algoformers.modelo.Juego;
import tp2.algoformers.modelo.Jugador;
import tp2.algoformers.modelo.Posicion;
import tp2.algoformers.modelo.Tablero;

public class JuegoTest {
    
    private static Juego juego;
    private static Jugador jugador1;
    private static Jugador jugador2;
    
    @BeforeClass
    public static void setUpBeforeClass(){
       jugador1 = new Jugador("Martin");
       jugador2 = new Jugador("Lucia");
       juego = new Juego(jugador1,jugador2);
       juego.crearTablero(); 
    }    
    
    @Test
    public void test01MoverAlgoformerEnTurno(){
       //muevo el autobot 0 ubicado en (1,1) a la posicion (2,2)
       Posicion posicion = new Posicion(2,2);
       juego.jugar(0, posicion);
       Assert.assertTrue(juego.devolverAutobot(0).getPosicion().getFila() == 2);
       Assert.assertTrue(juego.devolverAutobot(0).getPosicion().getColumna() == 2);
       //muevo el decepticon 2 ubicado en (19,18) a la posicion (19,17)
       posicion = new Posicion(19,17);
       juego.jugar(2, posicion);
       Assert.assertTrue(juego.devolverDecepticon(2).getPosicion().getFila() == 19);
       Assert.assertTrue(juego.devolverDecepticon(2).getPosicion().getColumna() == 17);
       Tablero.getTablero().reiniciarTablero();
    }
   
    @Test
    public void test02TransformarAlgoformerEnTurno(){
    	//transformar autobot 1
    	Posicion posicion = new Posicion(2,1);
    	juego.jugar(1, posicion);
    	//turno de los decepticons, muevo el decepticon 0
    	posicion = new Posicion(18, 18);
    	juego.jugar(0, posicion);
    	//mover autobot 1 a posicion (7,1) (no posible en modo humanoide)
    	posicion = new Posicion(7,1);
    	juego.jugar(1, posicion);
        Assert.assertTrue(juego.devolverAutobot(1).getPosicion().getFila() == 7);
        Assert.assertTrue(juego.devolverAutobot(1).getPosicion().getColumna() == 1);
        //turno de los decepticons, muevo el decepticon 0
    	posicion = new Posicion(18, 17);
    	juego.jugar(0, posicion);
    	Assert.assertTrue(juego.devolverDecepticon(0).getPosicion().getFila() == 18);
        Assert.assertTrue(juego.devolverDecepticon(0).getPosicion().getColumna() == 17);
        Tablero.getTablero().reiniciarTablero();
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test03AtacarAUnAlgoformerFueraDeRangoLanzaUnaExcepcion(){
    	//muevo el autobot 2 ubicado en (1,2) a la posicion (1,3)
        Posicion posicion = new Posicion(1,3);
        juego.jugar(2, posicion);
        //el decepticon 1 ataca al autobot 2 en la posicion (1,3) que es fuera de rango
    	posicion = new Posicion(1,3);
    	juego.jugar(1, posicion);
    	Tablero.getTablero().reiniciarTablero();
    }
    
}