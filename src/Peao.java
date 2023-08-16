import java.util.ArrayList;

public class Peao extends Peca{
    private boolean primMov=true;

    public Peao(String cor,Posicao posicao) {
        super(cor,posicao,cor.equals("Branco") ? "♟" : "♙");
    }

    public void setPrimMov( ) {
        this.primMov = false;
    }

    @Override
    public boolean mover(Tabuleiro tabuleiro, Posicao posicao){

                //atribuindo a peça para a nova posição no tabuleiro
                posicao.setPeca(this);
                //removendo a peça da posição anterior no tabuleiro
                this.getPosicao().setPeca(null);
                //trocando a posição atual da peça no tabuleiro
                this.setPosicao(posicao);
                this.primMov = false;
                return true;
    }

    @Override
    public void possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        this.getPossiveisMovimentos().clear();
        ArrayList<Posicao> posicoesTabuleiro= tabuleiro.getPosicoes();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        Posicao posicao = posicoesTabuleiro.get(posicaoNoTabuleiro);
        if(this.getCor().equals("Preto")) {
            if (tabuleiro.getPosicoes().indexOf(posicoesTabuleiro.get(posicaoNoTabuleiro)) > 7 ||
                    tabuleiro.getPosicoes().indexOf(posicoesTabuleiro.get(posicaoNoTabuleiro))<56){
                if (tabuleiro.getPosicoes().indexOf(posicoesTabuleiro.get(posicaoNoTabuleiro)) < 56) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                        getPossiveisMovimentos().add(posicoesTabuleiro.get(posicaoNoTabuleiro + 8));
                        if (this.primMov) {
                            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                                this.getPossiveisMovimentos().add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));
                            }

                        }
                    }
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca() != null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca().getCor().equals("Branco")) {
                            if (!validaExtremidade(posicaoNoTabuleiro + 1)) {
                                this.getPossiveisMovimentos().add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));
                            }
                        }
                    }
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca() != null) {
                        if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco")) {
                            if (!validaExtremidade(posicaoNoTabuleiro)) {
                                this.getPossiveisMovimentos().add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));
                            }
                        }
                    }

                }
        }
        }else{
            if(tabuleiro.getPosicoes().indexOf(posicoesTabuleiro.get(posicaoNoTabuleiro))>7 ){

                if (posicoesTabuleiro.get(posicaoNoTabuleiro-8).getPeca()==null){
                    this.getPossiveisMovimentos().add(posicoesTabuleiro.get(posicaoNoTabuleiro-8));
                }
                if(this.primMov){
                    if(posicoesTabuleiro.get(posicaoNoTabuleiro-16).getPeca()==null){
                        this.getPossiveisMovimentos().add(posicoesTabuleiro.get(posicaoNoTabuleiro-16));
                    }

                }
            }
            if(tabuleiro.getPosicoes().indexOf(posicoesTabuleiro.get(posicaoNoTabuleiro))>7 ) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca() != null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca().getCor().equals("Preto")) {
                        if (!validaExtremidade(posicaoNoTabuleiro)) {
                            this.getPossiveisMovimentos().add(posicoesTabuleiro.get(posicaoNoTabuleiro - 9));
                        }
                    }
                }
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca() != null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto")) {
                        if (!validaExtremidade(posicaoNoTabuleiro + 1)) {
                            this.getPossiveisMovimentos().add(posicoesTabuleiro.get(posicaoNoTabuleiro - 7));

                        }
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Peao " +
                "primMov=" + primMov +
                " " + super.toString();
    }

}
