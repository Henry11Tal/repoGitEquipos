package E008_GlobosExplosivos;
import java.util.Random;

public class Globo {
    private int capacidadMaxima;
    private int cantidadAire;
    static int jugador = 1;
    static int contadorJugador1 = 0;
    static int contadorJugador2 = 0;

    //Constructors

    Globo(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    Globo() {
        Random rand = new Random();
        this.capacidadMaxima = rand.nextInt(10, 50);
    }

    // Getter and Setter

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getCantidadAire() {
        return cantidadAire;
    }

    public int getJugador() {
        return jugador;
    }

    public int getContadorJugador1() {
        return contadorJugador1;
    }

    public int getContadorJugador2() {
        return contadorJugador2;
    }

    //Methods

    public void inflar(int cantidadAire) {
        this.cantidadAire += cantidadAire;
    }

    public int decidirJugador() {
        if (jugador == 1) jugador = 2; else jugador = 1;
        return jugador;
    }

    public boolean comprobarGanadorRonda() {
        boolean explota = false;
        if (cantidadAire >= capacidadMaxima) {
            if (jugador == 1) {
                System.out.println("Jugador 2 se lleva la ronda");
                contadorJugador2++;
                explota = true;
            }
            else {
                System.out.println("Jugador 1 se lleva la ronda");
                contadorJugador1++;
                explota = true;
            }
        }
        return explota;
    }

    public void mostrarGanadorFinal() {
        if (contadorJugador1 > contadorJugador2) System.out.println("Jugador 1 has ganado!!");
        else System.out.println("Jugador 2 has ganado!!");
    }

    public void ocultarInflado() {
        for (int j = 0; j < 10; j++) System.out.println();
    }

    public StringBuilder globosInflados() {
        StringBuilder globos = new StringBuilder();
        for (int i = 0; i < this.capacidadMaxima; i++) {
            globos.append("* ");
        }
        return globos;
    }

    public StringBuilder globosVacios() {
        StringBuilder globos = new StringBuilder();
        for (int i = 0; i < this.capacidadMaxima; i++) {
            globos.append("o ");
        }
        return globos;
    }
}