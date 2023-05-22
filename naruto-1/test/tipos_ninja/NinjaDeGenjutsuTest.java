package tipos_ninja;

import jdk.jfr.Label;
import tipos_ninja.NinjaDeGenjutsu;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class NinjaDeGenjutsuTest {

    @Test
    @Label("Adiciona um novo jutsu ao array de Jutsus")
    public void deveUsarJutsu(){
        List<String> jutsus = new ArrayList<>();
        jutsus.add("Fuuton");
        NinjaDeGenjutsu ninjaDeGenjutsu = new NinjaDeGenjutsu("Joao",25, "tres",
                                                                jutsus,5 );
        assertEquals("Usando o Genjutsu",ninjaDeGenjutsu.usarJutsu());
    }

    @Test
    @Label("Deve desviar, conforme o lado escolhido no parametro")
    public void deveDesviar(){
        List<String> teste = new ArrayList<>();
        teste.add("Suiton");
        NinjaDeGenjutsu ninjaDeGenjutsu= new NinjaDeGenjutsu("Teste",25, "tres", teste,5 );
        assertEquals("Desviou para: Direita" , ninjaDeGenjutsu.desviar("Direita"));
    }
}
