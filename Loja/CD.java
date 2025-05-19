public class CD extends Produto {
    String cantorOuBanda;
    int numTrilhas;
    String gravadora;

    public CD (int codBarraIn, String nomeIn, int anoIn, int quantidadeIn, String cantorOuBandaIn, int numTrilhasIn, String gravadoraIn){
        super(codBarraIn, nomeIn, anoIn, quantidadeIn);
        this.cantorOuBanda = cantorOuBandaIn;
        this.numTrilhas = numTrilhasIn;
        this.gravadora = gravadoraIn;
    }
}