import java.util.ArrayList;
import java.util.List;

class Jogador {
    private String nome;
    private List<Carta> mao;
    private int pontos;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void adicionarCarta(Carta carta) {
        mao.add(carta);
    }
    public int getPontuacao() {
        return pontuacao;
    }

    public void adicionarPontos(int pontos) {
        pontuacao += pontos;
    }

    public Carta selecionarCarta() {
        // Implementar lógica para o jogador escolher uma carta
        return mao.get(0); // Exemplo: escolhe a primeira carta por enquanto
    }

    public Carta jogarCarta() {
        return null;
    }
}