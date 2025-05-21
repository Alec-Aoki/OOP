public class DVD extends Produto {
    String diretor;
    String idioma;
    String genero;
    String nacionalidade;

    public DVD(String codBarraIn, String nomeIn, int anoIn, int quantidadeIn, String diretorIn, String idiomaIn, String generoIn, String nacionalidadeIn){
        super(codBarraIn, nomeIn, anoIn, quantidadeIn, 3);
        this.diretor = diretorIn;
        this.idioma = idiomaIn;
        this.genero = generoIn;
        this.nacionalidade = nacionalidadeIn;
    }

    @Override
    public String toString(boolean mostrarQuant){
        String DVDString = "";
        DVDString += "DVD\n";
        DVDString += "Código: ";
        DVDString += Long.parseLong(super.codBarra);
        DVDString += "\n";
        DVDString += "Título: ";
        DVDString += super.nome;
        DVDString += "\n";
        DVDString += "Diretor: ";
        DVDString += this.diretor;
        DVDString += "\n";
        DVDString += "Gênero: ";
        DVDString += this.genero;
        DVDString += "\n";
        DVDString += "Ano: ";
        DVDString += super.ano;
        DVDString += "\n";
        DVDString += "Nacionalidade: ";
        DVDString += this.nacionalidade;
        DVDString += "\n";
        DVDString += "Idioma: ";
        DVDString += this.idioma;
        DVDString += "\n";
        if(mostrarQuant){
            DVDString += "Quantidade: ";
            DVDString += super.quantidade;
            DVDString += "\n";
        }

        return DVDString;
    }
}