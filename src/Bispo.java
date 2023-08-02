import java.util.ArrayList;

public class Bispo extends Peca{
    public Bispo(String cor,Posicao posicao) {
        super(cor,posicao, cor.equals("Branco") ? "♝" : "♗");
    }
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoDoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (int i = (validaExtremidade(posicaoDoTabuleiro) ? 64:posicaoDoTabuleiro+7); i < tabuleiro.getPosicoes().size(); i+=7) {
            if(verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos) || validaExtremidade(i)  ){
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro +1) ? -1:posicaoDoTabuleiro-7); i >= 0; i-=7) {
            if(verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos) || validaExtremidade(i+1)  ){
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro+1) ? 64:posicaoDoTabuleiro+9); i < tabuleiro.getPosicoes().size(); i+=9) {
            if(verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos) || validaExtremidade(i+1)  ){
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro) ? -1:posicaoDoTabuleiro-9); i >= 0; i-=9) {
            if(verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos) || validaExtremidade(i) ){
                break;
            }
        }


        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Bispo " + super.toString();
    }
}
