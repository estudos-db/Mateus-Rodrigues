package personagem;

import jutsu.Jutsu;
import interfaces.Ninja;

import java.util.HashMap;
import java.util.Map;

public class Personagem {

    private String nome;
    private Map<String, Jutsu> jutsus;
    private int chakra;
    private int vida;

    public Personagem(String nome) {
        this.nome = nome;
        this.jutsus = new HashMap<>();
        this.chakra = 100;
        this.vida = 100;
    }

    public String getNome() {
        return nome;
    }

    public int getChakra() {
        return chakra;
    }

    public int getVida() {
        return vida;
    }

    public void adicionarJutsu(String nome, Jutsu jutsu) {
        jutsus.put(nome, jutsu);
    }

    public void usarJutsu(Ninja alvo, String nomeJutsu) {
        if (chakra > 0) {
            Jutsu jutsu = jutsus.get(nomeJutsu);
            if (jutsu != null && chakra >= jutsu.getConsumoDeChakra()) {
                System.out.println(nome + " está usando o jutsu: " + nomeJutsu);
                chakra -= jutsu.getConsumoDeChakra();
                alvo.desviar(jutsu.getDano());
            } else {
                System.out.println("Jutsu não encontrado ou chakra insuficiente.");
            }
        } else {
            System.out.println(nome + " não tem chakra suficiente para usar jutsus.");
        }
    }

    public void desviar(int dano) {
        if (Math.random() < 0.5) {
            System.out.println(nome + " realizou um movimento ágil e desviou do ataque!");
        } else {
            vida -= dano;
            System.out.println(nome + " não conseguiu desviar do ataque e sofreu " + dano + " de dano.");
            System.out.println(nome + " possui " + vida + " de vida restante.");
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }
}
