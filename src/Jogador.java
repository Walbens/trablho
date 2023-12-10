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
    public void imprimirMao() {
        System.out.println("Mão de " + nome + ":" );
        for (Carta carta : mao) {
            System.out.print(carta.getNumero()+" ");
        }
        System.out.println("\n"); // Adiciona uma linha em branco para melhor legibilidade
    }
    public Carta jogarCarta() {
        if (!mao.isEmpty()) {
            Carta cartaJogada = mao.remove(0);
            System.out.println(nome + " jogou a carta " + cartaJogada.getNumero());

            // Adicione esta linha para imprimir a mão após a remoção
            System.out.println("Mão de " + nome + " após jogar a carta:");
            for (Carta carta : mao) {
                System.out.print(carta.getNumero()+" ");   
            }
            System.out.println("\n");
            return cartaJogada;
        } else {
            System.out.println("A mão do jogador " + nome + " está vazia. Não há carta para jogar.");
            return null;
        }
    }


    public void adicionarPontos(int pontos) {
        pontuacao += pontos;
    }

    public Carta selecionarCarta() {
        if (!mao.isEmpty()) {
            return mao.get(0);
        } else {
            System.out.println("A mão do jogador está vazia.");
            return null; 
        }
    }    
}