import java.util.ArrayList;

public class Tabuleiro {
    private  ArrayList<Posicao> posicoes = new ArrayList<>();

    public Tabuleiro() {
        for (int i = 0; i < 64 ; i++) {
            posicoes.add(new Posicao());
            if(i >= 8 && i<=15){
                posicoes.get(i).setPeca(new Peao("Preto",posicoes.get(i)));
            }
            if(i >= 48 && i<=55){
                posicoes.get(i).setPeca(new Peao("Branco",posicoes.get(i)));
            }
            if(i == 0 || i ==7){
                posicoes.get(i).setPeca(new Torre("Preto",posicoes.get(i)));
            }
            if(i == 56 || i ==63){
                posicoes.get(i).setPeca(new Torre("Branco",posicoes.get(i)));
            }
            if(i == 1 || i ==6){
                posicoes.get(i).setPeca(new Cavalo("Preto",posicoes.get(i)));
            }
            if(i == 57 || i ==62){
                posicoes.get(i).setPeca(new Cavalo("Branco",posicoes.get(i)));
            }
            if(i == 2 || i ==5){
                posicoes.get(i).setPeca(new Bispo("Preto",posicoes.get(i)));
            }
            if(i == 58 || i ==61){
                posicoes.get(i).setPeca(new Bispo("Branco",posicoes.get(i)));
            }
            if(i == 4){
                posicoes.get(i).setPeca(new Rei("Preto",posicoes.get(i)));
            }
            if(i == 60){
                posicoes.get(i).setPeca(new Rei("Branco",posicoes.get(i)));
            }
            if(i == 3){
                posicoes.get(i).setPeca(new Rainha("Preto",posicoes.get(i)));
            }
            if(i == 59){
                posicoes.get(i).setPeca(new Rainha("Branco",posicoes.get(i)));
            }
        }


    }

    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    public void removerPeca(Posicao posicao){

    }
    public String possiveisjogadas(ArrayList<Posicao>possiveisMovimentos){
        String tabuleiroPossiveisJogadas ="";

        for (Posicao posicao : posicoes){
            int i = posicoes.indexOf(posicao);
            if (posicao.getPeca() == null && !possiveisMovimentos.contains(posicao)) {
                tabuleiroPossiveisJogadas += "[ ]";
            }else if(possiveisMovimentos.contains(posicao)){
                tabuleiroPossiveisJogadas += "["+ i +"]";
            }else{
                tabuleiroPossiveisJogadas += "[" + posicao.getPeca().getIcone() + "]";
            }
            if ((posicoes.indexOf(posicao)+1)%8==0){
                tabuleiroPossiveisJogadas += "\n";
            }
        }
        return tabuleiroPossiveisJogadas;
    }

    public String tabuleiroComNumeros(Jogador jogador, Tabuleiro tabuleiro) {
        String tabuleiroComNumerosPronto = "";
        for (Posicao posicao : posicoes) {
            if (posicao.getPeca()!=null){
                posicao.getPeca().possiveisMovimentos(tabuleiro);
            }
            if (posicao.getPeca() == null) {
                tabuleiroComNumerosPronto += "[  ]";
            } else {
                if (jogador.getPecas().contains(posicao.getPeca()) && posicao.getPeca().getPossiveisMovimentos().size()!=0) {
                    if (posicoes.indexOf(posicao) < 10) {
                        tabuleiroComNumerosPronto += "[" + 0 + posicoes.indexOf(posicao) + "]";
                    } else {
                        tabuleiroComNumerosPronto += "[" + posicoes.indexOf(posicao) + "]";
                    }
                }else{
                    tabuleiroComNumerosPronto += "[ " + posicao.getPeca().getIcone() + "]";
                }
            }
            if ((posicoes.indexOf(posicao)+1)%8==0){
                tabuleiroComNumerosPronto += "\n";
            }
        }
        return tabuleiroComNumerosPronto;
    }
    @Override
    public String toString() {
        String tabuleiroPronto = "";
        for (Posicao posicao : posicoes) {
            if (posicao.getPeca() == null) {
                tabuleiroPronto += "[ ]";
            } else {
                tabuleiroPronto += "[" + posicao.getPeca().getIcone() + "]";
            }
            if ((posicoes.indexOf(posicao)+1)%8==0){
                tabuleiroPronto += "\n";
            }
        }
        return tabuleiroPronto;
    }
}
