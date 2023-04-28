import personagem.Personagem;
import tipos_ninja.NinjaDeGenjutsu;

public class Main {
    public static void main(String[] args) {

        Personagem personagem = new NinjaDeGenjutsu();
        personagem.setNome("Mateus");

        System.out.println(personagem.getNome());
    }
}