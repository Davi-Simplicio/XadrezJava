import java.util.ArrayList;
import java.util.Scanner;

public class Executavel {
    public static ArrayList<Jogador>jogadores = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static Tabuleiro tabuleiro = new Tabuleiro();


    public static void main(String[] args) {
        Jogador p1 = new Jogador("Jorge","Senh@123");
        Jogador p2 = new Jogador("Wilson","wilson");
        jogadores.add(p1);
        jogadores.add(p2);

        p1.setCor("Branco",tabuleiro);
        p2.setCor("Preto",tabuleiro);
        System.out.println(tabuleiro);
        System.out.println(jogadores);
        jogar();



    }
    private static boolean validarVitoria(Jogador adversario)
    {
        for(Posicao posicao : tabuleiro.getPosicoes()){
            if(posicao.getPeca() instanceof Rei &&
            adversario.getPecas().contains(posicao.getPeca())){
                return false;
            }
        }
        return true;
    }
    public static void jogar(){
        Peca pecaEscolhida = null;
        Posicao posicaoEscolhida = null;
        Jogador jogadorAdversario = null;
        do {


            for (Jogador jogadorAtual:jogadores) {
                for (Jogador jogador:jogadores) {
                    if (jogadorAtual!=jogador){
                        jogadorAdversario = jogador;
                        System.out.println(jogadorAdversario);
                    }
                }
                do {
                    pecaEscolhida = escolherPeca(jogadorAtual);
                    posicaoEscolhida = escolherPosicao(pecaEscolhida);
                    jogadorAtual.moverPeca(pecaEscolhida,posicaoEscolhida,tabuleiro,jogadorAtual);
                    if (validarVitoria(jogadorAdversario)){
                        System.out.println("Parabens "+jogadorAtual+"Você Venceu\n"+"Infelismente "+jogadorAdversario+"Perdeu");
                        break;
                    }
                    if (pecaEscolhida.possiveisMovimentos(tabuleiro).size()==0){
                        System.out.println("Peça não pode se movimentar");
                    }
                }while (pecaEscolhida.possiveisMovimentos(tabuleiro).size()==0);

            }

        }while (!validarVitoria(jogadorAdversario));
    }

    public static Peca escolherPeca(Jogador jogador){
        System.out.println("Qual peça Você deseja usar?");
        System.out.println(tabuleiro.toString()+"\n"+tabuleiro.tabuleiroComNumeros(jogador));
        int opcao = sc.nextInt();
        System.out.println(tabuleiro.getPosicoes().get(opcao).getPeca());
        return tabuleiro.getPosicoes().get(opcao).getPeca();
    }
    public static Posicao escolherPosicao(Peca peca){
        ArrayList<Posicao>possiveisJogadas = peca.possiveisMovimentos(tabuleiro);

            System.out.println("Para onde deseja andar");
            System.out.println(tabuleiro.possiveisjogadas(possiveisJogadas));
            int opcao = sc.nextInt();
            return tabuleiro.getPosicoes().get(opcao);

    }
}
