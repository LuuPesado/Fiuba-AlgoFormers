import org.junit.Test;
import org.junit.Assert;
import tp2.algoformers.Algoformer;
import tp2.algoformers.Juego;
import tp2.algoformers.Jugador;

public class PruebasJuego {
    
    @Test
    public void test01creoUnJuegoYLosAlgoformersEstanBienUbicados(){
        Jugador jugador1 = new Jugador("Martin");
        Jugador jugador2 = new Jugador("Lucia");
        Juego juego = new Juego(jugador1,jugador2);
        juego.crearTablero(30,30);
        Algoformer Optimus = juego.devolverAutobot(0);
        Assert.assertTrue(Optimus.posicion().getFila() == 1);
    }
    
    @Test
    public void test02MoverAlgoformerEnTurno(){
        Jugador jugador1 = new Jugador("Santi");
        Jugador jugador2 = new Jugador("Euni");
        Juego juego = new Juego(jugador1,jugador2);
        juego.crearTablero(9,9);
        juego.turno(jugador1, 0, 1, 3, 1, juego.devolverAutobot(2));
        Assert.assertTrue(juego.devolverAutobot(0).posicion().getFila() == 3);
        Assert.assertTrue(juego.devolverAutobot(0).posicion().getColumna() == 1);
    }
    
    @Test
    public void test03TransformarAlgoformerEnTurno(){
        Jugador jugador1 = new Jugador("Santi");
        Jugador jugador2 = new Jugador("Euni");
        Juego juego = new Juego(jugador1,jugador2);
        juego.crearTablero(7,7);
        juego.turno(jugador1, 1, 3, 0, 0, juego.devolverAutobot(0));
        //transformar autobot 1
        
        juego.turno(jugador1, 1, 1, 2, 6, juego.devolverAutobot(0));
        //mover autobot 1 a posicion (2,6) (no posible en modo humanoide)
        
        Assert.assertTrue(juego.devolverAutobot(1).posicion().getFila() == 2);
        Assert.assertTrue(juego.devolverAutobot(1).posicion().getColumna() == 6);
    }
    
    @Test
    public void test04AtacarAlgoformerEnTurno(){
        Jugador jugador1 = new Jugador("Santi");
        Jugador jugador2 = new Jugador("Euni");
        Juego juego = new Juego(jugador1,jugador2);
        juego.crearTablero(5,5);
        juego.turno(jugador1, 2, 1, 2, 3, juego.devolverAutobot(2));
        //mover autobot 2 a posicion (2,3)
        juego.turno(jugador2, 0, 1, 4, 4, juego.devolverAutobot(0));
        //mover decepticon 0 a posicion (4,4)
        juego.turno(jugador1, 2, 2, 0, 0, juego.devolverDecepticon(0));
        //atacar decepticon 0
        
        Assert.assertTrue(juego.devolverDecepticon(0).puntosDeVida() == 545);
    }
    
}