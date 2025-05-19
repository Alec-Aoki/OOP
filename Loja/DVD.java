public class DVD extends Produto {
    String diretor;
    String idioma;
    String genero;
    String nacionalidade;

    public DVD(int codBarraIn, String nomeIn, int anoIn, int quantidadeIn, String diretorIn, String idiomaIn, String generoIn, String nacionalidadeIn){
        super(codBarraIn, nomeIn, anoIn, quantidadeIn);
        this.diretor = diretorIn;
        this.idioma = idiomaIn;
        this.genero = generoIn;
        this.nacionalidade = nacionalidadeIn;
    }
}