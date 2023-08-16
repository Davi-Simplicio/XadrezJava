import java.util.ArrayList;

public class Rei extends Peca {
    public Rei(String cor, Posicao posicao) {
        super(cor, posicao, cor.equals("Branco") ? "♚" : "♔");
    }

    private boolean primeiroMovimento;

    @Override
    public void possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        this.getPossiveisMovimentos().clear();

        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);

        for (Posicao posicao : tabuleiro.getPosicoes()) {
            int indice = tabuleiro.getPosicoes().indexOf(posicao);
            if (indice == posicaoNoTabuleiro + 8 ||
                    indice == posicaoNoTabuleiro + 9 ||
                    indice == posicaoNoTabuleiro + 7 ||
                    indice == posicaoNoTabuleiro + 1 ||
                    indice == posicaoNoTabuleiro - 1 ||
                    indice == posicaoNoTabuleiro - 8 ||
                    indice == posicaoNoTabuleiro - 9 ||
                    indice == posicaoNoTabuleiro - 7) {

                if (validaExtremidade(posicaoNoTabuleiro + 1)) {
                    if (!(indice == posicaoNoTabuleiro - 7 ||
                            indice == posicaoNoTabuleiro + 1 ||
                            indice == posicaoNoTabuleiro + 9)) {
                        verificaPeca(posicao);

                    }
                }
                //coluna A
                else if (validaExtremidade(posicaoNoTabuleiro)) {
                    if (!(indice == posicaoNoTabuleiro + 7 ||
                            indice == posicaoNoTabuleiro - 1 ||
                            indice == posicaoNoTabuleiro - 9)) {
                        verificaPeca(posicao);

                    }
                } else {
                    verificaPeca(posicao);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Rei " +
                "primeiroMovimento=" + primeiroMovimento +
                "" + super.toString();
    }
}
