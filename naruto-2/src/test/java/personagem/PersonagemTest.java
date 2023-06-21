package personagem;

import com.example.demo.service.DesvioManual;
import com.example.demo.jutsu.Jutsu;
import com.example.demo.service.Ninjutsu;
import com.example.demo.model.Personagem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonagemTest {



    private InputStream systemIn = System.in;
    private String desviarRespostaSim = "S\n";
    private String desviarRespostaNao = "N\n";
    private Personagem personagem1;
    private Personagem personagem2;
    private Jutsu jutsu;

    @BeforeEach
    void setUp() {
        System.setIn(systemIn);

        personagem1 = new Personagem("Naruto", new DesvioManual());
        personagem2 = new Personagem("Sasuke", new DesvioManual());
        personagem1.adicionarJutsu("Rasengan",new Ninjutsu(20));
        personagem2.adicionarJutsu("Chidori",new Ninjutsu(60));
    }

    @Test
    @DisplayName("Verifica se jutisu esta presente no Map de jutsus")
    void adicionarJutsu() {

        Map<String,Jutsu> jutsuMap = personagem1.getJutsus();

        assertTrue(personagem1.getJutsus().containsKey("Rasengan"));
    }

    @Test
    @DisplayName("Se a resposta de desvio for sim")
    void testUsarJutsu_Sucesso() {

        simulateUserInput(desviarRespostaSim);
        personagem1.usarJutsu("Rasengan",personagem2);
        personagem2.usarJutsu("Chidori",personagem1);

        assertEquals(80,personagem2.getVida());
        assertEquals(90,personagem1.getChakra());

        assertEquals(40,personagem1.getVida());
        assertEquals(90,personagem2.getChakra());
    }

    @Test
    @DisplayName("Se a resposta de desvio for nao")
    void testUsarJutsu_Falhou() {

        simulateUserInput(desviarRespostaNao);
        personagem1.usarJutsu("Rasengan",personagem2);
        personagem2.usarJutsu("Chidori",personagem1);

        assertEquals(80,personagem2.getVida());
        assertEquals(90,personagem1.getChakra());

        assertEquals(40,personagem1.getVida());
        assertEquals(90,personagem2.getChakra());
    }



    @Test
    @DisplayName("Verifica se personagem tem o jutsu ecolhido")
    void testUsarJutsu_JutsuInvalido(){
        personagem1.usarJutsu("Chidori", personagem2);

        assertEquals(100, personagem2.getVida());
    }

    @Test
    @DisplayName("Verifica se tem chakra suficiente")
    void testUsarJutsu_SemChakra() {
        personagem1.setChakra(5);

        personagem1.usarJutsu("Rasengan",personagem2);

        assertEquals(100,personagem2.getVida());
        assertEquals(5,personagem1.getChakra());
    }

    @Test
    @DisplayName("Quando a vida zerar")
    public void testReceberDano_VidaZero() {
        personagem1.receberDano(110);

        assertEquals(0, personagem1.getVida());
    }

    @Test
    @DisplayName("Desviou com sucesso")
    void desviar_Sucesso() {
        simulateUserInput(desviarRespostaSim);
        assertTrue(personagem1.desviar());
    }

    @Test
    @DisplayName("Nao desviou com sucesso")
    void optouPorNaoDesviar(){
        simulateUserInput(desviarRespostaNao);
        assertFalse(personagem2.desviar());
    }

    private void simulateUserInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}