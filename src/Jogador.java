import java.util.ArrayList;

public class Jogador {
    private String nome="";
    private String cor;
    private String senha;
    private double pontos;
    private ArrayList<Peca> pecas;

    public Jogador(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        this.pecas = new ArrayList<>();
    }
    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public void setCor(String cor, Tabuleiro tabuleiro) {
        this.cor = cor;

        for (Posicao posicao: tabuleiro.getPosicoes()) {
            if(posicao.getPeca() !=null && posicao.getPeca().getCor().equals(this.cor)  ){
                this.pecas.add(posicao.getPeca());
            }
        }
    }


    public boolean moverPeca(Peca peca, Posicao posicao,Tabuleiro tabuleiro, Jogador adversario){
        Peca pecaAdversaria = posicao.getPeca();
        boolean valida = peca.mover(tabuleiro,posicao);
        if(pecaAdversaria!=null && valida){
            adversario.pecas.remove(pecaAdversaria);
        }
        return valida;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", senha='" + senha + '\'' +
                ", pontos=" + pontos +
                ", pecas=" + pecas +
                '}';
    }

    public void desistir(){

    }
    public boolean proporEmpate(Jogador jogador){
        return true;
    }

}