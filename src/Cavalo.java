import java.util.ArrayList;

public class Cavalo extends Peca{
    public Cavalo(String cor,Posicao posicao) {
        super(cor,posicao,cor.equals("Branco") ? "♞" : "♘");
    }
    @Override
    public void possiveisMovimentos(Tabuleiro tabuleiro) {

        Posicao posicaoAtual = this.getPosicao();
        this.getPossiveisMovimentos().clear();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);


        for (Posicao posicao:tabuleiro.getPosicoes()) {
            int indice = tabuleiro.getPosicoes().indexOf(posicao);
                if(indice==posicaoNoTabuleiro-17 ||
                    indice==posicaoNoTabuleiro -15 ||
                    indice==posicaoNoTabuleiro -10 ||
                    indice==posicaoNoTabuleiro -6 ||
                    indice==posicaoNoTabuleiro +17 ||
                    indice==posicaoNoTabuleiro +15 ||
                    indice==posicaoNoTabuleiro +10 ||
                    indice==posicaoNoTabuleiro +6){
                    //coluna H
                if (validaExtremidade(posicaoNoTabuleiro+1)) {
                    if (!(indice == posicaoNoTabuleiro -15 ||
                            indice ==posicaoNoTabuleiro - 6||
                            indice==posicaoNoTabuleiro +10||
                            indice ==posicaoNoTabuleiro+17)){

                        verificaPeca(posicao);

                    }
                }
                     //coluna A
                else if (validaExtremidade(posicaoNoTabuleiro) ){
                    if (!(indice == posicaoNoTabuleiro +15 ||
                            indice ==posicaoNoTabuleiro +6||
                            indice==posicaoNoTabuleiro -10||
                            indice ==posicaoNoTabuleiro-17)){


                        verificaPeca(posicao);
                    }
                }//coluna B
                else if (validaExtremidade(posicaoNoTabuleiro-1)  ){
                        if (!(indice ==posicaoNoTabuleiro +6 ||
                                indice==posicaoNoTabuleiro -10)){


                            verificaPeca(posicao);
                        }
                    }
                //coluna G
                else if (validaExtremidade(posicaoNoTabuleiro+2)  ){
                    if (!(indice ==posicaoNoTabuleiro -6 ||
                            indice==posicaoNoTabuleiro +10)){

                        verificaPeca(posicao);

                    }
                }

                //não é canto
                else{
                    verificaPeca(posicao);
                }

            }
        }
    }

    @Override
    public String toString() {
        return "Cavalo " + super.toString();
    }
}
