public class Produto{
    private int codBarra;
    private String nome;
    private int ano;
    private int quantidade;
    
    public Produto (int codBarraIn, String nomeIn, int anoIn, int quantidadeIn){
        this.codBarra = codBarraIn;
        this.nome = nomeIn;
        this.ano = anoIn;
        this.quantidade = quantidadeIn;
    }

    public void addQuantidade (int quantidadeNova){
        this.quantidade += quantidadeNova;
    }

    public void subQuantidade (int quantidadeNova){
        this.quantidade -= quantidadeNova;
    }

    public int getcodBarra(){
        return this.codBarra;
    }

    public String getNome(){
        return this.nome;
    }
}