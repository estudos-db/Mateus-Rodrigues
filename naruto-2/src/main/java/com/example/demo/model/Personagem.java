package com.example.demo.model;


import com.example.demo.service.Desviador;
import com.example.demo.jutsu.Jutsu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Personagem {

    private String nome;
    private int chakra;
    private int vida;
    private Map<String, Jutsu> jutsus;
    private Desviador desviador;



    public Personagem(String nome, Desviador desviador) {
        this.nome = nome;
        this.chakra = 100;
        this.vida = 100;
        this.jutsus = new HashMap<>();
        this.desviador = desviador;
    }

    public int getChakra() {
        return chakra;
    }

    public Map<String, Jutsu> getJutsus() {
        return jutsus;
    }

    public int getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public void adicionarJutsu(String nomeJutsu, Jutsu jutsu) {
        jutsus.put(nomeJutsu, jutsu);
    }

    public void usarJutsu(String nomeJutsu, Personagem alvo) {
        if (jutsus.containsKey(nomeJutsu)) {
            Jutsu jutsu = jutsus.get(nomeJutsu);
            if (chakra >= 10) {
                chakra -= 10;
                int dano = jutsu.executar(this, alvo);
                alvo.receberDano(dano);
            } else {
                System.out.println("Não há chakra suficiente para usar o jutsu.");
            }
        } else {
            System.out.println("O jutsu " + nomeJutsu + " não está disponível para " + nome + ".");
        }
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida <= 0) {
            vida = 0;
            System.out.println(nome + " foi derrotado!");
        } else {
            System.out.println(nome + " recebeu " + dano + " de dano!");
            System.out.println("Vida restante: " + vida);
        }
    }

    public boolean desviar() {
        return desviador.desviar();
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", chakra=" + chakra +
                ", vida=" + vida +
                ", jutsus=" + jutsus +
                ", desviador=" + desviador +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personagem that = (Personagem) o;
        return chakra == that.chakra && vida == that.vida && nome.equals(that.nome) && jutsus.equals(that.jutsus) && desviador.equals(that.desviador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, chakra, vida, jutsus, desviador);
    }
}
