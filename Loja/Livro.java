public class Livro extends Produto {
    String autor;
    String editora;
    int edicao;
    int paginas;
    String idioma;

    public Livro(String codBarraIn, String nomeIn, int anoIn, int quantidadeIn, String autorIn, String editoraIn, int edicaoIn, int paginasIn, String idiomaIn){
        super(codBarraIn, nomeIn, anoIn, quantidadeIn, 1);
        this.autor = autorIn;
        this.editora = editoraIn;
        this.edicao = edicaoIn;
        this.paginas = paginasIn;
        this.idioma = idiomaIn;
    }

    @Override
    public String toString(boolean mostrarQuant){
        String livroString = "";
        livroString += "Livro\n";
        livroString += "Código: ";
        livroString += Long.parseLong(super.codBarra);
        livroString += "\n";
        livroString += "Título: ";
        livroString += super.nome;
        livroString += "\n";
        livroString += "Autor: ";
        livroString += this.autor;
        livroString += "\n";
        livroString += "Editora: ";
        livroString += this.editora;
        livroString += "\n";
        livroString += "Edição: ";
        livroString += this.edicao;
        livroString += "\n";
        livroString += "Ano: ";
        livroString += super.ano;
        livroString += "\n";
        livroString += "Páginas: ";
        livroString += this.paginas;
        livroString += "\n";
        livroString += "Idioma: ";
        livroString += this.idioma;
        livroString += "\n";
        if(mostrarQuant){
            livroString += "Quantidade: ";
            livroString += super.quantidade;
            livroString += "\n";
        }

        return livroString;
    }
}