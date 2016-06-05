import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import tp2.algoformers.FueraDeRangoException;
import tp2.algoformers.Juego;
import tp2.algoformers.Jugador;

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
       juego.turno(jugador1, 0, 1, 3, 1, juego.devolverAutobot(0));
        
       Assert.assertTrue(juego.devolverAutobot(0).posicion().getFila() == 3);
       Assert.assertTrue(juego.devolverAutobot(0).posicion().getColumna() == 1);
    }
    
    @Test
    public void test02TransformarAlgoformerEnTurno(){
        //transformar autobot 1
        juego.turno(jugador1, 1, 3, 0, 0, juego.devolverAutobot(1));
       
        //mover autobot 1 a posicion (2,6) (no posible en modo humanoide)
        juego.turno(jugador1, 1, 1, 2, 6, juego.devolverAutobot(1));
        
        
        Assert.assertTrue(juego.devolverAutobot(1).posicion().getFila() == 2);
        Assert.assertTrue(juego.devolverAutobot(1).posicion().getColumna() == 6);
    }
    
    @Test(expected=FueraDeRangoException.class)
    public void test03AtacarAUnAlgoformerFueraDeRangoLanzaUnaExcepcion(){
         //atacar decepticon 0
        juego.turno(jugador1, 2, 2, 0, 0, juego.devolverDecepticon(0));
    }
    
}