import java.util.ArrayList;

public class Rainha extends Peca{
    public Rainha(String cor,Posicao posicao) {
        super(cor,posicao,cor.equals("Branco") ? "♛" : "♕");
    }
    @Override
    public void possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoDoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);

        //andar diagonal
        for (int i = (validaExtremidade(posicaoDoTabuleiro) ? 64:posicaoDoTabuleiro+7); i < tabuleiro.getPosicoes().size(); i+=7) {
            if (i>0 && i<64) {
                if (verificaPeca(tabuleiro.getPosicoes().get(i)) || validaExtremidade(i)) {
                    break;
                }
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro +1) ? -1:posicaoDoTabuleiro-7); i >= 0; i-=7) {
            if (i>0 && i<64) {
                if (verificaPeca(tabuleiro.getPosicoes().get(i)) || validaExtremidade(i + 1)) {
                    break;
                }
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro+1) ? 64:posicaoDoTabuleiro+9); i < tabuleiro.getPosicoes().size(); i+=9) {
            if (i>0 && i<64) {
                if (verificaPeca(tabuleiro.getPosicoes().get(i)) || validaExtremidade(i + 1)) {
                    break;
                }
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro) ? -1:posicaoDoTabuleiro-9); i >= 0; i-=9) {
            if (i>0 && i<64) {
                if (verificaPeca(tabuleiro.getPosicoes().get(i)) || validaExtremidade(i)) {
                    break;
                }
            }
        }

        //andar em cruz
        for (int i = posicaoDoTabuleiro+8; i < tabuleiro.getPosicoes().size(); i+=8) {
            if (i>0 && i<64) {
                if (verificaPeca(tabuleiro.getPosicoes().get(i))) {
                    break;
                }
            }
        }
        for (int i = posicaoDoTabuleiro-8; i < 0; i-=8) {
            if (i>0 && i<64) {
                if (verificaPeca(tabuleiro.getPosicoes().get(i))) {
                    break;
                }
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro+1) ? 64:posicaoDoTabuleiro+1); i < tabuleiro.getPosicoes().size(); i++) {
            if (i>0 && i<64) {
                if (verificaPeca(tabuleiro.getPosicoes().get(i)) || validaExtremidade(i + 1)) {
                    break;
                }
            }
        }
        for (int i = (validaExtremidade(posicaoDoTabuleiro) ? -1:posicaoDoTabuleiro-1); i < 0; i--) {
            if (i>0 && i<64) {
                if (verificaPeca(tabuleiro.getPosicoes().get(i)) || validaExtremidade(i + 1)) {
                    break;
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Rainha "+ super.toString();
    }
}
