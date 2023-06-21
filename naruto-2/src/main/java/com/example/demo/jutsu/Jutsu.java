package com.example.demo.jutsu;

import com.example.demo.model.Personagem;

public interface Jutsu {
    int executar(Personagem atacante, Personagem alvo);
}