public class Livro extends Produto {
    String autor;
    String editora;
    int edicao;
    int paginas;
    String idioma;

    public Livro(int codBarraIn, String nomeIn, int anoIn, int quantidadeIn, String autorIn, String editoraIn, int edicaoIn, int paginasIn, String idiomaIn){
        super(codBarraIn, nomeIn, anoIn, quantidadeIn);
        this.autor = autorIn;
        this.editora = editoraIn;
        this.edicao = edicaoIn;
        this.paginas = paginasIn;
        this.idioma = idiomaIn;
    }
}