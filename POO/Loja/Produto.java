public class Produto{
    protected String codBarra;
    protected String nome;
    protected int ano;
    protected int quantidade;
    protected int tipoProduto;
    
    public Produto (String codBarraIn, String nomeIn, int anoIn, int quantidadeIn, int tipoProdutoIn){
        this.codBarra = codBarraIn;
        this.nome = nomeIn;
        this.ano = anoIn;
        this.quantidade = quantidadeIn;
        this.tipoProduto = tipoProdutoIn;
    }

    public boolean addQuantidade (int quantidadeNova){
        this.quantidade += quantidadeNova;

        return true;
    }

    public boolean subQuantidade (int quantidadeNova){
        if(this.quantidade - quantidadeNova < 0) return false;

        // Else
        this.quantidade -= quantidadeNova;
        return true;
    }

    public String getcodBarra(){
        return this.codBarra;
    }

    public String getNome(){
        return this.nome;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public int getTipo(){
        return this.tipoProduto;
    }

    public String toString(boolean mostrarQuant){
        String produtoString = "";
        produtoString += "Produto\n";
        produtoString += "Código: ";
        produtoString += Long.parseLong(this.codBarra);
        produtoString += "\n";
        produtoString += "Título: ";
        produtoString += this.nome;
        produtoString += "\n";
        produtoString += "Ano: ";
        produtoString += this.ano;
        produtoString += "\n";
        if(mostrarQuant){
            produtoString += "Quantidade: ";
            produtoString += this.quantidade;
            produtoString += "\n";
        }

        return produtoString;
    }
}