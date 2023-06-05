package ninjas;

import interfaces.Ninja;
import personagem.Personagem;

public class NinjaDeNinjutsu extends Personagem implements Ninja {


    public NinjaDeNinjutsu(String nome) {
        super(nome);
    }

    @Override
    public void usarJutsu(Ninja alvo) {
        super.usarJutsu(alvo, "Jutsu de Fogo");
    }

    @Override
    public void desviar(int dano) {
        super.desviar(dano);
    }
}
