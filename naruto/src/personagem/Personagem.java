package personagem;
import java.util.ArrayList;
import java.util.List;

public class Personagem {

    private String nome;
    private int idade;
    private String aldeia;
    private List<String> jutsus = new ArrayList<>();
    private int chakra;

    public Personagem(String nome, int idade, String aldeia, List<String> jutsus, int chakra) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.jutsus = jutsus;
        this.chakra = chakra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAldeia() {
        return aldeia;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public List<String> getJutsus() {
        return jutsus;
    }

    public void setJutsus(List<String> jutsus) {
        this.jutsus = jutsus;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public List<String> adicionaJutsu(String nomeJutsu){

        jutsus.add(nomeJutsu);
        System.out.println("Você adicionou o jutsu: " + jutsus);

        return jutsus;
    }

    public int aumentaChakra(int valorChakra){

        chakra = this.getChakra() + valorChakra;
        System.out.println("Você aumentou o seu Chakra em: " + chakra);

        return chakra;
    }

    public void informacoesPersonagem( ){
        System.out.println("Informações personagem: " +
                            "\nNome: "+ getNome() +" " +
                            "\nIdade: "+ getIdade() +
                            "\nAldeia: "+ getAldeia() +
                            "\nJutsu: "+  getJutsus()
                            + "\nChakra: " + getChakra());
    }
}
