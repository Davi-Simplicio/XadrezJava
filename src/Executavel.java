import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class
Executavel {
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
                    pecaEscolhida.possiveisMovimentos(tabuleiro);
                    if (pecaEscolhida.getPossiveisMovimentos().size()==0){
                        System.out.println("Peça não pode se movimentar");
                    }else{
                        posicaoEscolhida = escolherPosicao(pecaEscolhida);
                    }
                    if (validarVitoria(jogadorAdversario)){
                        System.out.println("Parabens "+jogadorAtual+"Você Venceu\n"+"Infelismente "+jogadorAdversario+"Perdeu");
                        break;
                    }


                }while (pecaEscolhida.getPossiveisMovimentos().size()==0);
                jogadorAtual.moverPeca(pecaEscolhida,posicaoEscolhida,tabuleiro,jogadorAdversario);
                System.out.println(posicaoEscolhida);
                pecaEscolhida.mover(tabuleiro,posicaoEscolhida);
                if (pecaEscolhida instanceof Peao){
                    if (tabuleiro.getPosicoes().indexOf(pecaEscolhida.getPosicao())<=7 || tabuleiro.getPosicoes().indexOf(pecaEscolhida.getPosicao())>=56){
                        jogadorAtual.getPecas().remove(pecaEscolhida);
                        Peca peca = promoverPeca(pecaEscolhida.getPosicao(),pecaEscolhida.getCor());
                        jogadorAtual.getPecas().add(peca);
                        posicaoEscolhida.setPeca(peca);

                        System.out.println(peca);
                    }
                }
            }

        }while (!validarVitoria(jogadorAdversario));
    }

    public static Peca escolherPeca(Jogador jogador){
        int opcao = 0;
        Peca peca;
            do {
                System.out.println("Qual peça Você deseja usar?");
                System.out.println(tabuleiro.toString() + "\n" + tabuleiro.tabuleiroComNumeros(jogador));
                opcao = sc.nextInt();
                peca = tabuleiro.getPosicoes().get(opcao).getPeca() ;
                if(peca != null) {
                    if (!peca.getCor().equals(jogador.getCor())) {
                        System.out.println("Esta peça não é sua");
                    }
                }else {
                    System.out.println("Esta posição não possui um peça");
                }
        }while (peca==null || !peca.getCor().equals(jogador.getCor()));
            return peca;
    }
    public static Posicao escolherPosicao(Peca peca){
        ArrayList<Posicao>possiveisJogadas = peca.getPossiveisMovimentos();
        int opcao=0;
            do {
                System.out.println("Para onde deseja andar");
                System.out.println(tabuleiro.possiveisjogadas(possiveisJogadas));
                opcao = sc.nextInt();
                if (!possiveisJogadas.contains(tabuleiro.getPosicoes().get(opcao))){
                    System.out.println("Local inválido");
                }
            }while (!possiveisJogadas.contains(tabuleiro.getPosicoes().get(opcao)));

            return tabuleiro.getPosicoes().get(opcao);
    }
    public static Peca promoverPeca(Posicao posicao,String cor){
        Peca peca=null;
        System.out.println("""
                Promova este peão
                [1]Rainha
                [2]Bispo
                [3]Torre
                [4]Cavalo""");
        int opcao = sc.nextInt();
        switch (opcao){
            case 1:
                peca = new Rainha(cor,posicao);
                break;
            case 2:
                peca = new Bispo(cor,posicao);
                break;
            case 3:
                peca = new Torre(cor,posicao);
                break;
            case 4:
                peca = new Cavalo(cor,posicao);
                break;

        }
        return peca;
    }
}
