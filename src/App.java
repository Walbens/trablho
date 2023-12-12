import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.print("Informe a quantidade de jogadores (entre 3 e 6): ");
        int numJogadores = scan.nextInt();

        if (numJogadores < 3 || numJogadores > 6) {
            System.out.println("Quantidade inválida de jogadores. O jogo suporta de 3 a 6 jogadores.");
            return;
        }

        List<Jogador> jogadores = new ArrayList<>();
        for (int i = 1; i <= numJogadores; i++) {
            System.out.print("Informe o nome do jogador " + i + ": ");
            String nomeJogador = scan.next();
            jogadores.add(new Jogador(nomeJogador));
        }

        Baralho baralho = new Baralho(109);
        Tabuleiro tabuleiro = new Tabuleiro();

        // Distribuir 12 cartas fechadas para cada jogador
        for (Jogador jogador : jogadores) {
            for (int i = 0; i < 12; i++) {
                Carta carta = baralho.retirarCarta();
                jogador.adicionarCarta(carta);
            }
        }

        // Realizar 12 rodadas
        for (int rodada = 1; rodada <= 12; rodada++) {
            System.out.println("\n********************  Rodada " + rodada);

            // Distribuir 5 cartas abertas no início de cada linha do tabuleiro
            for (int linha = 0; linha < 5; linha++) {
                
                    Carta carta = baralho.retirarCarta();
                    tabuleiro.adicionarCarta(linha, carta);
                    System.out.println("Carta adicionada à linha " + linha + ": " + carta.getNumero());
                
            }

            // Cada jogador escolhe uma carta e as cartas são reveladas
            for (Jogador jogador : jogadores) {
                jogador.imprimirMao(); 
            
                System.out.print(jogador.getNome() + ", escolha o número da carta que deseja jogar: ");
                int numeroCartaEscolhida = scan.nextInt();


                // Encontre a carta na mão do jogador com base no número escolhido
                Carta cartaSelecionada = null;
                for (Carta carta : jogador.getMao()) {
                    if (carta.getNumero() == numeroCartaEscolhida) {
                        cartaSelecionada = carta;
                        break;
                    }
                }
                
                // Adicione a lógica para lidar com a escolha da carta
                if (cartaSelecionada != null) {
                    System.out.println(jogador.getNome() + " escolheu a carta " + cartaSelecionada.getNumero());
                } else {
                    System.out.println("Número de carta inválido. Tente novamente.");
                }


                jogador.jogarCarta();
                
            }
            

            // Ordenar os jogadores com base nas cartas selecionadas
            jogadores.sort((j1, j2) -> Integer.compare(j1.jogarCarta().getNumero(), j2.jogarCarta().getNumero()));

            // Posicionar as cartas no tabuleiro
            for (Jogador jogador : jogadores) {
                Carta cartaSelecionada = jogador.jogarCarta();
                int linhaMenosCheia = tabuleiro.getLinhaMenosCheia();
                tabuleiro.adicionarCarta(linhaMenosCheia, cartaSelecionada);
            }

            // Imprimir o estado atual do tabuleiro
            tabuleiro.imprimirTabuleiro();
        }

        // Calcular pontos e declarar o vencedor
        int menorPontuacao = Integer.MAX_VALUE;
        List<Jogador> vencedores = new ArrayList<>();

        for (Jogador jogador : jogadores) {
            int pontuacao = jogador.getPontuacao();
            System.out.println(jogador.getNome() + " - Pontuação: " + pontuacao);

            if (pontuacao < menorPontuacao) {
                menorPontuacao = pontuacao;
                vencedores.clear();
                vencedores.add(jogador);
            } else if (pontuacao == menorPontuacao) {
                vencedores.add(jogador);
            }
        }

        // Imprimir pontuações, cartas coletadas e vencedor
        System.out.println("\nVencedor(es):");
        for (Jogador vencedor : vencedores) {
            System.out.println(vencedor.getNome());
        }
    }

}
