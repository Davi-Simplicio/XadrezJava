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
        jogar();



    }
    private static boolean validarVitoria(Jogador adversario)
    {
        for (Peca peca : adversario.getPecas()) {
        if(peca instanceof Rei){
            return false;
        }
    }
        return true;
    }
    public static void jogar(){
        String tabuleiroCompleto ="";
        boolean vitoria = false;
        do {


            for (Jogador jogadorAtual:jogadores) {
                escolherPosicao(escolherPeca(jogadorAtual));
                jogadorAtual.moverPeca();
                if(validarVitoria(jogadorAtual)){
                    vitoria = true;
                }
            }
        }while (!vitoria);
    }

    public static Peca escolherPeca(Jogador jogador){
        System.out.println("Qual peça Você deseja usar?");
        System.out.println(tabuleiro.toString()+tabuleiro.tabuleiroComNumeros());
        int opcao = sc.nextInt();
        Peca pecaEscolhida = jogador.getPecas().get(opcao);
        return pecaEscolhida;
    }
    public static Posicao escolherPosicao(Peca peca){
        ArrayList<Posicao>possiveisJogadas = peca.possiveisMovimentos(tabuleiro);
        System.out.println("Para onde deseja andar");
        System.out.println(tabuleiro.possiveisjogadas(possiveisJogadas));
    }
}
