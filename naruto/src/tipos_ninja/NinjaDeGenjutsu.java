package tipos_ninja;

import interfaces.NinjaInterface;
import personagem.Personagem;

import java.util.List;


public class NinjaDeGenjutsu extends Personagem implements NinjaInterface {


    public NinjaDeGenjutsu(String nome, int idade, String aldeia, List<String> jutsus, int chakra) {
        super(nome, idade, aldeia, jutsus, chakra);
    }

    @Override
    public String usarJutsu() {
        String resposta = "Usando o Genjutsu";
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
