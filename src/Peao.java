import java.util.ArrayList;

public class Peao extends Peca{
    private boolean primMov;

    public Peao(String cor,Posicao posicao) {
        super(cor,posicao,cor.equals("Branco") ? "♟" : "♙");
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao>possiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        ArrayList<Posicao> posicoesTabuleiro= tabuleiro.getPosicoes();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        Posicao posicao = posicoesTabuleiro.get(posicaoNoTabuleiro);
        if(this.getCor().equals("Preto")){
            if(posicoesTabuleiro.get(posicaoNoTabuleiro+8).getPeca()==null){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro+8));
                if(this.primMov){
                    if(posicoesTabuleiro.get(posicaoNoTabuleiro+16).getPeca()==null){
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro+16));
                    }

                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro+9).getPeca()!=null) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));
                }
            }if (posicoesTabuleiro.get(posicaoNoTabuleiro+7).getPeca()!=null) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro)) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));
                }
            }
        } else{
            if(posicoesTabuleiro.get(posicaoNoTabuleiro-8).getPeca()==null){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro-8));
                if(this.primMov){
                    if(posicoesTabuleiro.get(posicaoNoTabuleiro-16).getPeca()==null){
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro-16));
                    }

                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro-9).getPeca()!=null){
                if(posicoesTabuleiro.get(posicaoNoTabuleiro-9).getPeca().getCor().equals("Preto")
                        && !validaExtremidade(posicaoNoTabuleiro)){
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro-9));
                }
            } if (posicoesTabuleiro.get(posicaoNoTabuleiro-9).getPeca()!=null) {
                if(posicoesTabuleiro.get(posicaoNoTabuleiro-7).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro+1)){
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro-7));
                }
            }
        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Peao " +
                "primMov=" + primMov +
                " " + super.toString();
    }
}
