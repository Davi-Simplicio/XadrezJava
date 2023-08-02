import java.util.ArrayList;

public class Torre extends Peca{
    public Torre(String cor,Posicao posicao) {
        super(cor,posicao,cor.equals("Branco") ? "♜" : "♖");
    }
    private boolean primMov;
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoDoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (int i = posicaoDoTabuleiro+8; i < tabuleiro.getPosicoes().size(); i+=8) {
            if(verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)){
                break;
            }
        }
        for (int i = posicaoDoTabuleiro-8; i < 0; i-=8) {
            if(verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos)){
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro+1) ? 64:posicaoDoTabuleiro+1); i < tabuleiro.getPosicoes().size(); i++) {
            if(verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos) || validaExtremidade(i+1)){
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro) ? -1:posicaoDoTabuleiro-1); i < 0; i--) {
            if(verificaPeca(tabuleiro.getPosicoes().get(i),possiveisMovimentos) || validaExtremidade(i+1) ){
                break;
            }
        }


        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Torre " +
                "primMov=" + primMov +
                "" + super.toString();
    }
}
