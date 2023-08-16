import java.util.ArrayList;
import java.util.Scanner;

public class
Executavel {
    public static ArrayList<Jogador> jogadores = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static Tabuleiro tabuleiro = new Tabuleiro();


    public static void main(String[] args) {
        Jogador p1 = new Jogador("Jorge", "Senh@123");
        Jogador p2 = new Jogador("Wilson", "wilson");
        jogadores.add(p1);
        jogadores.add(p2);

        p1.setCor("Branco", tabuleiro);
        p2.setCor("Preto", tabuleiro);
        System.out.println(tabuleiro);
        System.out.println(jogadores);
        jogar();


    }

    public static ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    private static boolean validarVitoria(Jogador adversario) {
        ArrayList<Peca> pecasParaXequeMate = new ArrayList<>();
        for (Peca peca : adversario.getPecas()) {
            if (peca.getPossiveisMovimentos().size()!=0){
              pecasParaXequeMate.add(peca);
            }
            if (peca instanceof Rei && pecasParaXequeMate.size()>0) {
                return false;
            }

        }
        return true;
    }

    public static void jogar() {
        Peca pecaEscolhida = null;
        Posicao posicaoEscolhida = null;
        Jogador jogadorAdversario = null;
        do {

            for (Jogador jogadorAtual : jogadores) {
                for (Jogador jogador : jogadores) {
                    if (jogadorAtual != jogador) {
                        jogadorAdversario = jogador;
                    }
                }
                simulacao(jogadorAtual, tabuleiro,jogadorAdversario);
                do {

                    pecaEscolhida = escolherPeca(jogadorAtual);
                    if (pecaEscolhida.getPossiveisMovimentos().size() == 0) {
                        System.out.println("Peça não pode se movimentar");
                    } else {
                        posicaoEscolhida = escolherPosicao(pecaEscolhida);
                    }


                } while (pecaEscolhida.getPossiveisMovimentos().size() == 0);
                if (posicaoEscolhida != null) {
                    jogadorAtual.moverPeca(pecaEscolhida, posicaoEscolhida, tabuleiro, jogadorAdversario);

                    if (pecaEscolhida instanceof Peao) {
                        if (tabuleiro.getPosicoes().indexOf(pecaEscolhida.getPosicao()) <= 7 || tabuleiro.getPosicoes().indexOf(pecaEscolhida.getPosicao()) >= 56) {
                            jogadorAtual.getPecas().remove(pecaEscolhida);
                            Peca peca = promoverPeca(pecaEscolhida.getPosicao(), pecaEscolhida.getCor());
                            jogadorAtual.getPecas().add(peca);
                            posicaoEscolhida.setPeca(peca);
                        }
                    }
                    if (validarVitoria(jogadorAdversario)) {
                        System.out.println("Parabens " + jogadorAtual + "Você Venceu\n" + "Infelismente " + jogadorAdversario + "Perdeu");
                        break;
                    }
                }
            }

        } while (!validarVitoria(jogadorAdversario));
    }

    public static Peca escolherPeca(Jogador jogador) {
        int opcao = 0;
        Peca peca;
        do {
            System.out.println("Qual peça Você deseja usar?");
            System.out.println(tabuleiro.toString() + "\n" + tabuleiro.tabuleiroComNumeros(jogador, tabuleiro));
            opcao = sc.nextInt();
            peca = tabuleiro.getPosicoes().get(opcao).getPeca();
            if (peca != null) {
                if (!peca.getCor().equals(jogador.getCor())) {
                    System.out.println("Esta peça não é sua");
                }
            } else {
                System.out.println("Esta posição não possui um peça");
            }
        } while (peca == null || !peca.getCor().equals(jogador.getCor()));
        return peca;
    }

    public static Posicao escolherPosicao(Peca peca) {
        ArrayList<Posicao> possiveisJogadas = peca.getPossiveisMovimentos();
        int opcao = 0;
        do {
            System.out.println("Para onde deseja andar");
            System.out.println(tabuleiro.possiveisjogadas(possiveisJogadas));
            opcao = sc.nextInt();
            if (!possiveisJogadas.contains(tabuleiro.getPosicoes().get(opcao))) {
                System.out.println("Local inválido");
            }
        } while (!possiveisJogadas.contains(tabuleiro.getPosicoes().get(opcao)));

        return tabuleiro.getPosicoes().get(opcao);
    }

    public static Peca promoverPeca(Posicao posicao, String cor) {
        Peca peca = null;
        System.out.println("""
                Promova este peão
                [1]Rainha
                [2]Bispo
                [3]Torre
                [4]Cavalo""");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                peca = new Rainha(cor, posicao);
                break;
            case 2:
                peca = new Bispo(cor, posicao);
                break;
            case 3:
                peca = new Torre(cor, posicao);
                break;
            case 4:
                peca = new Cavalo(cor, posicao);
                break;

        }
        return peca;
    }

    public static boolean verificaXeque(Jogador jogador) {
        for (Peca pecaAdversaria:jogador.getPecas()){
            pecaAdversaria.possiveisMovimentos(tabuleiro);
        }

        for (Peca peca : jogador.getPecas()) {
            for (Posicao posicaoPossivelMovimento : peca.getPossiveisMovimentos()) {
                if (posicaoPossivelMovimento.getPeca() instanceof Rei) {
                    System.out.println("Entrou em Xeque");
                    return true;
                }
            }
        }
        return false;
    }

    public static void simulacao(Jogador jogador, Tabuleiro tabuleiro,Jogador jogadorAdversario) {
        int posicaoAntiga;
        Peca pecaAntiga=null;
        ArrayList<Posicao> posicaosRemovidas = new ArrayList<>();

        for (Peca peca : jogador.getPecas()) {
            posicaoAntiga = tabuleiro.getPosicoes().indexOf(peca.getPosicao());
            peca.possiveisMovimentos(tabuleiro);
            for (Posicao posicao : peca.getPossiveisMovimentos()) {

                    pecaAntiga = posicao.getPeca();
                    peca.mover(tabuleiro, posicao);

                    if (verificaXeque(jogadorAdversario)) {
                        posicaosRemovidas.add(posicao);
                    }
                    peca.mover(tabuleiro, tabuleiro.getPosicoes().get(posicaoAntiga));
                    posicao.setPeca(pecaAntiga);
            }
            peca.getPossiveisMovimentos().removeAll(posicaosRemovidas);
        }
    }
}
