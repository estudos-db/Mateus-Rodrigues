package personagem;

import jdk.jfr.Label;
import personagem.Personagem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PersonagemTest {

    @Test
    @Label("Deve adicionar um novo objeto ao array de Strings, um novo Jutsu do tipo String")
    public void adicionaJutisu(){
        List<String> jutsus = new ArrayList<>();
        jutsus.add("Teste");
        Personagem personagem = new Personagem("Mateus",28, "tres",
                                                jutsus,5);
        assertEquals(personagem.getJutsus(), personagem.adicionaJutsu("Teste"));
    }

    @Test
    @Label("Faz a soma do Chakra atual, mais o valor passado como parâmetro, e retorna o valor desta soma")
    public void aumentaChakra(){
        List<String> jutsus = new ArrayList<>();
        Personagem personagem = new Personagem("Mateus",28, "tres",
                                                jutsus,5);
        assertEquals(personagem.getChakra() + 5, personagem.aumentaChakra(5));
    }
}
