package src.naruto.src.tipos_ninja;

import jdk.jfr.Label;
import naruto.src.tipos_ninja.NinjaDeNinjutsu;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NinjaDeNinjutsuTest {

    @Test
    @Label("Adiciona um novo jutsu ao array de Jutsu")
    public void deveUsarJutsu(){
        List<String> jutsus = new ArrayList<>();
        jutsus.add("Suiton");
        NinjaDeNinjutsu ninjaDeNinjutsu = new NinjaDeNinjutsu("Mateus",28, "tres",
                                                                jutsus,5 );
        assertEquals("Usando o Ninjutsu",ninjaDeNinjutsu.usarJutsu());
    }

    @Test
    @Label("Deve desviar, conforme o lado escolhido no parametro")
    public void deveDesviar(){
        List<String> jutsus = new ArrayList<>();
        jutsus.add("Fuuton");
        NinjaDeNinjutsu ninjaDeNinjutsu = new NinjaDeNinjutsu("Mateus",28, "tres", jutsus,9);
        assertEquals("Desviou para: Frente", ninjaDeNinjutsu.desviar("Frente"));
    }
}
