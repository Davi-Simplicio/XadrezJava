import java.util.ArrayList;

public class Cavalo extends Peca{
    public Cavalo(String cor,Posicao posicao) {
        super(cor,posicao,cor.equals("Branco") ? "♞" : "♘");
    }
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);


        for (Posicao posicao:tabuleiro.getPosicoes()) {
            int indice = tabuleiro.getPosicoes().indexOf(posicao);
                if(indice==posicaoNoTabuleiro-17 ||
                    indice==posicaoNoTabuleiro -15 ||
                    indice==posicaoNoTabuleiro -10 ||
                    indice==posicaoNoTabuleiro -6 ||
                    indice==posicaoNoTabuleiro+17 ||
                    indice==posicaoNoTabuleiro +15 ||
                    indice==posicaoNoTabuleiro +10 ||
                    indice==posicaoNoTabuleiro +6){
                    //coluna H
                if (validaExtremidade(posicaoNoTabuleiro+1)) {
                    if (!(indice == posicaoNoTabuleiro -15 ||
                            indice ==posicaoNoTabuleiro - 6||
                            indice==posicaoNoTabuleiro +10||
                            indice ==posicaoNoTabuleiro+17)){
                        verificaPeca(posicao,possiveisMovimentos);

                    }
                }
                     //coluna A
                else if (validaExtremidade(posicaoNoTabuleiro) ){
                    if (!(indice == posicaoNoTabuleiro +15 ||
                            indice ==posicaoNoTabuleiro +6||
                            indice==posicaoNoTabuleiro -10||
                            indice ==posicaoNoTabuleiro-17)){
                        verificaPeca(posicao,possiveisMovimentos);
                    }
                }//coluna B
                else if (validaExtremidade(posicaoNoTabuleiro-1)  ){
                        if (!(indice ==posicaoNoTabuleiro +6 ||
                                indice==posicaoNoTabuleiro -10)){
                            verificaPeca(posicao,possiveisMovimentos);
                        }
                    }
                //coluna G
                else if (validaExtremidade(posicaoNoTabuleiro+2)  ){
                    if (!(indice ==posicaoNoTabuleiro -15 ||
                            indice==posicaoNoTabuleiro +17)){
                        verificaPeca(posicao,possiveisMovimentos);

                    }
                }

                //não é canto
                else{
                    possiveisMovimentos.add(posicao);
                }

            }
        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Cavalo " + super.toString();
    }
}
