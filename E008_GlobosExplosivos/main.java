package E008_GlobosExplosivos;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        Globo globoBasico = new Globo();
        Globo[] globos = {new Globo(), new Globo(), new Globo(), new Globo(), new Globo()};
        int cantidadAire;

        System.out.println("Esto es el juego de inflar glovos");
        for (int i = 0; i < globos.length; i++) {
            while(globos[i].getCantidadAire() < globos[i].getCapacidadMaxima()) {
                System.out.printf("Jugador %d introduce la cantidad de aire: ", globos[i].getJugador());
                cantidadAire = teclado.nextInt();
                globos[i].inflar(cantidadAire);
                if (globos[i].comprobarGanadorRonda()) break;
                if (globos[i].getContadorJugador1() == 3) break;
                if (globos[i].getContadorJugador2() == 3) break;
                globos[i].decidirJugador();
                globos[i].ocultarInflado();
            }
            if (globos[i].getContadorJugador1() == 3) break;
            if (globos[i].getContadorJugador2() == 3) break;
            System.out.println("Puntuacion Jugador 1: " + globos[i].getContadorJugador1());
            System.out.println("Puntuacion Jugador 2: " + globos[i].getContadorJugador2());
        }

        globoBasico.mostrarGanadorFinal();

        for (int i = 0; i < globos.length; i++) {
            if (globos[i].getCapacidadMaxima() < globos[i].getCantidadAire()) System.out.println(globos[i].globosInflados());
            else System.out.println(globos[i].globosVacios());
        }
    }
}
