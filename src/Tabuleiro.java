import java.util.ArrayList;
import java.util.List;

class Tabuleiro {
    private List<List<Carta>> linhas;

    public Tabuleiro() {
        linhas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            linhas.add(new ArrayList<>());
        }
    }


    public int getLinhaMenosCheia() {
        int linhaMenosCheia = 0;
        int menorTamanho = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            int tamanhoAtual = linhas.get(i).size();
            if (tamanhoAtual < menorTamanho) {
                menorTamanho = tamanhoAtual;
                linhaMenosCheia = i;
            }
        }

        return linhaMenosCheia;
    }


    public void adicionarCarta(int linha, Carta carta) {
        linhas.get(linha).add(carta);
    }


    public void imprimirTabuleiro() {
        for (List<Carta> linha : linhas) {
            for (Carta carta : linha) {
                System.out.print(carta.getNumero() + "\t");
            }

            //preencher com zero se a linha não tiver 5 cartas
            for(int i=linha.size(); i<5;i++){
                System.out.println("0\t");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void coletarCartas(int linha) {
        // Coletar todas as cartas da linha especificada
        List<Carta> cartasColetadas = new ArrayList<>(linhas.get(linha));
        linhas.get(linha).clear();

        // Adicionar cartas coletadas à pontuação do jogador
        for (Carta carta : cartasColetadas) {
            int pontos = 1;
            if (carta.getNumero() % 10 == 5) {
                pontos++;
            }
            if (carta.getNumero() % 10 == 0) {
                pontos += 2;
            }
            if (temDoisDigitosRepetidos(carta.getNumero())) {
                pontos += 4;
            }

        }
    }

    private boolean temDoisDigitosRepetidos(int numero) {
        String numeroStr = String.valueOf(numero);
        return numeroStr.length() == 2 && numeroStr.charAt(0) == numeroStr.charAt(1);
    }
}