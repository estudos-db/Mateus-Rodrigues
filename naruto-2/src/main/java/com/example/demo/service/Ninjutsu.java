package com.example.demo.service;

import com.example.demo.jutsu.Jutsu;
import com.example.demo.model.Personagem;

public class Ninjutsu implements Jutsu {

    private int dano;

    public Ninjutsu(int dano) {
        this.dano = dano;
    }

    @Override
    public int executar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " está usando um Ninjutsu!");
        return dano;
    }

    @Override
    public String toString() {
        return "Ninjutsu{" +
                "dano=" + dano +
                '}';
    }
}
