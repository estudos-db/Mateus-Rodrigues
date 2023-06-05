import jutsu.Jutsu;
import ninjas.NinjaDeNinjutsu;
import ninjas.NinjaDeTaijutsu;

public class Main {
    public static void main(String[] args) {

        // Criação dos personagens
        NinjaDeTaijutsu naruto = new NinjaDeTaijutsu("Naruto");
        NinjaDeNinjutsu sasuke = new NinjaDeNinjutsu("Sasuke");

        // Criação dos jutsus
        Jutsu golpeTaijutsu = new Jutsu(30, 10);
        Jutsu jutsuFogo = new Jutsu(40, 20);

        // Adição dos jutsus aos personagens
        naruto.adicionarJutsu("Golpe de Taijutsu", golpeTaijutsu);
        sasuke.adicionarJutsu("Jutsu de Fogo", jutsuFogo);

        // Batalha entre os ninjas
        while (naruto.estaVivo() && sasuke.estaVivo()) {
            naruto.usarJutsu(sasuke);
            if (!sasuke.estaVivo()) {
                break;
            }
            sasuke.usarJutsu(naruto);
            if (!naruto.estaVivo()) {
                break;
            }
        }

        // Determinação do vencedor
        if (naruto.estaVivo() && !sasuke.estaVivo()) {
            System.out.println("Naruto venceu!");
        } else if (!naruto.estaVivo() && sasuke.estaVivo()) {
            System.out.println("Sasuke venceu!");
        } else {
            System.out.println("A batalha terminou em empate!");
        }
    }
}
