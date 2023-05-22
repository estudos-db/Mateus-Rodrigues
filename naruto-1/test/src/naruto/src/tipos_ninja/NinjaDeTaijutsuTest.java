package src.naruto.src.tipos_ninja;

import jdk.jfr.Label;
import naruto.src.tipos_ninja.NinjaDeTaijutsu;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NinjaDeTaijutsuTest {

    @Test
    @Label("Adiciona um novo jutsu ao array de Jutsu")
    public void deveUsarJutsu(){
        List<String> jutsus = new ArrayList<>();
        jutsus.add("Suiton");
        NinjaDeTaijutsu ninjaDeTaijutsu = new NinjaDeTaijutsu("Mateus",28, "tres",
                jutsus,5 );
        assertEquals("Usando o Taitambém jutsu",ninjaDeTaijutsu.usarJutsu());
    }

    @Test
    @Label("Deve desviar, conforme o lado escolhido no parametro")
    public void deveDesviar(){
        List<String> jutsus = new ArrayList<>();
        jutsus.add("Fuuton");
        NinjaDeTaijutsu ninjaDeTaijutsu = new NinjaDeTaijutsu("Mateus",28, "tres", jutsus,15);
        assertEquals("Desviou para: Lado", ninjaDeTaijutsu.desviar("Lado"));
    }
}
