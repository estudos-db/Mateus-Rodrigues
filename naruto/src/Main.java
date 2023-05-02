import tipos_ninja.NinjaDeGenjutsu;
import tipos_ninja.NinjaDeNinjutsu;
import tipos_ninja.NinjaDeTaijutsu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        NinjaDeTaijutsu ninjaDeTaijutsu = new NinjaDeTaijutsu("Mateus", 28, "Água", new ArrayList<>(), 5 );

        ninjaDeTaijutsu.aumentaChakra(10);
        ninjaDeTaijutsu.adicionaJutsu("Suiton");
        ninjaDeTaijutsu.usarJutsu();
        ninjaDeTaijutsu.desviar("Direita");
        ninjaDeTaijutsu.informacoesPersonagem();


        NinjaDeNinjutsu ninjaDeNinjutsu =new NinjaDeNinjutsu("Julio", 20, "Terra", new ArrayList<>(), 7);
        ninjaDeNinjutsu.aumentaChakra(10);
        ninjaDeNinjutsu.adicionaJutsu("Fuuton");
        ninjaDeNinjutsu.usarJutsu();
        ninjaDeNinjutsu.desviar("Frente");
        ninjaDeNinjutsu.informacoesPersonagem();



        NinjaDeGenjutsu ninjaDeGenjutsu = new NinjaDeGenjutsu("Ana", 20, "Fogo", new ArrayList<>(), 15);
        ninjaDeGenjutsu.adicionaJutsu("Raiton");
        ninjaDeGenjutsu.aumentaChakra(4);
        ninjaDeGenjutsu.desviar("Lado");
        ninjaDeGenjutsu.informacoesPersonagem();
        ninjaDeGenjutsu.usarJutsu();




    }
}