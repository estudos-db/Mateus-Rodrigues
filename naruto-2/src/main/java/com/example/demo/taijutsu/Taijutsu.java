package com.example.demo.taijutsu;

import com.example.demo.jutsu.Jutsu;
import com.example.demo.model.Personagem;

public class Taijutsu implements Jutsu {

    private int dano;

    public Taijutsu(int dano) {
        this.dano = dano;
    }

    @Override
    public int executar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " esta usando Taijutsu!");
        return dano;
    }
}
