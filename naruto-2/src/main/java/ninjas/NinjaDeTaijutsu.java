package ninjas;

import interfaces.Ninja;
import personagem.Personagem;


public class NinjaDeTaijutsu extends Personagem implements Ninja {

    public NinjaDeTaijutsu(String nome) {
        super(nome);
    }

    @Override
    public void usarJutsu(Ninja alvo) {
        super.usarJutsu(alvo, "Golpe de Taijutsu");
    }

    @Override
    public void desviar(int dano) {
        super.desviar(dano);
    }
}
