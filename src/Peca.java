import javax.xml.namespace.QName;
import java.util.ArrayList;

public abstract class  Peca {
    private final String cor;
    private Posicao posicao;
    private final String icone;
    private final ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

    public Peca(String cor,Posicao posicao, String icone) {
        this.cor = cor;
        this.posicao = posicao;
        this.icone = icone;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public String getCor() { return cor; }

    public String getIcone() {
        return icone;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public ArrayList<Posicao> getPossiveisMovimentos(){
        return this.possiveisMovimentos;
    }

    public boolean mover(Tabuleiro tabuleiro, Posicao posicao){

            //atribuindo a peça para a nova posição no tabuleiro
            posicao.setPeca(this);
            //removendo a peça da posição anterior no tabuleiro
            this.posicao.setPeca(null);
            //trocando a posição atual da peça no tabuleiro
            this.posicao = posicao;
            return true;

    }
    public abstract void possiveisMovimentos(Tabuleiro tabuleiro);

    public boolean verificaPeca(Posicao posicao){
        if(posicao.getPeca() == null){
            this.possiveisMovimentos.add(posicao);
            return false;
        }else{

            if(!posicao.getPeca().getCor().equals(this.getCor())){
                this.possiveisMovimentos.add(posicao);
            }
            return true;
        }
    }

    public boolean validaExtremidade( int posicaoNoTabuleiro){
        return posicaoNoTabuleiro % 8 ==0;
    }

//        public abstract char icone();

    @Override
    public String toString() {
        return "Peca{" +
                "cor='" + cor + '\''+
                icone +
                '}';
    }


}
