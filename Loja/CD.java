public class CD extends Produto {
    String cantorOuBanda;
    int numTrilhas;
    String gravadora;

    public CD (String codBarraIn, String nomeIn, int anoIn, int quantidadeIn, String cantorOuBandaIn, int numTrilhasIn, String gravadoraIn){
        super(codBarraIn, nomeIn, anoIn, quantidadeIn, 2);
        this.cantorOuBanda = cantorOuBandaIn;
        this.numTrilhas = numTrilhasIn;
        this.gravadora = gravadoraIn;
    }

    @Override
    public String toString(boolean mostrarQuant){
        String CDString = "";
        CDString += "CD\n";
        CDString += "Código: ";
        CDString += Long.parseLong(super.codBarra);
        CDString += "\n";
        CDString += "Título: ";
        CDString += super.nome;
        CDString += "\n";
        CDString += "Banda: ";
        CDString += this.cantorOuBanda;
        CDString += "\n";
        CDString += "Gravadora: ";
        CDString += this.gravadora;
        CDString += "\n";
        CDString += "Ano: ";
        CDString += super.ano;
        CDString += "\n";
        CDString += "trilhas: ";
        CDString += this.numTrilhas;
        CDString += "\n";
        if(mostrarQuant){
            CDString += "Quantidade: ";
            CDString += super.quantidade;
            CDString += "\n";
        }

        return CDString;
    }
}