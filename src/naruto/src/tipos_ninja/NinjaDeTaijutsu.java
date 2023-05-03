package naruto.src.tipos_ninja;

import naruto.src.interfaces.NinjaInterface;
import naruto.src.personagem.Personagem;

import java.util.List;

public class NinjaDeTaijutsu extends Personagem implements NinjaInterface {


    public NinjaDeTaijutsu(String nome, int idade, String aldeia, List<String> jutsus, int chakra) {
        super(nome, idade, aldeia, jutsus, chakra);
    }

    @Override
    public String usarJutsu() {
        String resposta = "Usando o Taijutsu";
        System.out.println(resposta);
        return resposta;
    }

    @Override
    public String desviar(String desviar) {
        String reposta = "Desviou para: " + desviar;
        System.out.println(reposta);
        return reposta;
    }
}
